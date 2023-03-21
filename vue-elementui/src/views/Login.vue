<template>
  <div style="width: 100%;height: 100vh;background-color: cornflowerblue ;overflow: hidden">
    <div style="width: 400px ; margin: 140px auto">
      <div style="color: aqua;font-size: 30px;text-align: center;padding: 40px">欢迎登陆本系统</div>
      <el-form ref="form" :model="form" size="default" :rules="rules">
<!--        注意，此处使用的是管理员登录，而不是用户，表单的名称应该注意-->
        <el-form-item prop="adminUser">
          <el-input placeholder="请输入用户名" prefix-icon="el-icon-search" v-model="form.adminUser" />
        </el-form-item>
        <el-form-item prop="adminPassword">
          <el-input placeholder="请输入密码" prefix-icon="el-icon-lock" v-model="form.adminPassword" show-password/>
        </el-form-item>
        <el-form-item>
          <el-button style="width: 100% " type="primary"  color="blue"  @click="login">登录</el-button>
        </el-form-item>
        <el-form-item>
          <el-button style="width: 100% " type="primary" color="red" @click="jumpToRegister">注册账号</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
import request from "@/utils/request";
import router from "@/router";

export default {
  name: "Login",
  data(){
    return{
      form:{},
      rules: {
        adminUser: [
          {required: true, message: '请输入用户名', trigger: 'blur'},
        ],
        adminPassword: [
          {required: true, message: '请输入密码', trigger: 'blur'},
        ],
      }
    }
  },
  created() {
    sessionStorage.removeItem("admin")
  },
  methods: {
    jumpToRegister(){
      router.push("/register")
    },
    login(){    //实现满足校验才发送登录请求
      this.$refs['form'].validate((valid) => {
        if(valid){
          request.post("/user/login",this.form).then(res =>{
            if(res.code === '200'){
              this.$message({
                type: "success",
                message: "登录成功",
              })
              sessionStorage.setItem("admin",JSON.stringify(res.data))   //缓存用户信息
              this.$router.push("/")  //登陆成功跳转页面
            }else {
              this.$message({
                type: "error",
                message: res.msg,
              })
            }
          })
        }
      })
      /*request.post("/user/login",this.form).then(res =>{
        if(res.code === '200'){
          this.$message({
            type: "success",
            message: "登录成功",
          })
          this.$router.push("/")  //登陆成功跳转页面
        }else {
          this.$message({
            type: "error",
            message: res.msg,
          })
        }
      })*/
    }
  }
}
</script>

<style scoped>

</style>
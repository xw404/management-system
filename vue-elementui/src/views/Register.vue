<template>
  <div style="width: 100%;height: 100vh;background-color: coral ;overflow: hidden">
    <div style="width: 400px ; margin: 140px auto">
      <div style="color: aqua;font-size: 30px;text-align: center;padding: 40px">欢迎注册本系统</div>
      <el-form ref="form" :model="form" size="default" :rules="rules">
        <!--        注意，此处使用的是管理员注册，而不是用户，表单的名称应该注意-->
        <el-form-item prop="adminUser">
          <el-input placeholder="请输入用户名" prefix-icon="el-icon-search" v-model="form.adminUser" />
        </el-form-item>
        <el-form-item prop="adminPassword">
          <el-input placeholder="请输入密码" prefix-icon="el-icon-lock" v-model="form.adminPassword" show-password/>
        </el-form-item>
        <el-form-item prop="confirm">
          <el-input placeholder="确认密码" prefix-icon="el-icon-lock" v-model="form.confirm" show-password/>
        </el-form-item>
        <el-form-item>
          <el-button style="width: 100% " type="primary" @click="register">注册</el-button>
        </el-form-item>
        <el-form-item>
          <el-button style="width: 100% " type="primary" @click="ReturnToLogin">返回登陆页面</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
import request from "@/utils/request";
import router from "@/router";

export default {
  name: "Register",
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
        confirm: [
          {required: true, message: '请确认密码', trigger: 'blur'},
        ],
      }
    }
  },
  methods: {
    ReturnToLogin(){
      router.push("/login")
    },
    register(){
      if(this.form.adminPassword !==this.form.confirm){
        this.$message({
          type: "error",
          message: "两次密码输入不一致",
        })
        return
      }
      this.$refs['form'].validate((valid) => {
        if(valid){
          request.post("/user/register",this.form).then(res =>{
            if(res.code === '200'){
              this.$message({
                type: "success",
                message: "注册成功",
              })
              this.$router.push("/login")  //成功跳转页面
            }else {
              this.$message({
                type: "error",
                message: res.msg,
              })
            }
          })
        }
      })
      /*request.post("/user/register",this.form).then(res =>{
        if(res.code === '200'){
          this.$message({
            type: "success",
            message: "注册成功",
          })
          this.$router.push("/login")  //成功跳转页面
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
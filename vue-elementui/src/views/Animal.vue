<template>
  <div style="padding: 10px">
    <!--    功能区域-->
    <div style="margin: 10px 0">
      <el-button type="primary" @click="add">新增</el-button>
<!--      <el-button type="primary">导入</el-button>-->
<!--      <el-button type="primary">导出</el-button>-->
    </div>
    <!--    搜索区域-->
    <div style="margin: 10px 0">
      <el-input v-model="search" placeholder="请输入关键字" style = "width: 20%" clearable/>
      <el-button type="primary" style = "margin-left: 5px" @click="load">查询</el-button>
    </div>
    <el-table :data="tableData" border stripe style="width: 100%">
      <el-table-column prop="id" label="ID" sortable/>
      <el-table-column prop="name" label="宠物名"/>
      <el-table-column prop="kind" label="种类"/>
      <el-table-column prop="love" label="爱心指数"/>
      <el-table-column prop="userId" label="领养者"/>
      <el-table-column prop="createTime" label="xx日期"/>

      <el-table-column label="操作" >
        <template #default = "scope">
          <el-button size="small" @click="handleEdit(scope.row)">编辑</el-button>

          <el-popconfirm title="确认删除吗" @confirm="handleDelete(scope.row.id)">
            <template #reference>
              <el-button size="small" type="danger">删除</el-button>
            </template>
          </el-popconfirm>
        </template>
      </el-table-column>
    </el-table>

    <div style="margin: 10px 0">
      <el-pagination
          @size-change="HandleSizeChange"
          @current-change="HandleCurrentChange"
          :current-page="currentPage"
          :page-sizes="[5, 10, 15]"
          :page-size="pageSize"
          layout="total, sizes, prev, pager, next, jumper"
          :total="total">
      </el-pagination>

      <el-dialog v-model="dialogVisible" title="新增">
        <el-form :model="form" label-width="120px">
          <el-form-item label="宠物名">
            <el-input v-model="form.name" style="width: 80%"/>
          </el-form-item>
          <el-form-item label="种类">
            <el-input v-model="form.kind" style="width: 80%"/>
          </el-form-item>
          <el-form-item label="爱心指数">
            <el-input v-model="form.love" style="width: 80%"/>
          </el-form-item>
          <el-form-item label="领养者ID">
            <el-input v-model="form.userId" style="width: 80%"/>
          </el-form-item>
          <el-form-item label="xx测试日期表单">
            <el-date-picker v-model="form.createTime" value-format="YYYY-MM-DD" type="date" style="width: 80%" clearable>

            </el-date-picker>
          </el-form-item>
        </el-form>
        <template #footer>
      <span class="dialog-footer">
        <el-button @click="dialogVisible = false">取消</el-button>
        <el-button type="primary" @click="save">确定</el-button>
      </span>
        </template>
      </el-dialog>
    </div>
  </div>
</template>

<script>

import request from "@/utils/request";

export default {
  name: 'Animal',
  components: {},
  data() {
    return {
      form:{},
      dialogVisible:false,
      search: '',
      currentPage: 1,
      pageSize: 10,
      total:0,
      tableData: []
    }
  },
  created() {
    this.load()
  },
  methods: {
    load(){
      request.get("/animal",{
        params:{
          pageNum:this.currentPage,
          pageSize:this.pageSize,
          search: this.search,
        }
      }).then(res => {
        console.log(res)
        this.tableData=res.data.records;
        this.total=res.data.total;
      })
    },
    save(){
      if(this.form.id){  //更新
        request.put("/animal",this.form).then(res => {
          console.log(res)
          if(res.code === '200'){
            this.$message({
              type: "success",
              message: "更新成功",
            })
          }else {
            this.$message({
              type: "error",
              message: "更新失败",
            })
          }
          this.load()//刷新
          this.dialogVisible =false  //关闭弹窗
        })
      }else {
        //新增
        request.post("/animal",this.form).then(res => {
          console.log(res)
          if(res.code === '200'){
            this.$message({
              type: "success",
              message: "更新成功",
            })
          }else {
            this.$message({
              type: "error",
              message: "更新失败",
            })
          }
          this.load()//刷新
          this.dialogVisible =false  //关闭弹窗
        })
      }
    },
    add(){
      this.dialogVisible=true
      this.form={}
    },
    handleEdit(row){
      this.form = JSON.parse(JSON.stringify(row))
      this.dialogVisible=true
    },
    handleDelete(id){
      console.log(id)
      request.delete("/animal/"+id).then(res => {
        if(res.code === '200'){
          this.$message({
            type: "success",
            message: "删除成功",
          })
        }else {
          this.$message({
            type: "error",
            message: "删除失败",
          })
        }
        this.load()//刷新
      })
    },
    HandleSizeChange(pageSize){  //改变页码
      this.pageSize=pageSize
      this.load()
    },
    HandleCurrentChange(pageNum){  //该表当前页触发
      this.currentPage =pageNum
      this.load()
    },

  }
}
</script>

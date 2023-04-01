<template>
  <div style="height: 50px;line-height: 50px;border-bottom: 1px solid #ccc;display: flex">
    <div style="width: 200px;padding-left: 30px;font-weight: bold;color: brown">后台管理</div>
    <div style="flex: 1px"></div>
    <div style="width: 100px">
      <el-dropdown>
    <span class="el-dropdown-link" >
      设置
      <el-icon class="el-icon--right">
        <arrow-down />
      </el-icon>
    </span>
<!--        <span class="el-dropdown-link">
          {{admin.adminUser}}<i class="el-icon-arrow-down el-icon&#45;&#45;right"></i>
        </span>-->
        <template #dropdown>
          <el-dropdown-menu>
<!--            <el-dropdown-item>个人信息</el-dropdown-item>-->
            <el-dropdown-item @click="$router.push('/login')">退出登录</el-dropdown-item>
          </el-dropdown-menu>
        </template>
      </el-dropdown>
    </div>
  </div>
</template>

<script>
export default {
  name: "Header"
}
</script>

<style scoped>

</style>
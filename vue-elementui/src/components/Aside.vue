<template>
  <div>
    <el-menu text-color="green" background-color="pink"
        style="width: 200px;min-height: calc(100vh - 50px);"

        default-active="path"
        router
        class="el-menu-vertical-demo"
    >
      <el-sub-menu index="1">
          <template #title>后台管理</template>
          <el-menu-item index="/user" >用户管理</el-menu-item>
      </el-sub-menu>
      <el-menu-item index="/animal">宠物管理</el-menu-item>
<!--      <el-menu-item index="data">数据管理</el-menu-item>-->
<!--      <el-menu-item index="2">
        <el-icon><icon-menu/></el-icon>
        <span>导航二</span>
      </el-menu-item>
      <el-menu-item index="4">
        <el-icon><setting/></el-icon>
        <span>导航三</span>
      </el-menu-item>-->
    </el-menu>
  </div>
</template>

<script>
export default {
  name: "Aside",
  data() {
    return {
      path: this.$route.path     //设置默认高亮的菜单
    }
  },
  created() {
  }
}
</script>

<style scoped>

</style>
<template>
  <div>
    <!--搜索栏-->
    <el-card id="search">
      <el-row>
        <el-col :span="20">
          <el-input v-model="searchModel.username" placeholder="用户名" />
          <el-input v-model="searchModel.phone" placeholder="电话" />
          <el-button type="primary" round icon="el-icon-search">查询</el-button>
        </el-col>
        <el-col :span="4" align="right">
          <el-button type="primary" round icon="el-icon-plus" />
        </el-col>
      </el-row>
    </el-card>

    <!--结果列表-->
    <el-card>
      <el-table
        :data="userList"
        stripe
        style="width: 100%"
      >
        <el-table-column
          type="index"
          label="序号"
          width="80"
        />
        <el-table-column
          prop="id"
          label="用户id"
          width="180"
        />
        <el-table-column
          type="index"
          label="用户名"
          width="180"
        />
        <el-table-column
          prop="phone"
          label="电话"
          width="180"
        />
        <el-table-column
          prop="email"
          label="电子邮件"
        />
        <el-table-column
          label="操作"
          width="180"
        />
      </el-table>
    </el-card>

    <!--分页组件-->
    <el-pagination
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :current-page="searchModel.pageNo"
      :page-sizes="[5, 10, 20, 50]"
      :page-size="searchModel.pageSize"
      layout="total, sizes, prev, pager, next, jumper"
      :total="total"
    />
  </div>
</template>

<script>
export default {
  name: 'User',
  data() {
    return {
      total: 0,
      searchModel: {
        pageNo: 1,
        pageSize: 10
      },
      userList: []
    }
  },
  // methods: {
  //   handleSizeChange(){
  //
  //   },
  //   handleCurrentChange(){
  //
  //   }
  // }
}
</script>

<style>
#search .el-input{
  width: 200px;
  margin-right: 10px;
}
</style>

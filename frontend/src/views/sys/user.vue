<template>
  <div>
    <!--搜索栏-->
    <el-card id="search">
      <el-row>
        <el-col :span="20">
          <el-input v-model="searchModel.username" placeholder="用户名" clearable />
          <el-input v-model="searchModel.phone" placeholder="电话" clearable />
          <el-button type="primary" round icon="el-icon-search" @click="getUserList">查询</el-button>
        </el-col>
        <el-col :span="4" align="right">
          <el-button type="primary" round icon="el-icon-plus" @click="openEditUI" />
        </el-col>
      </el-row>
    </el-card>

    <!--结果列表-->
    <el-card>
      <el-table :data="userList" stripe style="width: 100%">
        <el-table-column type="index" label="序号" width="80">
          <template slot-scope="scope">
            {{ (searchModel.pageNo - 1) * searchModel.pageSize + scope.$index + 1 }}
          </template>
        </el-table-column>
        <el-table-column prop="id" label="用户id" width="180" />
        <el-table-column prop="username" label="用户名" width="180" />
        <el-table-column prop="phone" label="电话" width="180" />
        <el-table-column prop="email" label="电子邮件" />
        <el-table-column label="操作" width="180" />
      </el-table>
    </el-card>

    <!--分页组件-->
    <el-pagination
      :current-page="searchModel.pageNo"
      :page-sizes="[5, 10, 20, 50]"
      :page-size="searchModel.pageSize"
      layout="total, sizes, prev, pager, next, jumper"
      :total="total"
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
    />
    <!--用户信息编辑对话框-->
    <el-dialog :visible.sync="dialogFormVisible" :title="title" @close="clearForm">
      <el-form ref="userFormRef" :model="userForm" :rules="rules">
        <el-form-item label="用户名" prop="username" :label-width="formLabelWidth">
          <el-input v-model="userForm.username" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="password" :label-width="formLabelWidth">
          <el-input v-model="userForm.password" type="password" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="电话" :label-width="formLabelWidth">
          <el-input v-model="userForm.phone" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="邮箱" prop="email" :label-width="formLabelWidth">
          <el-input v-model="userForm.email" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="用户状态" :label-width="formLabelWidth">
          <el-switch v-model="userForm.status" active-value="1" inactive-value="0"></el-switch>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="saveUser">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import userApi from '@/api/userMange'

export default {
  data() {
    // 邮箱验证
    var checkEmail = (rule, value, callback) => {
      var reg =
        /^[a-zA-Z0-9]+([-_.][a-zA-Z0-9]+)*@[a-zA-Z0-9]+([-_.][a-zA-Z0-9]+)*\.[a-z]{2,}$/
      if (!reg.test(value)) {
        return callback(new Error('邮箱格式错误'))
      }
      callback()
    }
    return {
      formLabelWidth: '130px',
      userForm: {},
      dialogFormVisible: false,
      title: '',
      total: 0,
      searchModel: {
        pageNo: 1,
        pageSize: 10
      },
      userList: [],
      rules: {
        username: [
          { required: true, message: '请输入用户名', trigger: 'blur' },
          { min: 3, max: 50, message: '长度在3到50个字符', trigger: 'blur' }
        ],
        password: [
          { required: true, message: '请输入登录初始密码', trigger: 'blur' },
          { min: 6, max: 16, message: '长度在6到16个字符', trigger: 'blur' }
        ],
        email: [
          { required: true, message: '请输入电子邮件', trigger: 'blur' },
          { validator: checkEmail, trigger: 'blur' }
        ]
      }
    }
  },
  created() {
    this.getUserList()
  },
  methods: {
    saveUser() {
      // 先触发表单验证
      this.$refs.userFormRef.validate((valid) => {
        if (valid) {
          // 提交请求给后端
          userApi.addUser(this.userForm).then(response => {
            // 成功的提示
            this.$message({
              message: response.message,
              type: 'success'
            })
            // 关闭对话框
            this.dialogFormVisible = false
            // 刷新表格
            this.getUserList()
          })
        } else {
          console.log('error submit!!!')
          return false
        }
      })
    },
    clearForm() {
      this.userForm = {}
      this.$refs.userFormRef.clearValidate()
    },
    openEditUI() {
      this.title = '新增用户'
      this.dialogFormVisible = true
    },
    handleSizeChange(pageSize) {
      this.searchModel.pageSize = pageSize
      this.getUserList()
    },
    handleCurrentChange(pageNo) {
      this.searchModel.pageNo = pageNo
      this.getUserList()
    },
    getUserList(searchModel) {
      userApi.getUserList(this.searchModel).then((response) => {
        this.userList = response.data.rows
        this.total = response.data.total
        console.log(this.searchModel.pageNo)
      })
    }
  }
}
</script>

<style>
#search .el-input {
  width: 200px;
  margin-right: 10px;
}

.el-dialog .el-input {
  width: 85%;
}
</style>

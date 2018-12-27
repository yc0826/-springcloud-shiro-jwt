<template>
  <div>
    <el-form :model="searchForm">
      <el-row :gutter="20">
        <el-col :span="4">
          <el-form-item
            label="姓名"
            label-width="65px"
          >
            <el-input
              v-model="searchForm.userName"
              autocomplete="off"
            />
          </el-form-item>
        </el-col>
        <el-col :span="4">
          <el-form-item
            label="手机号"
            label-width="65px"
          >
            <el-input
              v-model="searchForm.mobileNo"
              autocomplete="off"
            />
          </el-form-item>
        </el-col>
        <el-col :span="4">
          <div class="grid-content" />
        </el-col>
        <el-col :span="4">
          <el-button
            type="primary"
            @click="dialogFormVisible = false"
          >查 询</el-button>
          <el-button
            type="primary"
            @click="dialogFormVisible = false"
          >清 空</el-button>
          <el-button
            type="primary"
            @click="dialogFormVisible = false"
          >新 增</el-button>
        </el-col>
      </el-row>
    </el-form>
    <el-table
      :data="tableData"
      style="width: 100%"
    >
      <el-table-column
        type="index"
        width="50"
      />
      <el-table-column
        prop="subsyNames"
        label="会所"
      />
      <el-table-column
        prop="userName"
        label="姓名"
      />
      <el-table-column
        prop="mobile"
        label="手机号"
      />
      <el-table-column
        prop="sex"
        label="性别"
      />
      <el-table-column
        prop="updTime"
        label="更新时间"
      />
      <el-table-column
        fixed="right"
        label="操作"
        width="100"
      >
        <template slot-scope="scope">
          <el-button
            type="text"
            size="small"
          >查看</el-button>
          <el-button
            type="text"
            size="small"
            @click="dialogFormVisible = true"
          >编辑</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
      :page-size="10"
      :total="total"
      :pager-count="11"
      :current-page="currentPage"
      layout="prev, pager, next"
      @current-change="currentChange"
    />

    <el-dialog
      :visible.sync="dialogFormVisible"
      title="收货地址"
    >
      <el-form :model="form">
        <el-row :gutter="20">
          <el-col :span="10">
            <el-form-item
              label="姓"
              label-width="65px"
            >
              <el-input
                v-model="form.lastName"
                autocomplete="off"
              />
            </el-form-item>
          </el-col>
          <el-col :span="10">
            <el-form-item
              label="名"
              label-width="65px"
            >
              <el-input
                v-model="form.firstName"
                autocomplete="off"
              />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row :gutter="20">
          <el-col :span="10">
            <el-form-item
              label="登陆名"
              label-width="65px"
            >
              <el-input
                v-model="form.lastName"
                autocomplete="off"
              />
            </el-form-item>
          </el-col>
          <el-col :span="10">
            <el-form-item
              label="手机号"
              label-width="65px"
            >
              <el-input
                v-model="form.firstName"
                autocomplete="off"
              />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row :gutter="20">
          <el-col :span="10">
            <el-form-item
              label="密码"
              label-width="65px"
            >
              <el-input
                v-model="form.password"
                type="password"
                autocomplete="off"
              />
            </el-form-item>
          </el-col>
          <el-col :span="10">
            <el-form-item
              label="手机号"
              label-width="65px"
            >
              <el-input
                v-model="form.mobile"
                autocomplete="off"
              />
            </el-form-item>
          </el-col>
        </el-row>
      </el-form>

      <div
        slot="footer"
        class="dialog-footer"
      >
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button
          type="primary"
          @click="dialogFormVisible = false"
        >确 定</el-button>
      </div>
    </el-dialog>

  </div>
</template>

<script>
import request from '../../../utils/request'

export default {
  data() {
    return {
      total: 50,
      pageSize: 10,
      currentPage: 1,
      tableData: null,
      searchForm: {
        userName: ''
      },
      form: {
        lastName: '',
        firstName: '',
        password: ''
      },
      dialogFormVisible: false,
      formLabelWidth: '120px'
    }
  },
  created() {
    this.fetchData()
  },
  methods: {
    currentChange(currentPage) {
      this.currentPage = currentPage
      this.fetchData()
    },
    fetchData() {
      this.listLoading = true
      return request({
        url: '/user/getInterUserListData',
        method: 'get',
        params: {
          currentPage: this.currentPage,
          pageSize: this.pageSize
        }
      }).then(response => {
        this.tableData = response.data.userList
        this.total = response.data.userCount
        this.listLoading = false
      })
    }
  }
}
</script>
<style lang='scss' scoped>
</style>

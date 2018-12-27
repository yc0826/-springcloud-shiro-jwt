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
        <el-form-item
          :label-width="formLabelWidth"
          label="活动名称"
        >
          <el-input
            v-model="form.name"
            autocomplete="off"
          />
        </el-form-item>
        <el-form-item
          :label-width="formLabelWidth"
          label="活动区域"
        >
          <el-select
            v-model="form.region"
            placeholder="请选择活动区域"
          >
            <el-option
              label="区域一"
              value="shanghai"
            />
            <el-option
              label="区域二"
              value="beijing"
            />
          </el-select>
        </el-form-item>
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
        name: '',
        region: '',
        date1: '',
        date2: '',
        delivery: false,
        type: [],
        resource: '',
        desc: ''
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
.el-row {
  margin-bottom: 20px;
  &:last-child {
    margin-bottom: 0;
  }
}
.el-col {
  border-radius: 4px;
}
.bg-purple-dark {
  background: #99a9bf;
}
.bg-purple {
  background: #d3dce6;
}
.bg-purple-light {
  background: #e5e9f2;
}
.grid-content {
  border-radius: 4px;
  min-height: 36px;
}
.row-bg {
  padding: 10px 0;
  background-color: #f9fafc;
}
</style>

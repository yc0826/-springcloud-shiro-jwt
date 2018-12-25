<template>
  <div>
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
</style>

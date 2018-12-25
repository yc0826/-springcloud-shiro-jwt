<!--  -->
<template>
  <div>
    授权管理
    <el-table
      :data="tableData"
      style="width: 100%"
    >
      <el-table-column
        type="index"
        width="50"
      />
      <el-table-column
        prop="subsyName"
        label="会所"
      />
      <el-table-column
        prop="name"
        label="姓名"
      />
      <el-table-column
        prop="rollNames"
        label="手机号"
      />
      <el-table-column
        prop="mobile"
        label="性别"
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
  </div>
</template>

<script>
import request from '../../../utils/request'
export default {
  components: {},
  data() {
    return {
      total: 50,
      pageSize: 10,
      currentPage: 1,
      tableData: null,
      formLabelWidth: '120px'
    }
  },
  created() {
    this.fetchData()
  },
  methods: { currentChange(currentPage) {
    this.currentPage = currentPage
    this.fetchData()
  },
  fetchData() {
    this.listLoading = true
    return request({
      url: '/authorization/getAuthorizationList',
      method: 'get',
      params: {
        currentPage: this.currentPage,
        pageSize: this.pageSize
      }
    }).then(response => {
      this.tableData = response.data.authorizationList
      // this.total = response.data.count
      this.listLoading = false
    })
  } }
}
</script>
<style lang='scss' scoped>
</style>

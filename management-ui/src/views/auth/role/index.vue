<!--  -->
<template>
  <div>
    角色管理
    <el-table
      :data="tableData"
      style="width: 100%"
    >
      <el-table-column
        type="index"
        width="50"
      />
      <el-table-column
        prop="rollName"
        label="角色名称"
        width="300"
      />
      <el-table-column
        prop="rollDesc"
        label="角色描述"
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
            @click="initEditMenu()"
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
      title="编辑菜单"
    >
      <el-form :model="form">
        <el-form-item
          :label-width="formLabelWidth"
          label="角色名称："
        >
          <el-input
            v-model="form.rollName"
            auto-complete="off"
            size="small"
          />
        </el-form-item>
        <el-form-item
          :label-width="formLabelWidth"
          label="角色描述："
        >
          <el-input
            v-model="form.rollDesc"
            size="small"
            auto-complete="off"
          />
        </el-form-item>
        <el-form-item
          :label-width="formLabelWidth"
          label="资源列表："
        >
          <el-tree
            :data="form.resource"
            :props="form.defaultProps"
            :default-checked-keys="form.checkedKeys"
            :default-expanded-keys="form.expandedKeys"
            show-checkbox
            node-key="id"
          />
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
  components: {},
  data() {
    return {
      total: 50,
      pageSize: 10,
      currentPage: 1,
      tableData: null,
      form: {
        resource: null,
        expandedKeys: null,
        rollName: null,
        rollDesc: null,
        defaultProps: {
          children: 'children',
          label: 'label'
        },
        checkedKeys: null
      },
      dialogFormVisible: false,
      formLabelWidth: '120px'

    }
  },
  created() {
    this.fetchData()
  },
  mounted() { },
  methods: {
    initEditMenu() {
      this.listLoading = true

      return request({
        url: '/role/findMenus',
        method: 'get',
        params: {
          roleCode: 'admin'
        }
      }).then(response => {
        this.form.resource = response.data.menus
        this.form.checkedKeys = response.data.checkedNodes
        this.form.expandedKeys = ['1']
        this.listLoading = false
        this.dialogFormVisible = true
      })
    },
    currentChange(currentPage) {
      this.currentPage = currentPage
      this.fetchData()
    },
    fetchData() {
      this.listLoading = true
      return request({
        url: '/role/roleList',
        method: 'get',
        params: {
          currentPage: this.currentPage,
          pageSize: this.pageSize
        }
      }).then(response => {
        this.tableData = response.data.roleList
        this.total = response.data.roleCount
        this.listLoading = false
      })
    }
  }
}
</script>
<style lang='scss' scoped>
</style>

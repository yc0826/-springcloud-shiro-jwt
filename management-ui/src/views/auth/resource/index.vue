<!--  -->
<template>
  <el-table
    :data="model.menus"
    border
    max-height="800"
  >
    <el-table-tree-column
      :expand-all="!1"
      fixed
      prop="label"
      label="名称"
      width="320"
      header-align="center"
    />
    <el-table-column
      :show-overflow-tooltip="true"
      prop="typeName"
      label="类型"
      width="100"
      align="center"
    />
    <el-table-column
      :show-overflow-tooltip="true"
      prop="path"
      label="路径"
      width="150"
      align="center"
    />
    <el-table-column
      :show-overflow-tooltip="true"
      prop="componentPath"
      label="vue组件路径"
      width="300"
      align="center"
    />
    <el-table-column
      :show-overflow-tooltip="true"
      prop="permission"
      label="权限字符串"
      width="300"
      align="center"
    />
    <el-table-column
      :show-overflow-tooltip="true"
      fixed="right"
      label="操作"
      width="400"
      align="center"
    >
      <template slot-scope="scope">
        <el-button
          type="text"
          size="small"
          @click="handleClick(scope.row)"
        >新增</el-button>
        <el-button
          type="text"
          size="small"
        >编辑</el-button>
        <el-button
          type="text"
          size="small"
        >删除</el-button>
      </template>
    </el-table-column>
  </el-table>
</template>

<script>
import request from '../../../utils/request'
export default {
  data() {
    return {
      model: {
        menus: null
      }
    }
  },
  created() {
    this.fetchData()
  },
  methods: {
    handleNodeClick(data) {
      console.log(data)
    },

    fetchData() {
      this.listLoading = true
      return request({
        url: '/resource/findMenus',
        method: 'get'
      }).then(response => {
        this.model.menus = response.data
        this.listLoading = false
      })
    }

  }
}
</script>
<style lang='scss' scoped>
body p {
  background-color: #f5f5f5;
  border-left: 4px solid #ccc;
  line-height: 40px;
  padding-left: 10px;
}

.icon-file {
  padding-right: 7px;
  padding-left: 18px;
}

.icon-folder,
.icon-folder-open {
  padding-left: 7px;
  padding-right: 7px;
}
</style>

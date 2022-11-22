<template>
  <div>
    <!-- 搜索表单 -->
    <div style="margin-bottom: 20px">
      <el-input style="width: 240px" placeholder="请输入分类名称" v-model="params.username"></el-input>
      <el-button style="margin-left: 5px" type="primary" @click="load"><i class="el-icon-search">搜索</i></el-button>
      <el-button style="margin-left: 5px" type="warning" @click="reset"><i class="el-icon-refresh">重置</i></el-button>
    </div>
    <!-- 表格 -->
    <el-table :data="tableData" stripe>
      <el-table-column prop="id" label="编号" width="80"></el-table-column>
      <el-table-column prop="name" label="名称"></el-table-column>
      <el-table-column prop="remark" label="备注"></el-table-column>
      <el-table-column prop="createtime" label="创建时间"></el-table-column>
      <el-table-column prop="updatetime" label="更新时间"></el-table-column>
      <el-table-column label="操作" width="230">
        <template v-slot="scope">
          <!-- scope.row就是当前行数据 -->
          <!-- 跳转页面的同时，把id带到编辑页面 -->
          <el-button type="primary" @click="$router.push('/editCategory?id=' + scope.row.id)">编辑</el-button>
          <el-popconfirm
              style="margin-left: 5px"
              title="您确定删除这行数据吗？"
              @confirm="del(scope.row.id)"
          >
            <el-button type="danger" slot="reference">删除</el-button>
          </el-popconfirm>
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页 -->
    <div style="margin-top: 20px">
      <el-pagination
          background
          :current-page="params.pageNum"
          :page-size="params.pageSize"
          layout="prev, pager, next"
          @current-change="handleCurrentChange"
          :total="total">
      </el-pagination>
    </div>

  </div>
</template>


<script>
import request from "@/utils/request";
import Cookies from "js-cookie";

export default {
  name: 'CategoryList',
  data() {
    return {
      tableData: [],
      total: 0,
      category: Cookies.get("category") ? JSON.parse(Cookies.get('category')) : {},
      params: {
        pageNum: 1,
        pageSize: 10,
        name: '',
      },
    }
  },
  created() {
    this.load();
  },
  methods: {
    load() {
      request.get('/category/page', {
        params: this.params
      }).then(res => {
        console.log(res)
        if (res.code === '200') {
          this.tableData = res.data.list
          this.total = res.data.total
        }
      })
    },
    reset() {
      this.params = {
        pageNum: 1,
        pageSize: 10,
        username: '',
        phone: '',
        email: '',
      }
      this.load()
    },
    handleCurrentChange(pageNum) {
      //点击分页按钮触发分页
      this.params.pageNum = pageNum
      this.load()
    },
    del(id) {
      request.delete("/category/delete/" + id).then(res => {
        if (res.code === '200') {
          this.$notify.success("删除成功")
          //删除后自动刷新
          this.load()
        } else {
          this.$notify.error(res.msg)
        }
      })
    }
  }
}
</script>

<style scoped>

</style>
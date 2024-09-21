<template>
  <div ref="headerTopContainer">
    <slot name="table-top">
      <div class="header-container">
        <el-breadcrumb :separator-icon="ArrowRight" class="header-left header-breadcrumb">
          <el-breadcrumb-item :to="{ path: '/' }">HomeView</el-breadcrumb-item>
          <el-breadcrumb-item>management</el-breadcrumb-item>
          <el-breadcrumb-item>students</el-breadcrumb-item>
        </el-breadcrumb>

        <div class="header-right fun-group">
          <el-button :icon="Delete" type="danger" class="mx-4 btn btn-item">全部删除</el-button>
          <el-button :icon="Refresh" class="mx-4 btn btn-item"/>
          <el-button :icon="Filter" class="mx-4 btn btn-item">过滤条件</el-button>

          <el-button-group class="header-right-btn-group">
            <el-button class="btn btn-item" :icon="Edit">导出</el-button>
            <el-button class="btn btn-item" :icon="Share">分享</el-button>
          </el-button-group>

          <el-button class="btn btn-item" type="primary" :icon="Edit">添加 / 创建</el-button>
        </div>
      </div>
    </slot>
  </div>
  <slot name="table-content">
    <el-table ref="commonTableRef" :data="tableData" style="width: 100%" :height="tableHeight"
              stripe border highlight-current-row :row-key="tableMeta.rowKey"

    >
      <el-table-column type="selection" width="55"/>
      <el-table-column v-for="(col,index) in column" :key="index"
                       :label="col.title" :width="col.width" :min-width="col.minWidth"
                       :sortable="col.sortable" :prop="col.dataIndex" :align="col.align"
      >
        <template v-if="col.slotName==='operator'" #default="{row,$index,cellIndex}">
          <slot name="operator" :row="row" :$index="$index" :cellIndex="cellIndex">
            <el-button type="primary">编辑</el-button>
            <el-button type="danger">删除</el-button>
          </slot>
        </template>

        <template v-else-if="col.slotName" #default="{row,$index,cellIndex}">
          <slot :name="col.slotName" :row="row" :$index="$index" :cellIndex="cellIndex"/>
        </template>


      </el-table-column>
      <template #empty>
        <slot name="empty">
          {{ '' + '数据为空' }}
        </slot>
      </template>

    </el-table>
  </slot>
  <div class="tableFooterContainer">
    <slot name="table-footer">
      <el-pagination layout="prev, pager, next" v-model="_pagination"
                     :page-sizes="[20, 50, 100]"
                     :total="_pagination.total"/>
    </slot>
  </div>
  <el-button @click="tt">ss</el-button>
</template>

<script setup lang="ts">

import {ArrowRight, Delete, Edit, Share, Refresh, Filter} from "@element-plus/icons-vue";
import {useWindowStore} from "@/store";
import {computed, ref, onMounted} from "vue";
import {useResizeObserver} from '@vueuse/core'
import * as _ from "lodash-es"
import {ElTable, ElTableColumn,} from "element-plus";
import {CommonTableProps} from "@/components/CommonTableComponent/CommonTableType.ts";

const commonTableRef = ref<InstanceType<typeof ElTable>>()


const headerTopContainerRef = ref<HTMLElement | null>(null)
const tableTopHeight = ref(72)

//表格顶部 高度
useResizeObserver(headerTopContainerRef, (entries) => {
  const entry = entries[0]
  const {height} = entry.contentRect
  tableTopHeight.value = height
})

const windowStore = useWindowStore()

function tt() {
  console.log(commonTableRef.value?.getSelectionRows())
}

// 用于存储初始值
const tableHeight = ref(300);

const emit = defineEmits(['update:pagination', "update:selectionList"])


const props = withDefaults(
    defineProps<CommonTableProps>(), {
      tableMeta: () => ({
        title: '默认标题',
        onlyRead: false,
        rowKey: 'id'
      }),
      tableData: () => [],
      column: () => [],
      pagination: () => ({
        pageSize: 10,
        currentPage: 1,
        total: 100
      })
    }
)


const _pagination = computed({
  get: () => props.pagination,
  set: (val) => emit('update:pagination', val)
})
const _selectionList = computed({
  get: () => commonTableRef.value?.getSelectionRows(),
  set: (val) => {
    emit('update:selectionList')
    commonTableRef.value?.toggleRowSelection(val)
  }
})

const getTableHeightInitialValue = () => {
  const windowHeight = windowStore.window.windowHeight;
  const footerHeight = windowStore.window.layout.footer;
  const headerHeight = windowStore.window.layout.header;
  tableHeight.value = windowHeight - footerHeight - headerHeight - tableTopHeight.value;
}

onMounted(() => {
  getTableHeightInitialValue();
});
</script>
<style scoped lang="scss">
@use "@/assets/AtomCss/index";

.header-container {
  display: flex;
  justify-content: space-between;
}

</style>

<template>
  <div class="common-layout" ref="resizableWindowElement">
    <el-container>
      <el-aside width="200px" ref="asideRef">
        <router-view name="globalLayoutAside"/>
      </el-aside>
      <el-container>
        <el-header ref="headerRef">
          <router-view name="globalLayoutHeader"/>
        </el-header>
        <el-main ref="contentRef">
          <router-view/>
        </el-main>
        <el-footer ref="footerRef">
          <router-view name="globalLayoutFooter"/>
        </el-footer>
        {{ windowStore.window.windowHeight }}
        {{ windowStore.window.windowWidth }}
        {{ windowStore.window.layout }}
      </el-container>
    </el-container>
  </div>
</template>


<script setup lang="ts">
import {ref} from 'vue'
import {useWindowStore} from "@/store";
import {useResizeObserver} from '@vueuse/core'

const windowStore = useWindowStore()

const resizableWindowElement = ref<HTMLElement | null>(null)
const asideRef = ref<HTMLElement | null>(null)
const headerRef = ref<HTMLElement | null>(null)
const contentRef = ref<HTMLElement | null>(null)
const footerRef = ref<HTMLElement | null>(null)
//全局窗口大小
useResizeObserver(resizableWindowElement, (entries) => {
  const entry = entries[0]
  const {width, height} = entry.contentRect
  windowStore.setWindowSize({width, height})
})

// 侧边栏大小
useResizeObserver(asideRef, (entries) => {
  const entry = entries[0]
  const {width} = entry.contentRect
  windowStore.setLayoutAside(width)
})

// 头部大小
useResizeObserver(headerRef, (entries) => {
  const entry = entries[0]
  const {height} = entry.contentRect
  windowStore.setLayoutHeader(height)
})

// 内容大小
useResizeObserver(contentRef, (entries) => {
  const entry = entries[0]
  const {height} = entry.contentRect
  windowStore.setLayoutContent(height)
})

// 底部大小
useResizeObserver(footerRef, (entries) => {
  const entry = entries[0]
  const {height} = entry.contentRect
  windowStore.setLayoutFooter(height)
})

</script>
<style scoped>
.common-layout {
  width: 100vw;
  height: 100vh;
  overflow: auto;
}

:deep(.el-aside) {
  height: 100vh;
}
</style>

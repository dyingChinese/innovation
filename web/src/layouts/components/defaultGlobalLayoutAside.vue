<template>
  <el-menu active-text-color="#404040" background-color="#f6f7f9" class="el-menu-vertical-demo"
           :default-active="activeIndex" router text-color="#404040" @select="handleSelect">
    <el-menu-item index="/">
      <el-icon>
        <HomeFilled/>
      </el-icon>
      <span>首页</span>
    </el-menu-item>
  </el-menu>
  <!--  <el-menu-->
  <!--      default-active="2"-->
  <!--      class="el-menu-vertical-demo"-->
  <!--  >-->
  <!--    <el-sub-menu index="1">-->
  <!--      <template #title>-->
  <!--        <el-icon><location /></el-icon>-->
  <!--        <span>Navigator One</span>-->
  <!--      </template>-->
  <!--      <el-menu-item-group title="Group One">-->
  <!--        <el-menu-item index="1-1">item one</el-menu-item>-->
  <!--        <el-menu-item index="1-2">item two</el-menu-item>-->
  <!--      </el-menu-item-group>-->
  <!--      <el-menu-item-group title="Group Two">-->
  <!--        <el-menu-item index="1-3">item three</el-menu-item>-->
  <!--      </el-menu-item-group>-->
  <!--      <el-sub-menu index="1-4">-->
  <!--        <template #title>item four</template>-->
  <!--        <el-menu-item index="1-4-1">item one</el-menu-item>-->
  <!--      </el-sub-menu>-->
  <!--    </el-sub-menu>-->
  <!--    <el-menu-item index="2">-->
  <!--      <el-icon><icon-menu /></el-icon>-->
  <!--      <span>Navigator Two</span>-->
  <!--    </el-menu-item>-->
  <!--    <el-menu-item index="3" disabled>-->
  <!--      <el-icon><document /></el-icon>-->
  <!--      <span>Navigator Three</span>-->
  <!--    </el-menu-item>-->
  <!--    <el-menu-item index="4">-->
  <!--      <el-icon><setting /></el-icon>-->
  <!--      <span>Navigator Four</span>-->
  <!--    </el-menu-item>-->
  <!--  </el-menu>-->
</template>

<script setup lang="ts">
import {useRouter} from "vue-router"
import {computed} from "vue";

const router = useRouter()


const activeIndex = computed(() => useRouter().currentRoute.value.path)
const handleSelect = (key: string, keyPath: string[]) => {
  console.log(key, keyPath)
}
</script>
<style scoped lang="scss">
.el-menu-vertical-demo {

  height: 100%;
  overflow-y: auto;
}
</style>
<style>

</style>

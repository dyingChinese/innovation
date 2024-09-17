<script setup lang="ts">
import {computed} from "vue";
import {useRootStore} from "@/store/index.js";

const rootStore = useRootStore();
const size = rootStore.global.size;

const locale = computed(() => {
  if (rootStore.global.locale === 'zh-CN') {
    return import('element-plus/es/locale/lang/zh-cn')
  } else if (rootStore.global.locale === 'en-US') {
    return import('element-plus/es/locale/lang/en')
  }
})

// import { Theme, getTheme, setTheme } from '../utils/theme';
//
// const themeConfig = ref<Theme>(Object.assign({}, getTheme()));
//
// const updateTheme = () => setTheme(themeConfig.value);

</script>

<template>
  <el-config-provider :size="size" :locale="locale">
    <router-view />
  </el-config-provider>
</template>

<style scoped>


</style>

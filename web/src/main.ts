import {createApp} from 'vue'


import ElementPlus from 'element-plus'
import * as ElementPlusIconsVue from '@element-plus/icons-vue'
// import "~/theme/element-variables.scss"
import 'element-plus/dist/index.css' // 引入element-plus样式
import './style.css'// 引入全局样式

import router from './router'; // 引入路由配置
// import observer from './utils/observer'; // 引入全局监听器(改为VueHooks useResizesObserver)
import { MotionPlugin } from '@vueuse/motion'
import { GesturePlugin } from '@vueuse/gesture'

import {createPinia} from "pinia";// 引入pinia
import piniaPluginPersistedstate from 'pinia-plugin-persistedstate'

import App from './App.vue'// 引入App.vue


const pinia = createPinia()
pinia.use(piniaPluginPersistedstate)


const app = createApp(App)

for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
    //@ts-ignore
    app.component(key, component)
}
app.use(ElementPlus)
app.use(router); // 使用路由
app.use(pinia)
app.use(MotionPlugin) // 使用动画插件
app.use(GesturePlugin) // 使用手势插件
// app.use(observer) // 使用全局监听器

app.mount('#app')

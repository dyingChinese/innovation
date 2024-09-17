/// <reference types="vite/client" />
declare module "*.vue" {
    import type {DefineComponent} from "vue"
    const vueComponent: DefineComponent<{}, {}, any>
    export default vueComponent
}

declare module "element-plus/dist/locale/zh-cn.mjs" // 中文语言包
declare module "element-plus/dist/locale/en.mjs" // 英文语言包

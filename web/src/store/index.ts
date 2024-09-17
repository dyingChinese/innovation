import {defineStore} from 'pinia'
import {ref} from 'vue'
import {MessageConfigContext} from "element-plus/es/components/message/src/message";


// 你可以任意命名 `defineStore()` 的返回值，但最好使用 store 的名字，同时以 `use` 开头且以 `Store` 结尾。
// (比如 `useUserStore`，`useCartStore`，`useProductStore`)
// 第一个参数是你的应用中 Store 的唯一 ID。

interface GlobalRootStoreType {
    locale: string;
    theme: string;
    size: string;
    button: {
        autoInsertSpace: boolean;
    };
    message: MessageConfigContext; // 确保这与 MessageConfigContext 接口兼容,
}

export const useRootStore = defineStore('rootStore', () => {
    const global = ref<GlobalRootStoreType>({
        locale: 'zh-CN',
        theme: 'light',
        size: 'default',
        button: {
            autoInsertSpace: true //自动在两个中文字符之间插入空格
        },
        message: {
            max: 3,
            duration: 3000,
            grouping: true,
            showClose: true
        }
    })
    const switchLocale = (locale: string) => {
        global.value.locale = locale
    }
    const switchTheme = (theme: string) => {
        global.value.theme = theme
    }
    const switchSize = (size: string) => {
        global.value.size = size
    }
    const setMessage = (message: MessageConfigContext) => {
        global.value.message = message
    }

    const switchButtonAutoInsertSpace = (autoInsertSpace: boolean) => {
        global.value.button.autoInsertSpace = autoInsertSpace
    }
    const switchMessageMax = (max: number) => {
        global.value.message.max = max
    }
    const switchMessageDuration = (duration: number) => {
        global.value.message.duration = duration
    }
    const switchMessageGrouping = (grouping: boolean) => {
        global.value.message.grouping = grouping
    }
    const switchMessageShowClose = (showClose: boolean) => {
        global.value.message.showClose = showClose
    }
    return {
        global, setMessage,
        switchLocale,
        switchTheme,
        switchSize,
        switchButtonAutoInsertSpace,
        switchMessageMax,
        switchMessageDuration,
        switchMessageGrouping,
        switchMessageShowClose
    }
}, {persist: true})

interface LayoutType {
    aside: number;
    header: number;
    footer: number;
    content?: number;

    [key: string]: any;
}

interface WindowStoreType {
    windowWidth: number;
    windowHeight: number;
    layout: LayoutType;
    layoutType?: string;

    [key: string]: any;
}


export const useWindowStore = defineStore('windowStore', () => {
    const window = ref<WindowStoreType>({
        windowWidth: document.documentElement.clientWidth,
        windowHeight: document.documentElement.clientHeight,
        layout: {
            aside: 200,
            header: 60,
            footer: 60,
            content: 0
        },
        layoutType: 'default',
    })
    const resizeWindow = () => {
        window.value.windowWidth = document.documentElement.clientWidth
        window.value.windowHeight = document.documentElement.clientHeight
    }
    const setWindowSize = ({width, height}: {
        width: number;
        height: number
    }) => {
        window.value.windowWidth = width
        window.value.windowHeight = height
    }
    const setLayoutType = (layoutType: string) => {
        window.value.layoutType = layoutType
    }
    const setLayout = (layout: LayoutType) => {
        window.value.layout = layout
    }
    const setLayoutAside = (aside: number) => {
        //@ts-ignore
        window.value.layout['aside'] = aside
    }
    const setLayoutHeader = (header: number) => {
        //@ts-ignore
        window.value.layout['header'] = header
    }
    const setLayoutFooter = (footer: number) => {
        //@ts-ignore
        window.value.layout['footer'] = footer
    }
    const setLayoutContent = (content: number) => {
        //@ts-ignore
        window.value.layout['content'] = content
    }

    const getLayoutType = () => {
        return window.value.layoutType
    }
    const getLayout = () => {
        return window.value.layout
    }
    return {
        window, setLayoutAside, setLayoutHeader, setLayoutFooter, setLayoutContent,
        resizeWindow, setLayout, getLayout, setWindowSize, setLayoutType, getLayoutType
    }
}, {persist: true})

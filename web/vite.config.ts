import {defineConfig} from 'vite'
import {join, resolve} from "node:path"
import vue from '@vitejs/plugin-vue'
import AutoImport from 'unplugin-auto-import/vite'
import Components from 'unplugin-vue-components/vite'
import {ElementPlusResolver} from 'unplugin-vue-components/resolvers'
import vueJsx from "@vitejs/plugin-vue-jsx";
//@ts-ignore
import ElementPlus from 'unplugin-element-plus/vite'


export default defineConfig({
    plugins: [
        vue(), vueJsx(),
        AutoImport({
            resolvers: [ElementPlusResolver()],
        }),
        Components({
            resolvers: [ElementPlusResolver({
                    importStyle: "sass"
                }
            )]
        }),
        ElementPlus({
            useSource: true,
        }),
    ],
    server: {
        proxy: {
            "^/api": {
                target: "http://localhost:8080",
                rewrite: (path) => {
                    console.log(`path = ${path}, TO = ${path.replace(/^\/api\/+/, "")}`)
                    return path.replace(/^\/api\/+/, "")
                },
                changeOrigin: true
            }
        }
    },
    resolve: {
        alias: {
            "@": join(__dirname, "./src"),
            '~/': `${resolve(__dirname, 'src')}/assets/`,
        }
    },
    css: {
        preprocessorOptions: {
            scss: {
                additionalData: `@use "~/theme/element-variables.scss" as *;`,
            },
        },
    },
})

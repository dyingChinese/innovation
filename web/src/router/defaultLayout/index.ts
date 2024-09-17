import {RouteRecordRaw} from "vue-router";
import HomeView from "@/views/HomeView/HomeView.vue";



const defaultLayoutRoutes: Array<RouteRecordRaw> = [
    {
        path: "/HomeView",
        name: "HomeView",
        components:{
            default: HomeView,
            globalLayoutAside: () => import("@/layouts/components/defaultGlobalLayoutAside.vue"),//侧边栏
            globalLayoutHeader: () => import("@/layouts/components/defaultGlobalLayoutHeader.vue"),//头部
            globalLayoutFooter: () => import("@/layouts/components/defaultGlobalLayoutFooter.vue")//底部
        }
    }
]

export default defaultLayoutRoutes;

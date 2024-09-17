import {createRouter, createWebHistory, RouteRecordRaw} from "vue-router"
import defaultLayout from "@/layouts/defaultGlobalLayout.vue"
import defaultLayoutRoutes from "@/router/defaultLayout/index"

const routes: Array<RouteRecordRaw> = [
    {
        path: "/",
        name: "defaultLayout",
        redirect: "/HomeView",
        component: defaultLayout,
        children: defaultLayoutRoutes
    }
]


const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    routes
})

router.beforeEach((_to, _from) => {
    if (_to.name === "login" || _to.name === "register") {
        return true
    }

    // const userInfo = useUserInfoStore()
    // if (
    //     userInfo.userInfo.token === ""
    // ) {
    //     return {name: "login"}
    // }

    return true
})

export default router

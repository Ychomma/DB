import Vue from 'vue'
import VueRouter from 'vue-router'
import Layout from '../views/Layout.vue'
import Cookies from "js-cookie";

Vue.use(VueRouter)

const routes = [
    // 登录
    {
        path: '/login',
        name: 'Login',
        component: () => import('@/views/login/Login')
    },
    // 主页
    {
        path: '/',
        name: 'Layout',
        component: Layout,
        redirect: '/home', //重定向，这样才能显示Home子路由，否则停留在Layout
        //'/'的子路由：完整路由是由Layout的path和子路由的path拼接起来的
        children: [
            {
                path: 'home',
                name: 'Home',
                component: () => import('@/views/home/HomeView.vue')
            },
            // User
            {
                path: 'userList',
                name: 'UserList',
                component: () => import('@/views/user/User.vue')
            },
            {
                path: 'addUser',
                name: 'AddUser',
                component: () => import('@/views/user/AddUser.vue')
            },
            {
                path: 'editUser',
                name: 'EditUser',
                component: () => import('@/views/user/EditUser.vue')
            },
            // Admin
            {
                path: 'adminList',
                name: 'AdminList',
                component: () => import('@/views/admin/List.vue')
            },
            {
                path: 'addAdmin',
                name: 'AddAdmin',
                component: () => import('@/views/admin/Add.vue')
            },
            {
                path: 'editAdmin',
                name: 'EditAdmin',
                component: () => import('@/views/admin/Edit.vue')
            },
            // Category
            {
                path: 'categoryList', name: 'categoryList', component: () => import('@/views/category/List.vue')
            },
            {
                path: 'addCategory', name: 'AddCategory', component: () => import('@/views/category/Add.vue')
            },
            {
                path: 'editCategory', name: 'EditCategory', component: () => import('@/views/category/Edit.vue')
            },
            // Book
            {
                path: 'bookList', name: 'bookList', component: () => import('@/views/book/List.vue')
            },
            {
                path: 'addBook', name: 'addBook', component: () => import('@/views/book/Add.vue')
            },
            {
                path: 'editBook', name: 'editBook', component: () => import('@/views/book/Edit.vue')
            }

        ]
    },
    {
        path: "*",
        component: () => import('@/views/404')
    }
]

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
})

router.beforeEach((to, from, next) => {
    if (to.path === '/login') next()
    const admin = Cookies.get("admin")
    if (!admin && to.path !== '/login') return next("/login") //强制退回到登录页面
    next()
})
export default router

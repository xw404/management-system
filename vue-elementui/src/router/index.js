import { createRouter, createWebHistory } from 'vue-router'
import Layout from '../layout/Layout.vue'
const routes = [
  {
    path: '/',
    name: 'Layout',
    component: Layout,
    redirect: "/user",
    children: [
      {
        path: '/user',
        name: 'User',
        component: () => import("@/views/User"),
      },
      {
        path: '/animal',
        name: 'Animal',
        component: () => import("@/views/Animal"),
      }
    ]
  },
  {
    path: '/login',
    name: 'Login',
    component: () => import("@/views/Login")
  },
  {
    path: '/register',
    name: 'Register',
    component: () => import("@/views/Register")
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router

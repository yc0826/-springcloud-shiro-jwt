import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

import Layout from '@/views/layout/Layout'

export const constantRouterMap = [
  {
    path: '/login',
    name: 'Login',
    component: () =>
      import('@/views/login/index'),
    hidden: true
  },

  {
    path: '/',
    component: Layout,
    redirect: '/dashboard',
    name: 'Dashboard',
    hidden: true,
    children: [{
      path: 'dashboard',
      component: () =>
        import('@/views/dashboard/index')
    }, {
      path: 'userinfo',
      name: 'UserInfo',
      component: () =>
        import('@/views/dashboard/userinfo')
    }]
  }
]

export default new Router({
  // mode: 'history', //后端支持可开
  scrollBehavior: () => ({ y: 0 }),
  routes: constantRouterMap
})

export const asyncRouterMap = [
  {
    path: '/auth',
    component: Layout,
    name: 'auth',
    meta: {
      resources: 'auth:menu',
      title: '权限管理'
    },
    children: [
      {
        path: 'user',
        component: () => import('@/views/auth/user/index'),
        name: 'user',
        meta: {
          resources: 'user:view',
          title: '用户管理'
        }
      },
      {
        path: 'resource',
        component: () => import('@/views/auth/resource/index'),
        name: 'resource',
        meta: {
          resources: 'resource:view',
          title: '菜单管理'
        }
      },
      {
        path: 'role',
        component: () => import('@/views/auth/role/index'),
        name: 'role',
        meta: {
          resources: 'role:view',
          title: '角色管理'
        }
      },
      {
        path: 'authorization',
        component: () => import('@/views/auth/authorization/index'),
        name: 'authorization',
        meta: {
          resources: 'authorization:view',
          title: '授权管理'
        }
      }
    ]
  }
]


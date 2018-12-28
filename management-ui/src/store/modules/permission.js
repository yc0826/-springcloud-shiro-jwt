// store/permission.js
import {
  constantRouterMap
} from '@/router'

/**
 *
 * @param  {Array} userRouter 后台返回的用户权限json
 * @param  {Array} allRouter  前端配置好的所有动态路由的集合
 * @return {Array} realRoutes 过滤后的路由
 */
export function recursionRouter(userRouter = []) {
  userRouter.forEach((item, index) => {
    if (item.children && item.children.length > 0) {
      item.children = recursionRouter(item.children)
    }
    item.component = resolve => require(['@/views/' + item.componentPath], resolve)
    const meta = []
    meta.title = item.title
    item.meta = meta
  })
  return userRouter
}

/**
 *
 * @param {Array} routes 用户过滤后的路由
 *
 * 递归为所有有子路由的路由设置第一个children.path为默认路由
 */
export function setDefaultRoute(routes) {
  routes.forEach((v, i) => {
    if (v.children && v.children.length > 0) {
      v.redirect = {
        name: v.children[0].name
      }
      setDefaultRoute(v.children)
    }
  })
}

const permission = {
  state: {
    routers: constantRouterMap, // 这是默认权限列表 比如404 500等路由
    dynamicRouters: [] // 这是通过后台获取的权利列表
  },
  mutations: {
    SET_ROUTERS: (state, routers) => {
      state.dynamicRouters = routers
      state.routers = constantRouterMap.concat(routers)
    }
  },
  actions: {
    GenerateRoutes({
      commit
    }, data) {
      return new Promise(resolve => {
        commit('SET_ROUTERS', recursionRouter(data))
        resolve()
      })
    }
  }
}

export default permission

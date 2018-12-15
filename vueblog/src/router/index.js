import Vue from 'vue'
import Router from 'vue-router'
Vue.use(Router)

import iView from 'iview'
import 'iview/dist/styles/iview.css'    // 使用 CSS
Vue.config.productionTip = false
Vue.use(iView)

import HelloWorld from '@/components/HelloWorld'
import Test from '@/components/Test'
import Login from '@/components/Login'
import Home from '@/components/Home'

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld,
      meta: {keepAlive: true}
    },
    {
      path: '/test',
      name: 'Test',
      component: Test,
      meta: {keepAlive: true}
     },
     {
       path: '/login',
       name: 'Login',
       component: Login,
       meta: {keepAlive: false}
     },
     {
         path: '/home',
         name: 'Home',
         component: Home,
         meta: {keepAlive: true}
       }
  ]
})

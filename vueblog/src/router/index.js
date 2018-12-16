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

import Test1 from '@/components/blog/Test1'
import Test1_1 from '@/components/blog/test1/Test1_1'

import Test2 from '@/components/blog/Test2'
import Test3 from '@/components/blog/Test3'

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
       meta: {keepAlive: true},
     },
     {
         path: '/test1',
         name: 'Test1',
         component: Test1,
         meta: {keepAlive: true},
         children:[
        	 {
        		 path: 'test1_1',
                 name: 'Test1_1',
                 component: Test1_1,
                 meta: {keepAlive: true},
        	 }
         ]
       },
       {
         path: '/test2',
         name: 'Test2',
         component: Test2,
         meta: {keepAlive: true}
       },
       {
    	 path: '/test3',
         name: 'Test3',
         component: Test3,
         meta: {keepAlive: true}
       }
  ]
})

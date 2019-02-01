// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import iView from 'iview' // 引入iview依赖
import 'iview/dist/styles/iview.css' // 引入iview css样式
import axios from 'axios' // 1、在这里引入axios

Vue.prototype.$axios = axios;   // 2、在vue中使用axios

axios.defaults.timeout = 5000;// 在超时前，所有请求都会等待 5 秒
axios.defaults.headers.post['Content-Type']= 'application/x-www-form-urlencoded;charset=UTF-8';// 配置请求头
axios.defaults.baseURL = 'http://192.168.1.113:9090/blog/';// 配置接口地址
axios.defaults.withCredentials = false;

Vue.config.productionTip = false


Vue.use(iView) //使用iview组件 

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})

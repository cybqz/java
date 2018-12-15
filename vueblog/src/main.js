// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import jsonp from 'jsonp'

Vue.prototype.jsonp = jsonp
Vue.config.productionTip = false
Vue.prototype.URL_PREFIX = 'http://localhost:9090'

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})

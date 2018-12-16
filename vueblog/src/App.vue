<template>
  <div id="app">
    <div v-if="$route.meta.keepAlive">
      <header>
        <keep-alive>
        <!-- 导航栏 -->
          <header-nav></header-nav>
        </keep-alive>
      </header>
    <div class="clearfix">
      <aside class="aside">
        <!-- 侧边栏 -->
        <keep-alive>
          <left></left>
        </keep-alive>
      </aside>
      <div class="containt">
         <router-view></router-view>
      </div>
    </div>
    </div>
    <router-view v-if="!$route.meta.keepAlive"></router-view>
  </div>
</template>

<script>
import header from './components/nav/Header.vue';
import left from './components/nav/Left.vue';
export default {
  name: 'App',
  components: {
        headerNav: header,
        left: left
      }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
.clearfix:{zoom:1;}
.clearfix:after{
	display: block;
	content: ' ';
	clear: both;
	line-height: 0;
	visibility: hidden;
}
.aside{
	border:red solid 1px;
	width:300px;
	float:left;
}
.containt{
	border:green solid 1px;
	width:calc(100% - 300px);
	float:right;
}
</style>

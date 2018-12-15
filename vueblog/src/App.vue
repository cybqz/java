<template>
  <div id="app">
    <div v-if="$route.meta.keepAlive">
      <header>
        <keep-alive>
        <!-- 导航栏 -->
          <header-nav></header-nav>
        </keep-alive>
      </header>
    <div>
      <aside width="250px">
        <!-- 侧边栏 -->
        <keep-alive>
          <left></left>
        </keep-alive>
      </aside>
      <div>
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
  margin-top: 60px;
}
</style>

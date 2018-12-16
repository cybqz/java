<template>
  <div class="left">
	<div>
		<router-link to="/test1">test1</router-link>
  	</div>
  	<div>
		<router-link to="/test2">test2</router-link>
  	</div>
  	<div>
		<router-link to="/test3">test3</router-link>
  	</div>
  </div>
</template>
<script>
export default {
  name: 'Left',
  data(){
  	return {
  	}
  },
  mounted(){
  	console.log('Left');
  },
  methods: {
  }
}
</script>
<style scoped>
	.left{};
</style>
<template>
  <div class="hello">
    This is test1_1!
  </div>
</template>

<script>
export default {
  name: 'Home',
  mounted(){
  	console.log('test1');
  }
}
</script>

<style scoped>
h1, h2 {
  font-weight: normal;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
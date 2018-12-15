<template>
  <div class="hello">
    <ul>
    	<li v-for="(item,index) in list">
    		<span style="color:red;">{{item.name}}</span>
    		<span style="color:green;">{{item.id}}</span>
    	</li>
    </ul>
  </div>
</template>

<script>
export default {
  name: 'Test',
  data () {
    return {
      msg: 'Welcome to Your Vue.js App',
      list:[],
    }
  },
  methods:{
  	loadData(){
  			this.jsonp(`${this.URL_PREFIX}/blog/testController/test`, {name: "XXXcallback",
         timeout: 500,params: null,jsonp:"_callback"}, (err, m) => {
			    if (err) {
			      console.error(err.message)
			    }else {
			      console.log(m);
			      this.list = m
			    }
	 		});
  		
  	}
  },
  mounted: function(){
	  this.$nextTick(() => {
	  	this.loadData();
	  })
  	
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
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

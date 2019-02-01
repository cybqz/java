<template>
	<div class="containt">
		<div class="left">
			<!-- 导航模块组件 -->
			<Interest v-if='$route.query.tabId == 0'>
			</Interest>
			
			<Read v-if='$route.query.tabId == 1'>
			</Read>
			
			<Taste v-if='$route.query.tabId == 2'>
			</Taste>
			
			<Travel v-if='$route.query.tabId == 3'>
			</Travel>
			
			<Learn v-if='$route.query.tabId == 4'>
			</Learn>
			
			<Diary v-if='$route.query.tabId == 5'>
			</Diary>
			
			<MessageBoard v-if='$route.query.tabId == 6'>
			</MessageBoard>
			
		</div>
		<div class="right shadow">
			<!-- 右侧简介部分 -->
			<span @click="test()" style="display: inline-block;width: 40px;height:30px; background: skyblue;cursor: pointer;">按钮</span>
		</div>
	</div>
</template>

<script>
import Interest from "@/components/beforeLogin/interesting.vue";
import Read from "@/components/beforeLogin/reading.vue";
import Taste from "@/components/beforeLogin/tasting.vue";
import Travel from "@/components/beforeLogin/travel.vue";
import Learn from "@/components/beforeLogin/learning.vue";
import Diary from "@/components/beforeLogin/diary.vue";
import MessageBoard from "@/components/beforeLogin/message-board.vue";
export default {
  name: 'beforeLogin',
  data () {
    return {
    }
  },
  watch:{
// 	    fromTab: {
// 		  handler: function (val, oldVal) { 
// 			  this.fromTab = val;
// 		  },
// 		  immediate: true
// 		},
  },
  methods:{
		test(){
			let url = this.$axios.defaults.baseURL + "blogController/publish";
			let param = {
				title:'hhahahhaaaaaaaaaaaaaaaaaaa',
				containt:'  会好好睡觉'

			};
			this.$axios.get(url, {params: param})
			.then((response) => {
					console.log(response)
			}).catch((error) => {
					console.log(error)
			})
		},
  },
  components: {
	Interest,
	Read,
	Taste,
	Travel,
	Learn,
	Diary,
	MessageBoard
  },
}
</script>

<style scoped lang="less">
	@import "../../assets/css/common.less";
	.containt{
		width: 100%;
		display: flex;
		.left{
			flex: 1;
			margin-right:360px ;
		}
		.right{
			margin-left: 30px;
			flex: none;
			width: 310px;
			height: 500px;
			position: fixed;
			top: 80px;
			right: 10%;
		}
	}
</style>

<template>
	<div>
		<div class="topWrap">
			<div class="top" >
				<div class="logo">
				</div>
				<div v-show="!logined" class="nav">
					<div v-for="(item,index) in navTabs" :class="index == tabActive?'active':''">
						<span @click="changeNavTab(item.num)">
							{{item.name}}
						</span>
					</div>
				</div>
				<div v-show="logined" class="nav">
					<div v-for="(item,index) in loginNavTabs" :class="index == tabActive?'active':''">
						<span @click="changeNavTab(item.num)">{{item.name}}</span>
					</div>
				</div>
				<div class="search">
					<Input suffix="ios-search" placeholder="Enter text" style="width: auto" />
				</div>
				<div class="login">
					<div v-show="!logined">
						<span class="login-text">登录</span>
						<span class="login-text">注册</span>
					</div>
					<div v-show="logined">
						
					</div>
				</div>
			</div>
		</div>
		<div class="containtWrap">
			<router-view/>
			
		</div>
	</div>
</template>

<script>
export default {
  name: 'home',
  data () {
    return {
		logined:false,
		tabActive:0,
		navTabs:[{
			name:'点趣',
			num:0
		},{
			name:'点悦',
			num:1
		},{
			name:'点味',
			num:2
		},{
			name:'点途',
			num:3
		},{
			name:'点知',
			num:4
		},{
			name:'个人日记',
			num:5
		},{
			name:'留言板',
			num:6
		}],
		loginNavTabs:[{
			name:'发现',
			num:0
		},{
			name:'我的',
			num:1
		},{
			name:'趣友',
			num:2
		}],
    }
  },
  watch:{
    },
  methods:{
	changeNavTab(num){
		this.tabActive = num;
		if(!this.logined){
			this.$router.push({
				path: '/home/beforeLogin',
				query: {
					tabId: num
				}
			})
		}else{
			//登录后根据id跳转不同的路径
			
		}
		
	},  
  },
  mounted() {
	this.changeNavTab(0);
  	
  }
}
</script>

<style scoped lang="less">
	.topWrap{
		height: 60px;
		margin-bottom: 20px;
	}
	.top{
		position: fixed;
		top: 0;
		left: 0;
		right: 0;
		background: white;
		height: 60px;
		width: 100%;
		border-bottom: 1px solid #ccc;
		display: flex;
		.logo{
			margin: 0 20px;
			width: 140px;
			height: 60px;
			border-radius: 50%;
			background: url(../assets/img/gclogo.png);
			background-size:contain;
			flex: none;
		}
		.nav{
			flex: 1;
			display: flex;
			div{
				width: 28%;
				height: 60px;
				line-height: 60px;
				font-size: 16px;
				text-align: center;
				margin: 0 20px;
				span{
					cursor: pointer;
				}
				&.active{
					color: orange;
				}
			}
		}
		.search{
			margin: 0 20px;
			width: 200px;
			height: 60px;
			line-height: 60px;
			flex: none;
		}
		.login{
			margin-left: 100px;
			width: 200px;
			flex: none;
			div{
				text-align: center;
				height: 60px;
				line-height: 60px;
				.login-text{
					margin: 0 30px;
					cursor: pointer;
					font-size: 16px;
				}
				.login-text:hover{
					color:orange;
				}
			}
		}
	}
	.containtWrap{
		width: 80%;
		margin: 0 auto;
	}
</style>

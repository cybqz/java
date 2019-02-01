<template>
	<div>
		<!-- 点趣模块 -->
		<div class="modelBox"></div>
		<div class="shadow ptb20">
			<Scroll :on-reach-bottom="handleReachBottom">
				<div class="intereting-wrap" v-for="item in data">
					<div class="containDiv">
						<div :title="item.title" class="title pointer eclipes1">
							{{item.title}}
						</div>
						<div class="msg eclipes2">
							{{item.containt}}
						</div>
						<div class="about">
							<div class="spaceR">
								<span class="left">
									作者：<span class="organe pointer">{{item.author}}</span>
								</span>
								<span class="right">
									<span><Icon class='icon gost' type="ios-text" />{{item.commentCount}}</span>
									<span><Icon class='icon red' type="ios-heart" />{{item.fablousCount}}</span>
								</span>
							</div>
							<div v-if='true' class="space">
								
							</div>
						</div>
					</div>
					<div v-if='true' class="imgDiv pointer">
					</div>
				</div>
			</Scroll>
		</div>
		
	</div>
</template>

<script>
export default {
  name: 'beforeLogin',
  data () {
    return {
			tatal:0,
			pageSize:10,
			pageNo:1,
			data:[],
			continueGetData:true
    }
  },
  watch:{
  },
  methods:{
		changePage(){
			this.getData();
		},
		getData(){
			if(this.continueGetData){
				let url = this.$axios.defaults.baseURL + "blogController/getList";
				let param = {
					pageIndex:this.pageNo
				};
				console.log(param);
				//this.$axios.post(url,{param:param})
				this.$axios({method:'post', url:url, data:this.$qs.stringify(param)})
				.then((response) => {
					let status = response.status;
					let data = response.data;
					if( status == 200){
						console.log(data);
						this.continueGetData = data.pageIndex<=data.pageCount;
						for(var i in data.pageDatas){
							this.data.push(data.pageDatas[i]);
						}
						console.log(this.data.lenght);
					}else{
						console.log("getData error!");
					}
				}).catch((error) => {
						console.log(error)
				})
			}else{
				$.message({
					message: '已经到底啦！',
					type: 'success',
				});
			}
		},
		handleReachBottom () {
			this.pageNo += 1;
			this.getData();
        }
  },
	mounted() {
		this.getData();
	}
}
</script>

<style scoped lang="less">
	@import "../../assets/css/common.less";
	.intereting-wrap{
		padding: 40px 0;
		border-top: 1px dashed #ccc;
		width: 100%;
		display: flex;
		height: 220px;
		&:first-child{
			border-top:none;
		}
		.imgDiv{
			width: 210px;
			height: 140px;
			margin-right: 20px;
			background: url(../../assets/img/sy_img1.jpg);
			background-size: cover;
			flex: none;
		}
		.containDiv{
			flex: 1;
			.title{
				height: 40px;
				line-height: 40px;
				text-align: left;
				width: 80%;
				font-size: 14px;
				font-weight: bold;
			}
			.msg{
				text-align: left;
				width: 100%;
				padding-right: 20px;
				font-size: 14px;
				height: 60px;
				line-height: 30px;
			}
			.about{
				margin-top: 20px;
				height: 20px;
				line-height: 20px;
				text-align: left;
				font-size: 13px;
				display: flex;
				.space{
					flex: none;
					width: 210px;
					margin-right: 20px;
				}
				.spaceR{
					flex: 1;
					display: flex;
					.right, .left{
						flex: 1;
					}
					.organe{
						color: orange;
					}
					.right{
						display: flex;
						span{
							flex: 1;
							.icon{
								font-size: 20px;
								vertical-align: middle;
								margin-right: 5px;
								&.gost{
									color: #ccc;
								}
								&.red{
									color: coral;
								}
							}
						}
					}
				}
			}
		}
	}
</style>

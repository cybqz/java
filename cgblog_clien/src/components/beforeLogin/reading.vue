<template>
	<div>
		<!-- 点悦模块 -->
		<div class="shadow ptb20 reading">
			<div class="movie">
				<div class="title">
					<span class="mymovie">我的电影</span>
				</div>
				<div class="content-wrap">
					<div class="content shadow" v-for="item in movieData">
						<div class="msgImg"></div>
						<div class="msgIntroduce"> 
							<div class="name eclipes1">
								影名：{{item.title}}
							</div>
							<div class="msg eclipes2">
								荐语：{{item.msg}}
							</div>
							<div class="about">
								<span class="area">
									<span class="mr5"><Icon class='icon gost' type="ios-text" /></span>{{item.comment}}
								</span>
								<span class="area">
									<span class="mr5"><Icon class='icon red' type="ios-heart" /></span>{{item.like}}
								</span>
							</div>
						</div>
					</div>
					<div style="clear: both;"></div>
				</div>
				
			</div>
			<div class="book">
				<div class="title">
					<span class="mybook">我的书刊</span>
				</div>
				<div class="content-wrap">
					<div class="content shadow" v-for="item in bookData">
						<div class="msgImg"></div>
						<div class="msgIntroduce"> 
							<div class="name eclipes1">
								书名：{{item.title}}
							</div>
							<div class="msg eclipes2">
								荐语：{{item.msg}}
							</div>
							<div class="about">
								<span class="area">
									<span class="mr5"><Icon class='icon gost' type="ios-text" /></span>{{item.comment}}
								</span>
								<span class="area">
									<span class="mr5"><Icon class='icon red' type="ios-heart" /></span>{{item.like}}
								</span>
							</div>
						</div>
					</div>
					<div style="clear: both;"></div>
				</div>
			</div>
			<div class="music">
				<div class="title">
					<span class="mymusic">我的音乐</span>
				</div>
				<div class="content-wrap">
					<div class="content shadow" v-for="item in musicData">
						<div class="msgImg"></div>
						<div class="msgIntroduce"> 
							<div class="name eclipes1">
								歌名：{{item.title}}
							</div>
							<div class="msg eclipes2">
								荐语：{{item.msg}}
							</div>
							<div class="about">
								<span class="area">
									<span class="mr5"><Icon class='icon gost' type="ios-text" /></span>{{item.comment}}
								</span>
								<span class="area">
									<span class="mr5"><Icon class='icon red' type="ios-heart" /></span>{{item.like}}
								</span>
							</div>
						</div>
					</div>
					<div style="clear: both;"></div>
				</div>
			</div>
		</div> 
	</div>
</template>

<script>
export default {
  name: 'beforeLogin',
  data () {
    return {
			movieData:[{
				title:'fdssssssssdwEWEWEdSDSfdfs地方士大夫似的大师傅士大夫',
				msg:'哈哈哈哈回复恢复精神的回复就速度发货及时的好附件是胡椒粉司法鉴定所华福酒店发的好时机',
				comment:23,
				like:233
			},{
				title:'fdssssssssdwEWEWEdSDSfdfs地方士大夫似的大师傅士大夫',
				msg:'哈哈哈哈回复恢复精神的回复就速度发货及时的好附件是胡椒粉司法鉴定所华福酒店发的好时机',
				comment:23,
				like:233
			},{
				title:'fdssssssssdwEWEWEdSDSfdfs地方士大夫似的大师傅士大夫',
				msg:'哈哈哈哈回复恢复精神的回复就速度发货及时的好附件是胡椒粉司法鉴定所华福酒店发的好时机',
				comment:23,
				like:233
			},{
				title:'fdssssssssdwEWEWEdSDSfdfs地方士大夫似的大师傅士大夫',
				msg:'哈哈哈哈回复恢复精神的回复就速度发货及时的好附件是胡椒粉司法鉴定所华福酒店发的好时机',
				comment:23,
				like:233
			}],
			bookData:[{
				title:'fdssssssssdwEWEWEdSDSfdfs地方士大夫似的大师傅士大夫',
				msg:'哈哈哈哈回复恢复精神的回复就速度发货及时的好附件是胡椒粉司法鉴定所华福酒店发的好时机',
				comment:23,
				like:233
			},{
				title:'fdssssssssdwEWEWEdSDSfdfs地方士大夫似的大师傅士大夫',
				msg:'哈哈哈哈回复恢复精神的回复就速度发货及时的好附件是胡椒粉司法鉴定所华福酒店发的好时机',
				comment:23,
				like:233
			}],
			musicData:[{
				title:'fdssssssssdwEWEWEdSDSfdfs地方士大夫似的大师傅士大夫',
				msg:'哈哈哈哈回复恢复精神的回复就速度发货及时的好附件是胡椒粉司法鉴定所华福酒店发的好时机',
				comment:23,
				like:233
			},{
				title:'fdssssssssdwEWEWEdSDSfdfs地方士大夫似的大师傅士大夫',
				msg:'哈哈哈哈回复恢复精神的回复就速度发货及时的好附件是胡椒粉司法鉴定所华福酒店发的好时机',
				comment:23,
				like:233
			},{
				title:'fdssssssssdwEWEWEdSDSfdfs地方士大夫似的大师傅士大夫',
				msg:'哈哈哈哈回复恢复精神的回复就速度发货及时的好附件是胡椒粉司法鉴定所华福酒店发的好时机',
				comment:23,
				like:233
			}]
    }
  },
  watch:{
  },
  methods:{
  }
}
</script>

<style scoped lang="less">
	@import "../../assets/css/common.less";
	.movie, .music, .book{
		.title{
			heihgt:30px;
			line-height:30px;
			text-align:left;
			span{
				padding: 0 20px;
				font-size: 14px;
				&.mymovie{
					border-left: 3px solid brown;
					color: brown;
				}
				&.mybook{
					border-left: 3px solid orange;
					color: orange;
				}
				&.mymusic{
					border-left: 3px solid skyblue;
					color: skyblue;
				}
			}
		}
		.content-wrap{
			padding: 20px 0;
			.content{
				padding: 10px;
				margin-right: 15px;
				float: left;
				width: calc(33.33% - 15px);
				margin-bottom: 30px;
				.msgImg{
					float: left;
					width: 80px;
					height: 120px;
					margin-right: 10px;
					background: url(../../assets/img/book.jpg);
					background-size: cover;
				}
				.msgIntroduce{
					float: left;
					width: calc(100% - 90px);
					.name{
						height: 30px;
						line-height: 30px;
						font-size: 13px;
						width: 100%;
						text-align: left;
						font-weight: bold;
					}
					.msg{
						height: 60px;
						line-height: 30px;
						font-size: 13px;
						width: 100%;
						text-align: left;
					}
					.about{
						width: 100%;
						height: 30px;
						line-height: 30px;
						text-align: left;
						font-size: 12px;
						.area{
							display: inline-block;
							width: 45%;
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

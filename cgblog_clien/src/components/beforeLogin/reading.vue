<template>
	<div>
		<!-- 点悦模块 -->
		<div class="shadow ptb20 reading">
            <Collapse simple accordion v-model="collapse" @on-change="getCurrentModal">
                <Panel hide-arrow=true name="moviepanel">
                    <div class="title">
                        <span class="mymovie">我的电影</span>
                    </div>
                  <div class="movie" slot="content">
                    <div class="content-wrap">
                        <Scroll :on-reach-bottom="handleDataBottom" :height=scrollHeight>
                            <div class="content shadow" v-for="item in movieData">
                                <div class="msgImg"></div>
                                <div class="msgIntroduce"> 
                                    <div class="name eclipes1">影名：{{item.title}}</div>
                                    <div class="msg eclipes2">荐语：{{item.recommend}}</div>
                                    <div class="about">
                                        <span class="area">
                                            <span class="mr5"><Icon @click="doComment(item.id)" class='icon red pointer' type="ios-text" /></span>{{item.commentCount}}
                                        </span>
                                        <span class="area">
                                            <span class="mr5"><Icon @click="doFablous(item.id)" class='icon red pointer' type="ios-heart" /></span>{{item.fablousCount}}
                                        </span>
                                    </div>
                                </div>
                            </div>
                            <div style="clear: both;"></div>
                        </Scroll>  
                    </div>
                </div>
                </Panel>
                <Panel hide-arrow=true name="bookpanel">
                                    <div class="title">
					<span class="mybook">我的书刊</span>
				</div>
                  <div class="book" slot="content">
				<div class="content-wrap">
                    <Scroll :on-reach-bottom="handleDataBottom" :height=scrollHeight>
                        <div class="content shadow" v-for="item in bookData">
                            <div class="msgImg"></div>
                            <div class="msgIntroduce"> 
                                <div class="name eclipes1">书名：{{item.title}}</div>
                                <div class="msg eclipes2">荐语：{{item.recommend}}</div>
                                <div class="about">
                                    <span class="area">
                                        <span class="mr5"><Icon @click="doComment(item.id)" class='icon red pointer' type="ios-text" /></span>{{item.commentCount}}
                                    </span>
                                    <span class="area">
                                        <span class="mr5"><Icon @click="doFablous(item.id)" class='icon red pointer' type="ios-heart" /></span>{{item.fablousCount}}
                                    </span>
                                </div>
                            </div>
                        </div>
                        <div style="clear: both;"></div>
                    </Scroll>
				</div>
			</div>
                </Panel>
                <Panel hide-arrow=true name="musicpanel">
                                    <div class="title">
					<span class="mymusic">我的音乐</span>
				</div>
                  <div class="music" slot="content">
				<div class="content-wrap">
                    <Scroll :on-reach-bottom="handleDataBottom" :height=scrollHeight>
                        <div class="content shadow" v-for="item in musicData">
                            <div class="msgImg"></div>
                            <div class="msgIntroduce"> 
                                <div class="name eclipes1">歌名：{{item.title}}</div>
                                <div class="msg eclipes2">荐语：{{item.recommend}}</div>
                                <div class="about">
                                    <span class="area">
                                        <span class="mr5"><Icon @click="doComment(item.id)" class='icon red pointer' type="ios-text" /></span>{{item.commentCount}}
                                    </span>
                                    <span class="area">
                                        <span class="mr5"><Icon @click="doFablous(item.id)" class='icon red pointer' type="ios-heart" /></span>{{item.fablousCount}}
                                    </span>
                                </div>
                            </div>
                        </div>
                        <div style="clear: both;"></div>
                    </Scroll>
				</div>
			</div>
                </Panel>
            </Collapse>
		</div> 
	</div>
</template>

<script>
export default {
  name: 'reading',
  data () {
    return {
        controller:'readingController/',
        collapse:'moviepanel',
        scrollHeight:450,
        movieData:[],
        musicData:[],
        bookData:[],
        currentPanel:'moviepanel',
        panelModal:{
            moviepanel:{pageNo:1,name:'me',continue:true},
            musicpanel:{pageNo:1,name:'mc',continue:true},
            bookpanel:{pageNo:1,name:'bk',continue:true},
        },
    }
  },
  watch:{
  },
  methods:{
      getCurrentModal(key){
          this.currentPanel = key[0];
          this.getData();
      },
      getData(){
        if(this.panelModal[this.currentPanel].continue){
            let url = this.$axios.defaults.baseURL + this.controller + "getList";
            let param = {
                modal:this.panelModal[this.currentPanel].name,
                pageIndex:this.panelModal[this.currentPanel].pageNo
            };
            this.$axios({method:'post', url:url, data:this.$qs.stringify(param)})
            .then((response) => {
                let data = response.data;
                if( response.status == 200){
                    this.panelModal[this.currentPanel].continue = data.pageIndex<=data.pageCount;
                    for(var i in data.pageDatas){
                        if(this.currentPanel === 'moviepanel'){
                            this.movieData.push(data.pageDatas[i]);
                        }else if(this.currentPanel === 'musicpanel'){
                            this.musicData.push(data.pageDatas[i]);
                        }else{
                            this.bookData.push(data.pageDatas[i]);
                        }
                    }
                }else{
                    console.log("getData error!");
                }
            }).catch((error) => {
                console.log(error)
            })
        }else{
            this.$Message.info('已经到底啦！');
        }
      },
      handleDataBottom(){
        this.panelModal[this.currentPanel].pageNo += 1;
        this.getData();
      },
      doComment(id){
            alert(id);
        },
        doFablous(id){
            let url = this.$axios.defaults.baseURL + this.controller + "doFablous";
            let param = {
                id:id
            };
            this.$axios({method:'post', url:url, data:this.$qs.stringify(param)})
            .then((response) => {
                let data = response.data;
                if( response.status == 200){
                    if(data.validate){
                        if(this.currentPanel === 'moviepanel'){
                            for(var i in this.movieData){
                                if(this.movieData[i].id == id){
                                    ++ this.movieData[i].fablousCount;
                                    return;
                                }
                            }
                        }else if(this.currentPanel === 'musicpanel'){
                            for(var i in this.musicData){
                                if(this.musicData[i].id == id){
                                    ++ this.musicData[i].fablousCount;
                                    return;
                                }
                            }
                        }else{
                            for(var i in this.bookData){
                                if(this.bookData[i].id == id){
                                    ++ this.bookData[i].fablousCount;
                                    return;
                                }
                            }
                        }
                        this.$Message.success(data.msg);
                    }else{
                        this.$Message.error(data.msg);
                    }
                }else{
                    console.log("getData error!");
                }
            }).catch((error) => {
                console.log(error)
            })
        }
    },
    mounted() {
		this.getData();
	}
}
</script>

<style scoped lang="less">
    @import "../../assets/css/common.less";
    .title{
			height:30px;
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
	.movie, .music, .book{
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

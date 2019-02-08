<template>
	<div>
        <div class="comments">
            <Input class="textarea" v-model="message" type="textarea" placeholder="说出来.........."
                   :border="{size:0}" :autosize="{minRows: 8,maxRows: 8}" />
            <div class="info">
                <span class="left">
                    <Poptip placement="bottom-start" width="400">
                        <div class="api" slot="content">
                            <Tabs size="small">
                                <TabPane label="表情一">
                                    <div class="" v-for="item in emoticonsA">
                                        <img v-bind:src="item" alt="表情" @click="selectEmoticon(item)">
                                    </div>
                                </TabPane>
                                <TabPane label="表情二">
                                    <div class="" v-for="item in emoticonsB">
                                        <img v-bind:src="item" alt="表情" @click="selectEmoticon(item)">
                                    </div>
                                </TabPane>
                                <TabPane label="表情三">
                                    <div class="" v-for="item in emoticonsC">
                                        <img v-bind:src="item" alt="表情" @click="selectEmoticon(item)">
                                    </div>
                                </TabPane>
                            </Tabs>
                        </div>
                        <span><Button class='icon red pointer' type="text" ghost size="small" icon="md-happy" title="表情"></Button></span>
                        &nbsp;&nbsp;&nbsp;
                    </Poptip>
                    <Poptip placement="bottom-start" width="300">
                        <div class="api" slot="content">
                            <Tabs size="small">
                                <TabPane label="表情一">标签一的内容</TabPane>
                                <TabPane label="表情二">标签二的内容</TabPane>
                                <TabPane label="表情三">标签三的内容</TabPane>
                            </Tabs>
                        </div>
                        <span><Button class='icon red pointer' type="text" ghost size="small" icon="md-image" title="图片"/></Button></span>
                    </Poptip>
                </span>
                <span class="right organe pointer">登录</span>
            </div>
        </div>
	</div>
</template>

<script>
export default {
  name: 'message-board',
  data () {
    return {
        message:'',
        emoticonsA:[],
        emoticonsB:[],
        emoticonsC:[]
    }
  },
  watch:{
  },
  methods:{
      getEmoticon(){
          let baseURL = this.$axios.defaults.baseURL;
          let url = baseURL + "emoticonController/getEmoticonList";
          this.$axios({method:'post', url:url, data:null})
          .then((response) => {
              let data = response.data;
              if( response.status == 200){
                  for(var i in  data[0]){
                      for(var j in  data[0][i]){
                          this.emoticonsA.push(baseURL + data[0][i][j]);
                      }
                  }
                  for(var i in  data[1]){
                      for(var j in  data[1][i]){
                          this.emoticonsB.push(baseURL + data[1][i][j]);
                      }
                  }
                  for(var i in  data[2]){
                      for(var j in  data[2][i]){
                          this.emoticonsC.push(baseURL + data[2][i][j]);
                      }
                  }
              }else{
                  console.log("getEmoticon error!");
              }
          }).catch((error) => {
              console.log(error)
          });
      },
      selectEmoticon(image){
          this.message += '['+image+']';
      }
  },
  mounted() {
      this.getEmoticon();
  }
}
</script>

<style scoped lang="less">
    @import "../../assets/css/common.less";
    .comments{
        width: 100%;
        position: relative;
        height: auto;
        border: 1px solid #ccc;
        border-radius: 5px;
        .info{
            flex: 1;
            display: flex;
            border: none;
            border-top: 1px solid #ccc;
            .right, .left{
                flex: 1;
                font-size: 25px;
            }
            .organe{
                color: orange;
            }
            .left{
                display: flex;
                img{
                    cursor:pointer;
                    width: 40px;
                    height: 40px;
                    float: left;
                    margin: 5px;
                }
                span{
                    flex: 1;
                    .icon{
                        font-size: 30px;
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
</style>
<style lang="less">
    textarea.ivu-input {
        border: none;
    }
</style>

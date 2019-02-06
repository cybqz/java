<template>
	<div>
        <div class="comments">
            <Input class="textarea" v-model="message" type="textarea" placeholder="Enter something..."
                   :border="{size:0}" :autosize="{minRows: 8,maxRows: 8}" />
            <div class="info">
                <span class="left">
                    <Poptip placement="bottom-start" width="300">
                        <div class="api" slot="content">
                            <Tabs size="small">
                                <TabPane label="表情一">

                                </TabPane>
                                <TabPane label="表情二">

                                </TabPane>
                                <TabPane label="表情三">
                                    
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
        message:''
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
                font-size: 16px;
            }
            .organe{
                color: orange;
            }
            .left{
                display: flex;
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

<template>
	<div class="bg-login">
		<div class="bg">
		</div>
		<Form ref="formInline" :model="formInline" :rules="ruleInline" class="login">
	        <FormItem prop="user" class="item">
	            <Input type="text" v-model="formInline.user" placeholder="Username">
	                <Icon type="ios-person-outline" slot="prepend"></Icon>
	            </Input>
	        </FormItem>
	        <FormItem prop="password" class="item item-center">
	            <Input type="password" v-model="formInline.password" placeholder="Password">
	                <Icon type="ios-lock-outline" slot="prepend"></Icon>
	            </Input>
	        </FormItem>
	        <FormItem class="item">
	            <Button type="primary" @click="handleSubmit('formInline')">登录</Button>
	        </FormItem>
	    </Form>
		
	    
    </div>
</template>
<script>
export default {
  data () {
    return {
      formInline: {
        user: '',
        password: ''
      },
      ruleInline: {
        user: [
          { required: false, message: '请填写用户名', trigger: 'blur' }
        ],
        password: [
          { required: false, message: '请填写密码', trigger: 'blur' },
          { type: 'string', min: 0, message: '密码长度不能小于6位', trigger: 'blur' }
        ]
      }
    }
  },
  methods: {
    handleSubmit (name) {
      this.$refs[name].validate((valid) => {
        if (valid) {
          this.$Message.success('提交成功!');
          this.$router.push({path:'/home',query:{id:'参数'}});
        } else {
          this.$Message.error('表单验证失败!');
        }
      })
    }
  }
}
</script>
<style scoped>
	.bg-login{
		background:url(../assets/image/loginbg.jpg)  no-repeat;
		width:100%;
		height:100%;
		width:100%;  
    	background-size:100% 100%;  
    	position:absolute;  
    	filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(src='bg-login.png',sizingMethod='scale');
	}
	.bg{
		background:black;
		width:340px;
		height:200px;
		margin:0 auto;
		margin-top:200px;
		opacity:0.5;
	}
	.login{
		width:300px;
		position: absolute;
	    left: calc(50% - 150px);
	    top: 220px;
	}
	.item-center{
		margin:30px 0;
	}
</style>
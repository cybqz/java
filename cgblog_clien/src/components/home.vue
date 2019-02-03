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
						<span class="login-text" @click="loginModal = true">登录</span>
						<span class="login-text" @click="registerModal = true">注册</span>
					</div>
					<div v-show="logined">
                        <span class="login-text">
                            <Avatar src="https://i.loli.net/2017/08/21/599a521472424.jpg" />&nbsp;
                            {{formLogin.userName}}</span>
						<span class="login-text" @click="logout()">退出</span>
					</div>
				</div>
			</div>
		</div>
		<div class="containtWrap">
			<router-view/>
		</div>
		<Modal
        v-model="loginModal"
        title=""
        width="400">
        <p slot="header" style="color:#f60;text-align:center">
            <span>欢迎登陆</span>
        </p>
        <div style="text-align:center">
					<Form ref="formLogin" :model="formLogin" :rules="rulesLogin" inline>
						<FormItem prop="user">
								<Input type="text" v-model="formLogin.userName" placeholder="Username">
										<Icon type="ios-person-outline" slot="prepend"></Icon>
								</Input>
						</FormItem>
						<FormItem prop="password">
								<Input type="password" v-model="formLogin.password" placeholder="Password">
										<Icon type="ios-lock-outline" slot="prepend"></Icon>
								</Input>
						</FormItem>
					</Form>
        </div>
        <div slot="footer">
            <Button size="large" long :loading="login_loading" @click="handleLogin('formLogin')">登录</Button>
        </div>
    </Modal>
		<Modal
		    v-model="registerModal"
		    title=""
		    width="400">
		    <p slot="header" style="color:#f60;text-align:center">
		        <span>欢迎注册</span>
		    </p>
		    <div style="text-align:center">
					<Form ref="formRegister" :model="formRegister" :rules="rulesRegister" inline>
						<FormItem prop="user">
								<Input type="text" v-model="formRegister.userName" placeholder="Username">
										<Icon type="ios-person-outline" slot="prepend"></Icon>
								</Input>
						</FormItem>
						<FormItem prop="password">
								<Input type="password" v-model="formRegister.password" prop="password" placeholder="Password">
										<Icon type="ios-lock-outline" slot="prepend"></Icon>
								</Input>
						</FormItem>
						<FormItem prop="confirmpassword">
								<Input type="password" v-model="formRegister.confirmpassword" prop="confirmpassword" placeholder="Confirm Password">
										<Icon type="ios-lock-outline" slot="prepend"></Icon>
								</Input>
						</FormItem>
					</Form>
		    </div>
		    <div slot="footer">
		        <Button size="large" long :loading="register_loading" @click="handleRegister('formRegister')">注册</Button>
		    </div>
		</Modal>
	</div>
</template>

<script>
export default {
  name: 'home',
  data () {
		const validatePass = (rule, value, callback) => {
			if (value === '') {
					callback(new Error('请输入密码'));
			} else {
					if (this.formRegister.confirmpassword !== '') {
							// 对第二个密码框单独验证
							this.$refs.formRegister.validateField('confirmpassword');
					}
					callback();
			}
		};
		const validatePassCheck = (rule, value, callback) => {
			if (value === '') {
					callback(new Error('请输入密码'));
			} else if (value !== this.formRegister.password) {
					callback(new Error('两次密码不一致'));
			} else {
					callback();
			}
		};
    return {
			logined:false,
            tabActive:0,
			loginModal:false,
			login_loading:false,
			registerModal:false,
			register_loading:false,
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
			formLogin: {
					userName: '',
					password: ''
			},
			formRegister: {
					userName: '',
					password: '',
					confirmpassword:''
			},
			rulesLogin: {
				userName: [
						{ required: true, message: '请输入正确的用户名', trigger: 'blur' }
				],
				password: [
						{ required: true, message: 'Please fill in the password.', trigger: 'blur' },
						{ type: 'string', min: 1, message: '请输入正确的密码', trigger: 'blur' }
				]
			},
			rulesRegister: {
				userName: [
						{ required: true, message: '请输入正确的用户名', trigger: 'blur' }
				],
				password: [{ validator:validatePass, trigger: 'blur' }],
				confirmpassword: [{ validator:validatePassCheck, trigger: 'blur' }]
			}
    }
  },
  watch:{},
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
		handleLogin(formLogin) {
			this.$refs[formLogin].validate((valid) => {
					if(valid){
						this.login_loading = true;
						let url = this.$axios.defaults.baseURL + "loginController/login";
						let param = this.formLogin;
						this.$axios({method:'post', url:url, data:this.$qs.stringify(param)})
						.then((response) => {
							if( response.status == 200){
								let data = response.data;
								if(data.validate){
									this.loginModal=false;
									this.logined=true;
									this.$Message.success(data.msg);
								}else{
									this.$Message.error(data.msg);
								}
							}else{
								this.$Message.error('Fail!');
							}
						}).catch((error) => {
								console.log(error)
						})
						this.login_loading = false;
					} else {
							this.$Message.error('Valid Fail!');
					}
			})
		},
		handleRegister(formRegister) {
			this.$refs[formRegister].validate((valid) => {
					if(valid){
						this.register_loading = true;
						let url = this.$axios.defaults.baseURL + "registerController/register";
						let param = this.formRegister;
						this.$axios({method:'post', url:url, data:this.$qs.stringify(param)})
						.then((response) => {
							if( response.status == 200){
								let data = response.data;
								if(data.validate){
									this.registerModal=false;
									this.$Message.success(data.msg);
								}else{
									this.$Message.error(data.msg);
								}
							}else{
								this.$Message.error('Fail!');
							}
						}).catch((error) => {
								console.log(error)
						})
						this.register_loading = false;
					} else {
							this.$Message.error('Valid Fail!');
					}
			})
		},
		logout(){
			let url = this.$axios.defaults.baseURL + "loginController/logout";
			let param = this.formLogin;
			this.$axios({method:'post', url:url, data:this.$qs.stringify(param)})
			.then((response) => {
				if( response.status == 200){
					let data = response.data;
					if(data.validate){
						this.logined=false;
						this.$Message.success(data.msg);
					}else{
						this.$Message.error(data.msg);
					}
				}else{
					this.$Message.error('Fail!');
				}
			}).catch((error) => {
					console.log(error);
			})
		}
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

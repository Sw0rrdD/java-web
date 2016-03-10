<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="zh-cn">
  <head>
	  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	  <meta charset="utf-8">
	  <!-- Title and other stuffs -->
	  <title>网上银行系统</title> 
	  <meta name="keywords" content="Bootstrap后台管理系统" />
	  <meta name="description" content="Bootstrap后台管理系统" />
	  <meta name="viewport" content="width=device-width, initial-scale=1.0">
	  <meta name="author" content="">
	  <!-- Stylesheets -->
	  <link href="style/bootstrap.css" rel="stylesheet">
	  <link rel="stylesheet" href="style/font-awesome.css">
	  <link href="style/style.css" rel="stylesheet">
	  <link href="style/bootstrap-responsive.css" rel="stylesheet">
	  <link href="style/keyboardstyle.css" rel="stylesheet" type="text/css" />
	  
	  <!-- HTML5 Support for IE -->
	  <!--[if lt IE 9]>
	  <script src="js/html5shim.js"></script>
	  <![endif]-->
	
	  <!-- Favicon -->
	  <link rel="shortcut icon" href="img/favicon/favicon.png">

  </head>
  
  <body>
  <h2 class="center" >网上银行系统</h2>
	    <!-- Form area -->
	<div class="admin-form">
	  <div class="container">
	
	    <div class="row">
	      <div class="col-md-12">
	        <!-- Widget starts -->
	            <div class="widget worange">
	              <!-- Widget head -->
	              <div class="widget-head">
	                <i class="icon-lock"></i> 用户登录
	              </div>
	              <div class="widget-content">
	                <div class="padd">
	                  <!-- Login form -->
	                  <form action="login" method="post" class="form-horizontal">
	                    <!-- account -->
	                    <div class="form-group">
	                      <label class="control-label col-lg-3" for="inputaccount">帐号</label>
	                      <div class="col-lg-9">
	                        <input type="text" class="form-control" id="account" name="account" placeholder="Account">
	                      </div>
	                    </div>
	                    <!-- Password -->
	                    <div class="form-group">
	                      <label class="control-label col-lg-3" for="inputPassword">密码</label>
	                      <div class="col-lg-9">
	                        <input type="password" class="form-control" id="password" name="password" placeholder="Password">
	                      </div>
	                    </div>
	                    <!-- verification code -->
	                    <div class="form-group">
	                      <label class="control-label col-lg-3" for="verificationcode">验证码</label>
	                      <div class="col-lg-4">
	                        <input type="text" class="form-control" id="verificationcode" name="verificationcode" placeholder="Verificationcode">
	                      </div>
	                       <img src="<%=basePath%>servlet/imageRandServlet" onclick="this.src=this.src+'?'"/>
	                    </div>

	                        <div class="col-lg-9 col-lg-offset-2">
								<button type="submit" class="btn btn-danger">登录</button>
								<button type="reset" class="btn btn-default">重置</button>
							</div>
	                    <br />
	                  </form>
					  
					</div>
	                </div>
	              
	                <div class="widget-foot">
	                  未注册? <a href="register.jsp">注册</a>
	                </div>
	            </div>  
	      </div>
	    </div>
	  </div> 
	</div>
	<!-- JS -->
	<script src="js/jquery.js"></script>
	<script src="js/bootstrap.js"></script>
	<script type="text/javascript" src="js/JustWalking.js"></script>
	<script type="text/javascript" src="js/softKeyBoard.js"></script>
	<script type="text/javascript">
	initSoftKeyBoard("password");
</script>
  </body>
</html>

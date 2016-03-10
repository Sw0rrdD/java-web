<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
	  <title>用户注册页面 </title> 
	  <meta name="keywords" content="Bootstrap后台管理系统" />
	  <meta name="description" content="Bootstrap后台管理系统" />
	  <meta name="viewport" content="width=device-width, initial-scale=1.0">
	  <meta name="author" content="">
	  <!-- Stylesheets -->
	  <link href="style/bootstrap.css" rel="stylesheet">
	  <link rel="stylesheet" href="style/font-awesome.css">
	  <link href="style/style.css" rel="stylesheet">
	  <link href="style/bootstrap-responsive.css" rel="stylesheet">
	  
	  <!-- HTML5 Support for IE -->
	  <!--[if lt IE 9]>
	  <script src="js/html5shim.js"></script>
	  <![endif]-->
	
	  <!-- Favicon -->
	  <link rel="shortcut icon" href="img/favicon/favicon.png">

  </head>
  
  <body>
	  <div class="admin-form">
	  <div class="container">
	    <div class="row">
	      <div class="col-lg-12">
	        <!-- Widget starts -->
	            <div class="widget wred">
	              <div class="widget-head">
	                <i class="icon-lock"></i> 注册
	              </div>
	              <div class="widget-content">
	                <div class="padd">
	                  
	                  <form action="regist" method="post" class="form-horizontal">
	                    <!-- Registration form starts -->
	                                      <!-- Name -->
	                                          <div class="form-group">
	                                            <label class="control-label col-lg-3" for="name">姓名</label>
	                                            <div class="col-lg-9">
	                                              <input type="text" class="form-control" id="name" name="name">
	                                            </div>
	                                          </div>   
	                                          <!-- Account -->
	                                          <div class="form-group">
	                                            <label class="control-label col-lg-3" for="account">帐号</label>
	                                            <div class="col-lg-9">
	                                              <input type="text" class="form-control" id="account" name="account">
	                                            </div>
	                                          </div>                                        
	                                          <!-- Password -->
	                                          <div class="form-group">
	                                            <label class="control-label col-lg-3" for="Password">密码</label>
	                                            <div class="col-lg-9">
	                                              <input type="password" class="form-control" id="password" name="password">
	                                            </div>
	                                          </div>
	                                          <!-- SuperPassword -->
	                                          <div class="form-group">
	                                            <label class="control-label col-lg-3" for="SuperPassword">取款密码</label>
	                                            <div class="col-lg-9">
	                                              <input type="password" class="form-control" id="superpassword" name="superpassword">
	                                            </div>
	                                          </div>
	                                          <!-- Money -->
	                                          <div class="form-group">
	                                            <label class="control-label col-lg-3" for="Money">初始金额</label>
	                                            <div class="col-lg-9">
	                                              <input type="text" class="form-control" id="money" name="money">
	                                            </div>
	                                          </div>   
	                                          <!-- Email -->
	                                          <div class="form-group">
	                                            <label class="control-label col-lg-3" for="Email">Email</label>
	                                            <div class="col-lg-9">
	                                              <input type="text" class="form-control" id="email" name="email">
	                                            </div>
	                                          </div> 
	                                          <!-- Phone -->
	                                          <div class="form-group">
	                                            <label class="control-label col-lg-3" for="Phone">电话</label>
	                                            <div class="col-lg-9">
	                                              <input type="text" class="form-control" id="phone" name="phone">
	                                            </div>
	                                          </div> 
	                                          <div class="form-group">
	                                            <label class="control-label col-lg-3" for="Address">住址</label>
	                                            <div class="col-lg-9">
	                                              <input type="text" class="form-control" id="address" name="address">
	                                            </div>
	                                          </div> 
	                                          <!-- Accept box and button s-->
	                                          <div class="form-group">
	                                            <div class="col-lg-9 col-lg-offset-3">
	                                              <br />
	                                              <button id="register" name="register" type="submit" class="btn btn-danger">注册</button>
	                                              <button type="reset" class="btn btn-success">重置</button>
	                                            </div>
	                                          </div>
											  <br />
	                  </form>
	
	                </div>
	              </div>
	                <div class="widget-foot">
	                  已有帐号? <a href="login.jsp">登录</a>
	                </div>
	            </div>  
	      </div>
	    </div>
	  </div> 
	</div>
		
			
	
	<!-- JS -->
	<script src="js/jquery.js"></script>
	<script src="js/bootstrap.js"></script>
  </body>
</html>

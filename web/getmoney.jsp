<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.bank.model.Cards,com.bank.dao.CardDao"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<!-- Title and other stuffs -->
<title>欢迎使用我的网银</title>
<meta name="keywords" content="Bootstrap后台管理系统" />
<meta name="description" content="Bootstrap后台管理系统" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="author" content="">
<!-- Stylesheets -->
<link href="style/bootstrap.css" rel="stylesheet">
<!-- Font awesome icon -->
<link rel="stylesheet" href="style/font-awesome.css">
<!-- jQuery UI -->
<link rel="stylesheet" href="style/jquery-ui.css">
<!-- Calendar -->
<link rel="stylesheet" href="style/fullcalendar.css">
<!-- prettyPhoto -->
<link rel="stylesheet" href="style/prettyPhoto.css">
<!-- Star rating -->
<link rel="stylesheet" href="style/rateit.css">
<!-- Date picker -->
<link rel="stylesheet" href="style/bootstrap-datetimepicker.min.css">
<!-- CLEditor -->
<link rel="stylesheet" href="style/jquery.cleditor.css">
<!-- Uniform -->
<link rel="stylesheet" href="style/uniform.default.css">
<!-- Bootstrap toggle -->
<link rel="stylesheet" href="style/bootstrap-switch.css">
<!-- Main stylesheet -->
<link href="style/style.css" rel="stylesheet">
<!-- Widgets stylesheet -->
<link href="style/widgets.css" rel="stylesheet">
<link href="style/keyboardstyle.css" rel="stylesheet" type="text/css" />

<!-- HTML5 Support for IE -->
<!--[if lt IE 9]>
	  <script src="js/html5shim.js"></script>
	  <![endif]-->

<!-- Favicon -->
<link rel="shortcut icon" href="img/favicon/favicon.png">
</head>
<body>
	<div class="navbar navbar-fixed-top bs-docs-nav" role="banner">

		<div class="conjtainer">
			<!-- Menu button for smallar screens -->
			<div class="navbar-header">
				<button class="navbar-toggle btn-navbar" type="button"
					data-toggle="collapse" data-target=".bs-navbar-collapse">
					<span>Menu</span>
				</button>
				<!-- Site name for smallar screens -->
				<a href="index.html" class="navbar-brand hidden-lg">Bank</a>
			</div>



			<!-- Navigation starts -->
			<nav class="collapse navbar-collapse bs-navbar-collapse"
				role="navigation">

				<ul class="nav navbar-nav">

					<!-- Upload to server link. Class "dropdown-big" creates big dropdown -->
					<li class="dropdown dropdown-big">
						<!-- Dropdown -->
						<ul class="dropdown-menu">
							<li>
								<hr /> <!-- Dropdown menu footer -->
								<div class="drop-foot">
									<a href="#">View All</a>
								</div></li>
						</ul></li>

					<!-- Sync to server link -->
					<li class="dropdown dropdown-big">
						<!-- Dropdown -->
						<ul class="dropdown-menu">
							<li>
								<!-- Dropdown menu footer -->
								<div class="drop-foot">
									<a href="#">View All</a>
								</div></li>
						</ul></li>

				</ul>


				<!-- Links -->
				<ul class="nav navbar-nav pull-right">
					<li class="dropdown pull-right"><a data-toggle="dropdown"
						class="dropdown-toggle" href="#"> <i class="icon-user"></i> <%=request.getSession().getAttribute("account")%>
							<b class="caret"></b> </a> <!-- Dropdown menu -->
						<ul class="dropdown-menu">
						<li><a href="showuser.jsp"><i class="icon-user"></i>个人信息</a></li>
							<li><a href="setting.jsp"><i class="icon-cogs"></i> 修改密码</a>
							</li>
							<li><a href="<%=basePath%>LoginOutServlet"><i class="icon-off"></i> 退出</a>
							</li>
						</ul></li>

				</ul>
			</nav>

		</div>
	</div>


	<!-- Header starts -->
	<header>
		<div class="container">
			<div class="row">

				<!-- Logo section -->
				<div class="col-md-4">
					<!-- Logo. -->
					<div class="logo">
						<h1>
							<a href="#">Bank<span class="bold"></span> </a>
						</h1>
						<p class="meta">我的网银系统</p>
					</div>
					<!-- Logo ends -->
				</div>

				<!-- Button section -->
				<div class="col-md-4">

					<!-- Buttons -->
					<ul class="nav nav-pills">





					</ul>

				</div>

				<!-- Data section -->

				<div class="col-md-4">
					<div class="header-data"></div>
				</div>

			</div>
		</div>
	</header>

	<!-- Header ends -->

	<!-- Main content starts -->

	<div class="content">
		<!-- Sidebar -->
		<div class="sidebar">
			<div class="sidebar-dropdown">
				<a href="#">Navigation</a>
			</div>
			<!--- Sidebar navigation -->
			<ul id="nav">
				<!-- Main menu with font awesome icon -->
				<li><a href="mycard.jsp"><i class="icon-bar-chart"></i>
						我的账户</a></li>
				<li><a href="messages.jsp"><i class="icon-table"></i> 查看信息</a>
				</li>
				<li><a href="getmoney.jsp" class="open"><i class="icon-magic"></i> 取款功能 </a>
				</li>
				<li><a href="turnmoney.jsp"><i class="icon-tasks"></i> 转账功能</a>
				</li>
			</ul>
		</div>
		<!-- Sidebar ends -->
		<!-- Main bar -->
		<div class="mainbar">
			<!-- Page heading -->
			<div class="page-head">
				<h2 class="pull-left">
					<i class="icon-table"></i> 取款功能
				</h2>
				<div class="clearfix"></div>
			</div>
			
			<!-- Page heading ends -->
			<div class="matter">
	        <div class="container">
	
	          <div class="row">
	
	            <div class="col-md-12">
	
	
	              <div class="widget wgreen">
	                
	                <div class="widget-head">
	                  <div class="pull-left">取款单</div>
	                  <div class="widget-icons pull-right">
	                    <a href="#" class="wminimize"><i class="icon-chevron-up"></i></a> 
	                    <a href="#" class="wclose"><i class="icon-remove"></i></a>
	                  </div>
	                  <div class="clearfix"></div>
	                </div>
	
	                <div class="widget-content">
	                  <div class="padd">
	
	                    <h6>请填写以下内容</h6>
	                    <hr />
	                    <!-- Form starts.  -->
	                     <form action="getmoney" method="post" class="form-horizontal" role="form">                           
	                               	   <div class="form-group">
	                                  <label class="col-lg-8 control-label">取款账户</label>
	                                  <div class="col-lg-7">
	                                    <select class="form-control" name="cardnumber">
	                                    <%
												int index = 1;
												String account = request.getSession().getAttribute("account").toString();
												CardDao carddao = new CardDao();
												ArrayList<Cards> list = new ArrayList();
												list = carddao.ShowAllCard(account);
												for (int i = 0; i < index; i++) {
											%>
												<option>卡号：<%=list.get(i).getCardnumber()+"  "%>余额：<%=list.get(i).getMoney()%></option>
												<%
													}
												%>
	                                    </select>
	                                  </div>
	                                </div>  
	                                
	                                <div class="form-group">
	                                  <label class="col-lg-4 control-label">取款金额</label>
	                                  <div class="col-lg-7">
	                                    <input type="text" class="form-control" name="getmoney" placeholder="取款金额">
	                                  </div>
	                                </div>
	                                                           
	                                <div class="form-group">
	                                  <label class="col-lg-4 control-label">取款密码</label>
	                                  <div class="col-lg-7">
	                                    <input type="password" class="form-control" id="superpassword" name="superpassword" placeholder="取款密码">
	                                  </div>
	                                </div>
	                                <!-- verification code -->
	                    			<div class="form-group">
	                  			    <label class="control-label col-lg-3" for="verificationcode">验证码</label>
	                  			    <div class="col-lg-4">
	                  		      <input type="text" class="form-control" id="verificationcode" name="verificationcode" placeholder="验证码">
	                   			   </div>
	                       <img src="<%=basePath%>servlet/imageRandServlet" onclick="this.src=this.src+'?'"/>
	                    </div>
	                                <div class="form-group">
	                                  <div class="col-lg-offset-1 col-lg-9">
	                                    <button type="submit" class="btn btn-success">提交</button>
	                                    <button type="reset" class="btn btn-info">重置</button>	                               
	                                  </div>
	                                </div>
	                              </form>
	                  </div>
	                </div>
	                  <div class="widget-foot">
	                    <!-- Footer goes here -->
	                  </div>
	              </div>  
	
	            </div>
	
	          </div>
	
	        </div>
			  </div>
		</div>
	</div>
	<!-- Content ends -->
	<!-- Footer starts -->
	<footer>
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<!-- Copyright info -->
					<p class="copy">
						Copyright &copy; 2015 | <a href="mycard.jsp">My Bank</a>
					</p>
				</div>
			</div>
		</div>
	</footer>

	<!-- Footer ends -->

	<!-- Scroll to top -->
	<span class="totop"><a href="#"><i class="icon-chevron-up"></i>
	</a> </span>

	<!-- JS -->
	<script src="js/jquery.js"></script>
	<script type="text/javascript" src="js/JustWalking.js"></script>
	<script type="text/javascript" src="js/softKeyBoard.js"></script>
	<script type="text/javascript">
	initSoftKeyBoard("superpassword");
</script>
	<!-- jQuery -->
	<script src="js/bootstrap.js"></script>
	<!-- Bootstrap -->
	<script src="js/jquery-ui-1.9.2.custom.min.js"></script>
	<!-- jQuery UI -->
	<script src="js/fullcalendar.min.js"></script>
	<!-- Full Google Calendar - Calendar -->
	<script src="js/jquery.rateit.min.js"></script>
	<!-- RateIt - Star rating -->
	<script src="js/jquery.prettyPhoto.js"></script>
	<!-- prettyPhoto -->

	<!-- jQuery Flot -->
	<script src="js/excanvas.min.js"></script>
	<script src="js/jquery.flot.js"></script>
	<script src="js/jquery.flot.resize.js"></script>
	<script src="js/jquery.flot.pie.js"></script>
	<script src="js/jquery.flot.stack.js"></script>

	<!-- jQuery Notification - Noty -->
	<script src="js/jquery.noty.js"></script>
	<!-- jQuery Notify -->
	<script src="js/themes/default.js"></script>
	<!-- jQuery Notify -->
	<script src="js/layouts/bottom.js"></script>
	<!-- jQuery Notify -->
	<script src="js/layouts/topRight.js"></script>
	<!-- jQuery Notify -->
	<script src="js/layouts/top.js"></script>
	<!-- jQuery Notify -->
	<!-- jQuery Notification ends -->

	<script src="js/sparklines.js"></script>
	<!-- Sparklines -->
	<script src="js/jquery.cleditor.min.js"></script>
	<!-- CLEditor -->
	<script src="js/bootstrap-datetimepicker.min.js"></script>
	<!-- Date picker -->
	<script src="js/jquery.uniform.min.js"></script>
	<!-- jQuery Uniform -->
	<script src="js/bootstrap-switch.min.js"></script>
	<!-- Bootstrap Toggle -->
	<script src="js/filter.js"></script>
	<!-- Filter for support page -->
	<script src="js/custom.js"></script>
	<!-- Custom codes -->
	<script src="js/charts.js"></script>
	<!-- Charts & Graphs -->
</body>
</html>

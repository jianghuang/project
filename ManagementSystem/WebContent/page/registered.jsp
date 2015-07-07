<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<title>企业日常事务管理系统-注册登记</title>
		<link href="../css/css.css" type="text/css" rel="stylesheet" media="all" />
		<script src="../menu.js" type="text/javascript"></script>
	</head>

	<body>
		<div id="topexplain">企业日常事务管理系统，为企业内部通信提供最简便的服务！</div>
		<div id="topmenu"><img src="../images/banner.jpg" width="970" height="110" /></div>
		<div id="bookmunu">
			<div class="jsmenu" id="jsmenu">
				<ul>
			  		<li class="normal"><a href="../index.jsp" urn="#jsmenu1" rel="conmenu">首页</a></li>
			 		<li class="normal"><a urn="jsmenu2" rel="conmenu" href="../GetMessageList">消息列表</a></li>
			  		<li class="normal"><a urn="jsmenu3" rel="conmenu" href="publishNewMsg.jsp">发布新消息</a></li>
			  		<li class="active"><a urn="default_Info" rel="conmenu" href="statusRecognise.jsp">身份识别</a></li>
			 	</ul>
			</div>
			<div id="conmenu"></div>
		</div>
	
		<div id="indexfirst1">
			<div id="place">当前位置：[<a href="../index.jsp">首页</a>] - [员工注册登记]</div>
			<div id="menunav3">
				<div class="tit">
					<h1>员工注册登记</h1>
				</div>
				<div id="dengjizhuce">
					<font color="red">${requestScope.error }</font>
					<form action="Registered" method="post">
					  	<p>员工编号：<input type="text" name="employeeID" value="${param.employeeID}"/></p>
					  	<p>&nbsp;</p>
					  	<p>员工姓名：<input type="text" name="employeeName" value="${param.employeeName}"/></p>
					  	<p>&nbsp;</p>
					  	<p>员工性别：&nbsp;&nbsp;<input type="radio" name="employeeSex" value="男" />男&nbsp;&nbsp;&nbsp;<input type="radio" name="employeeSex" value="女" />女</p>
					  	<p>&nbsp;</p>
					  	<p>出生日期：<input type="text" name="employeeBirth" value="${param.employeeBirth}"/></p>
					  	<font color="green">日期格式：1901-01-01</font>
					  	<p>&nbsp;</p>
					  	<p>联系电话：<input type="text" name="employeePhone" value="${param.employeePhone}"/></p>
					  	<p>&nbsp;</p>
					  	<p>家庭住址：<input type="text" name="employeePlace" value="${param.employeePlace}"/></p>
					  	<p>&nbsp;</p>
					  	<p>系统口令：<input type="password" name="password1" /></p>
					  	<p>&nbsp;</p>
					  	<p>确认口令：<input type="password" name="password2" /></p>
					  	<p>&nbsp;</p>
					  	<p>是否领导：&nbsp;&nbsp;<input type="radio" name="isLead" value="是" />是&nbsp;&nbsp;&nbsp;<input type="radio" name="isLead" value="否" />否 </p>
					  	<p>&nbsp;</p>
					  	<p>
					  		<input type="submit" value="提交" />
					    	<input type="reset" value="重置" />
					    </p>
	   				 </form>
				</div>
			</div>
		</div>
	
		<div class="copyright">
			<ul><li></li>
				<li>企业日常事务管理系统 &nbsp;&copy;2009-2010</li>
			</ul>
		</div>
		<div class="end"></div>
		
		<script type=text/javascript>
			startajaxtabs("jsmenu");
			var iTab=GetCookie("nets_jsmenu");
				iTab = iTab ? parseInt(iTab):parseInt(Math.random()*5);
				if(iTab!=0) getElement("jsmenu").getElementsByTagName("h1")[iTab].LoadTab();
				iTab++;
				if(iTab>4) iTab=0;
				SetCookie("nets_jsmenu",iTab,365);
			function getElement(aID)
			{
			  return (document.getElementById) ? document.getElementById(aID)
			                                   : document.all[aID];
			}
		</script>

	</body>
</html>


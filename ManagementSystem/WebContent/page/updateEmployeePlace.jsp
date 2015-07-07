<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<title>企业日常事务管理系统-更新员工信息</title>
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
		
		<div id="indexfirst">
		<div id="place">当前位置：[<a href="../index.jsp">首页</a>] - [员工信息更新]</div>
			<div id="thenew">
				<div class="tit">
					<h1>员工信息更新</h1>
				</div>
				<div id="xinxigengxin">
					<font color="red">${requestScope.error }</font>
					<form action="UpdateEmployeePlace" method="post">
					  	<p>家庭住址：<input type="text" name="employeePlace" value="${param.employeePlace}"/></p>
					  	<p>&nbsp;</p>
					  	<p>&nbsp;</p>
					  	<p>
					  		<input type="submit" value="提交" />
					  		&nbsp;&nbsp;
					    	<input type="reset" value="重置" />
					    </p>
	   				 </form>
				</div>
			</div>
			
			<div id="menunav">
				<div class="tit">
					<h1>员工信息</h1>
				</div>
				<div id="employee">
					<ul>
					  <li>员工编号：${employee.employeeID}</li>
					  <li>员工姓名：${employee.employeeName}</li>
					  <li>员工性别：${employee.employeeSex ? "男" : "女"}</li>
					  <li>出生日期：${employee.employeeBirth }</li>
					  <li>办公室电话：${employee.employeePhone }</li>
					  <li>住址：${employee.employeePlace }</li>
					  <li>管理层领导：${employee.lead ? '是' : '否'}</li>
					</ul>
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


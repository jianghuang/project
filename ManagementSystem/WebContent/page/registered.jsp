<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<title>��ҵ�ճ��������ϵͳ-ע��Ǽ�</title>
		<link href="../css/css.css" type="text/css" rel="stylesheet" media="all" />
		<script src="../menu.js" type="text/javascript"></script>
	</head>

	<body>
		<div id="topexplain">��ҵ�ճ��������ϵͳ��Ϊ��ҵ�ڲ�ͨ���ṩ����ķ���</div>
		<div id="topmenu"><img src="../images/banner.jpg" width="970" height="110" /></div>
		<div id="bookmunu">
			<div class="jsmenu" id="jsmenu">
				<ul>
			  		<li class="normal"><a href="../index.jsp" urn="#jsmenu1" rel="conmenu">��ҳ</a></li>
			 		<li class="normal"><a urn="jsmenu2" rel="conmenu" href="../GetMessageList">��Ϣ�б�</a></li>
			  		<li class="normal"><a urn="jsmenu3" rel="conmenu" href="publishNewMsg.jsp">��������Ϣ</a></li>
			  		<li class="active"><a urn="default_Info" rel="conmenu" href="statusRecognise.jsp">���ʶ��</a></li>
			 	</ul>
			</div>
			<div id="conmenu"></div>
		</div>
	
		<div id="indexfirst1">
			<div id="place">��ǰλ�ã�[<a href="../index.jsp">��ҳ</a>] - [Ա��ע��Ǽ�]</div>
			<div id="menunav3">
				<div class="tit">
					<h1>Ա��ע��Ǽ�</h1>
				</div>
				<div id="dengjizhuce">
					<font color="red">${requestScope.error }</font>
					<form action="Registered" method="post">
					  	<p>Ա����ţ�<input type="text" name="employeeID" value="${param.employeeID}"/></p>
					  	<p>&nbsp;</p>
					  	<p>Ա��������<input type="text" name="employeeName" value="${param.employeeName}"/></p>
					  	<p>&nbsp;</p>
					  	<p>Ա���Ա�&nbsp;&nbsp;<input type="radio" name="employeeSex" value="��" />��&nbsp;&nbsp;&nbsp;<input type="radio" name="employeeSex" value="Ů" />Ů</p>
					  	<p>&nbsp;</p>
					  	<p>�������ڣ�<input type="text" name="employeeBirth" value="${param.employeeBirth}"/></p>
					  	<font color="green">���ڸ�ʽ��1901-01-01</font>
					  	<p>&nbsp;</p>
					  	<p>��ϵ�绰��<input type="text" name="employeePhone" value="${param.employeePhone}"/></p>
					  	<p>&nbsp;</p>
					  	<p>��ͥסַ��<input type="text" name="employeePlace" value="${param.employeePlace}"/></p>
					  	<p>&nbsp;</p>
					  	<p>ϵͳ���<input type="password" name="password1" /></p>
					  	<p>&nbsp;</p>
					  	<p>ȷ�Ͽ��<input type="password" name="password2" /></p>
					  	<p>&nbsp;</p>
					  	<p>�Ƿ��쵼��&nbsp;&nbsp;<input type="radio" name="isLead" value="��" />��&nbsp;&nbsp;&nbsp;<input type="radio" name="isLead" value="��" />�� </p>
					  	<p>&nbsp;</p>
					  	<p>
					  		<input type="submit" value="�ύ" />
					    	<input type="reset" value="����" />
					    </p>
	   				 </form>
				</div>
			</div>
		</div>
	
		<div class="copyright">
			<ul><li></li>
				<li>��ҵ�ճ��������ϵͳ &nbsp;&copy;2009-2010</li>
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


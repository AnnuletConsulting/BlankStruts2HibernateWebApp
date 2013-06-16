<%@ page contentType="text/html; charset=UTF-8"
	import="com.annuletconsulting.struts2.LoginAction, com.annuletconsulting.spring.model.User" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Welcome Page</title>
	<jsp:include page="css.jsp" />
	<jsp:include page="javascripts.jsp" />
</head>
<% User user = (User) session.getAttribute(LoginAction.USER_OBJ); %>
<body>
	<h2>Hello, <%=user.getName()%>!</h2>
	You have successfully logged on as <s:property value="username" />.<br />
	<br />
	<a href="logout.action">Logout</a><br />
	<br />
	<input type="button" class="ui-button" value="Check User Count" onclick="checkUsers()" />
	<br><br>
	<input type="button" class="ui-button" value="Load Users" onclick="loadUsers()" />
	<br><select id="userSelect" >
	</select>
</body>
</html>

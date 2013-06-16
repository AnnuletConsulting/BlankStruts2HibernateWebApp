<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Login Page</title>
	<meta name="viewport" content="width: 800px">
	<jsp:include page="css.jsp" />
	<jsp:include page="javascripts.jsp" />
<script>
  $(function() {
    $( "#tabs" ).tabs();
  });
</script>
</head>
<body>
<h2>Login</h2>
<s:actionerror />
	<div id="tabs">
		<ul>
			<li><a href="#loginDiv">Login</a></li>
			<li><a href="#signupDiv">Signup</a></li>
		</ul>
		<div id="loginDiv">
			Please login to continue:
			<s:form action="login.action" method="post">
				<s:textfield name="username" key="label.username" size="20" required="true" />
				<s:password name="password" key="label.password" size="20" required="true" />
				<s:submit method="authenticate" key="label.login" align="center" />
			</s:form>
		</div>
		<div id="signupDiv">
			<s:form action="signup.action" theme="xhtml" method="post">
				<s:textfield name="name" key="label.name" size="20" required="true" />
				<s:textfield name="username" key="label.username" size="20" required="true" />
				<s:password name="password" key="label.password" size="20" required="true" />
				<s:password name="confirmPassword" key="label.confirm_password" size="20" required="true" />
				<s:submit method="signup" key="label.signup" align="center" />
			</s:form>
		</div>
	</div>
</body>
</html>

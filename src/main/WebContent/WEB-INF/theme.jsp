<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
<link rel="stylesheet" type="text/css"
	href="<spring:theme code='helloworld'/>" />
</head>
<body>
	<div id="divTheme"><h1><spring:message code='hello'/></h1></div>
	<a href="changeTheme.action?themeName=blue"> blue</a>
	<a href="changeTheme.action?themeName=gray"> gray</a>
	<a href="changeTheme.action?themeName=red"> red</a>
</body>
</html>

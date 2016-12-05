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
	<h1><spring:message code='hello'/></h1>
	<div id="divTheme"></div>

	<input type="button" value="json input test 1"
		onclick="doTestJson('json1')" />
	<input type="button" value="json input test 2"
		onclick="doTestJson('json2')" />
	<input type="button" value="json out test 3"
		onclick="doTestJson('json3.json')" />
	<br />
	<input type="button" value="json valid test 1"
		onclick="doTestJson('validJson1',getValidData('winzip','winzip','138188888'))" />
	<input type="button" value="json valid test 2"
		onclick="doTestJson('validJson2',getValidData('winzip','winzip','13888888'))" />
	<br />
	<a href="http://localhost:8080/springmvc/changeTheme?themeName=red"> set theme to red</a>
	<a href="http://localhost:8080/springmvc/changeTheme?themeName=blue"> set theme to blue</a>
	<a href="http://localhost:8080/springmvc/changeTheme?themeName=grey"> set theme to grey</a>
	<br/>
	<input type="button" value="xml input jaxb test"
		onclick="doTestXML('xml.xml')" />
	<input type="button" value="xml input domsource test2"
		onclick="doTestXML('xml2.xml')" />
    <br/>
    <input type="button" value="set Local to EN By Cookie client" 
      onclick="setCookie('clientlanguage','en')"/>
      
    <input type="button" value="set Local to CN By Cookie client" 
      onclick="setCookie('clientlanguage','zh_CN')"/>
    
	<a href="http://localhost:8080/springmvc/changeLocale?locale=en"> set Local to EN</a>
	<a href="http://localhost:8080/springmvc/changeLocale?locale=zh_CN"> set Local to CN</a>

                
	<script type="text/javascript" src="js/json2.js"></script>
	<script type="text/javascript" src="js/jquery-1.6.1.js"></script>
	<script type="text/javascript" src="js/helloworld.js"></script>
</body>
</html>

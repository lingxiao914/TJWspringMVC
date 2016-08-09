<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<title>title</title>
<style type="text/css">
.select {
	float: right;
}
</style>
<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.0.js" type="text/javascript"></script>
<script type="text/javascript"  language="javascript">

$(document).ready(function(){
	  $("select").change(function(){
		  var language = $("select").val();
		  location.href = "language.action?language="+language;
	  });
	});
</script>
</head>
<body>
	语言: ${language}

	<select  name= "language" id="language" class="select" >
		<option value="">默认</option>
		<option value="zh">中文</option>
		<option value="en">English</option>
	</select>
</body>
</html>

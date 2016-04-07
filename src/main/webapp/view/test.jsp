<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'test.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<script src="resource/js/jQuery/jquery-1.8.2.js" type="text/javascript"></script>
<script src="resource/js/test.js" type="text/javascript"></script>
</head>

<body>

	<table>
		<tr>
			<td><input type="text" id="addtestid" placeholder="test id" /></td>
			<td><input type="text" id="addtestname" placeholder="test name" /></td>
			<td><input type="button" id="addtest" value="添加" /></td>
		</tr>
	</table>
	<table>
		<tr>
			<td><input type="text" id="testid" placeholder="test id" /></td>
			<td><input type="button" id="gettest" value="查找" /></td>
			<td><input type="button" id="updatetest" value="修改" /></td>
			<td><input type="button" id="deletetest" value="删除" /></td>
		</tr>
	</table>

	<div>
		<table id="testdiv">

		</table>
	</div>
</body>
</html>

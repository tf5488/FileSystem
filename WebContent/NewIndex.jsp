<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>文件管理系统</title>
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>

</head>
<body>
<h1>文件管理系统   v0.01</h1>
<hr>
<h3>
<c:if test="${empty path }">我的电脑磁盘</c:if>
${path }索引:</h3>
<a href="RoolBackServlet?temp=${path }">上一页</a>
<ul>
<c:if test="${empty filelist}">
	<script type="text/javascript">
		location.href="FileTreeServlet"
	</script>
</c:if>
<c:forEach items="${filelist }" var="file">
	<li><a href="FileTreeServlet?temp=${file }">${file }</a></li>
</c:forEach>
</ul>
</body>
</html>
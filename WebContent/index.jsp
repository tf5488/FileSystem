<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>文件管理系统</title>
</head>
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("a").click(function(){
			var temp = $(this).attr("id")
			alert(temp)
			$(this).append("<ul></ul>")
			$.ajax({
				url:"FileTreeServlet",
				type:"post",
				data:"temp="+temp,
				dataType:"json",
				success:function(ret){
					$.each(ret,function(k,v){
						var $text = "<li><a href='#' id='"+v+"'>"+v+"</a></li>"
						$($text).insertBefore("span")
					});
				}
			});
		});
		
		
	});

</script>
<body>
	<h1>文件管理系统   v0.01</h1>
	<div id = "tree">
		<h3><a href="#" id="root">我的电脑:</a></h3>
		<!-- <ul>
			<li>
				<a href="#" id="child2">child2</a>
				<ul>
					<li>
						<a href="#" id="child3">child3</a>
						<ul>
							<li>
								<a href="#" id="child4">child4</a>
							</li>
						</ul>
					</li>
				</ul>
			</li>
		</ul> -->
		<a href="#" id="child1">child2</a>
		<a href="#" id="child2">child2</a>
		<a href="#" id="child3">child2</a>
		<span ></span>
	</div>
</body>
</html>
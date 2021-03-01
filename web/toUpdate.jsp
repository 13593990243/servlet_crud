<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="/static/css/bootstrap-3.3.7-dist/css/bootstrap.css">
</head>
<body>
<form action="/sys/user/update" method="post">
    <input type="text" name="id" value="${user.id}" style="display: none">
    账号：<input type="text" name="username" value="${user.username}"><br><br>
    密码：<input type="password" name="password" value="${user.password}"><br><br>
    性别：<input type="radio" name="sex" value="1"  <c:if test="${user.sex==1}">checked</c:if>>男
    <input type="radio" name="sex" value="0"  <c:if test="${user.sex==0}">checked</c:if>>女
    <br><br>
    <input type="submit" value="修改" class="btn btn-success"><br><br>
</form>
</body>
</html>
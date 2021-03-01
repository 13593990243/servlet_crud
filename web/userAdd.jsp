<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="/static/css/bootstrap-3.3.7-dist/css/bootstrap.css">
</head>
<body>
<form action="/sys/user/add" method="post">
    账号：<input type="text" name="username"><br><br>
    密码：<input type="password" name="password"><br><br>
    性别：<input type="radio" name="sex" value="1">男
    <input type="radio" name="sex" value="0">女
    <br><br>
    <input type="submit" value="添加" class="btn btn-success"><br><br>
</form>
</body>
</html>
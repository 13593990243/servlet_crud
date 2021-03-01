<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title></title>
  </head>
  <body>
  <form action="/sys/login" method="post">
      账号：<input type="text" name="username"><br><br>
      密码：<input type="password" name="password"><br><br>
      <input type="checkbox" name="remember" value="remember">记住我<br><br>
      <input type="submit" value="登录"><br><br>
  </form>
  ${msg}
  </body>
</html>
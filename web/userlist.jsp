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
<style>
    .top {
        margin: 20px;
    }

    .left {
        padding-top: 5px;
        float: left;
        width: 350px;
    }

    .left span {
        font-size: 18px;
    }

    .mian {
        float: left;
    }

    .mian a {
        text-decoration: none;
    }

    .footer {
        float: right;
    }

    .footer a {
        text-decoration: none;

    }
</style>
<body>
<div class="head">
    <div class="top">
        <div class="left">
            <span>当前在线人数：${count};</span>&nbsp;&nbsp;
            <span>欢迎用户：${username}</span>
        </div>
        <div class="mian">
            <a href="/userAdd.jsp" class="btn btn-success">添加</a>
        </div>
        <div class="footer">
            <a href="/index.jsp" class="btn btn-primary">退出登录</a>
        </div>
    </div>
    <table id="table" class="table table-bordered table-hover" style="text-align: center">
        <tr>
            <td>序号</td>
            <td>id</td>
            <td>姓名</td>
            <td>性别</td>
            <td>创建日期</td>
            <td>操作</td>
        </tr>

        <c:forEach items="${usersList}" var="user" varStatus="status">
            <tr>
                <td>${status.index}</td>
                <td>${user.id}</td>
                <td>${user.username}</td>
                <td>
                    <c:choose>
                        <c:when test="${user.sex==1}">男</c:when>
                        <c:when test="${user.sex==0}">女</c:when>
                        <c:otherwise>未知</c:otherwise>
                    </c:choose>
                </td>
                <td>
                    <fmt:parseDate value="${user.createTime}" var="createTime"
                                   pattern="yyyy-MM-dd HH:mm:ss"></fmt:parseDate>
                    <fmt:formatDate value="${createTime}" pattern="yyyy年MM月dd日 HH时mm分ss秒"></fmt:formatDate>
                </td>
                <td><a href="/sys/user/deleteById?id=${user.id}" class="btn btn-danger">删除</a>&nbsp;&nbsp;
                    <a href="/sys/user/toUpdate?id=${user.id}" class="btn btn-primary">修改</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
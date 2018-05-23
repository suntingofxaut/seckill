<%--
  Created by IntelliJ IDEA.
  User: 孙挺
  Date: 2018/4/15
  Time: 13:51
  To change this template use File | Settings | File Templates.
--%>
<%@include file="common/tag.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>商品列表页</title>
    <%@include file="common/head.jsp"%>
</head>
<body>
<div class="container">
    <div class="panel panel-default">
        <a type="submit" class="btn btn-default" href='http://localhost:8080/seckill/list'>返回</a>
        <div class="panel-heading text-center">
            <h2>抢购列表</h2>
        </div>
        <div class="panel-body">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>订单号</th>
                    <th>商品名称</th>
                    <th>商品数量</th>
                    <th>抢购时间</th>
                    <th>抢购状态</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${list}" var="sk">
                    <tr>
                        <td>${sk.seckillId}</td>
                        <td>${sk.name}</td>
                        <td>1件</td>
                        <td>
                            <fmt:formatDate value="${sk.createTime}" pattern="yyyy-MM-dd HH:mm:ss" />
                        </td>
                        <td>成功</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="http://apps.bdimg.com/libs/jquery/2.0.0/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>
</body>
</html>

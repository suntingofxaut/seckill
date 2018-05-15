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
    <title>修改商品页</title>
    <%@include file="common/head.jsp"%>
</head>

<body>
<div class="container">
    <div class="panel-heading text-center">
        <h2>修改商品</h2>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="row clearfix">
                <div class="col-md-4 column">
                </div>
                <div class="col-md-4 column">
                    <form role="form" >
                        <div class="form-group">
                            <label for="name">名称</label><input type="text" class="form-control" id="name" />
                        </div>
                        <div class="form-group">
                            <label for="number">数量</label><input type="text" class="form-control" id="number" />
                        </div>
                        <div class="form-group">
                            <label for="startTime">开始时间</label><input type="date" class="form-control" id="startTime" />
                        </div>
                        <div class="form-group">
                            <label for="endTime">结束时间</label><input type="date" class="form-control" id="endTime" />
                        </div>
                        <button type="submit" class="btn btn-default">Submit</button>
                    </form>
                </div>
                <div class="col-md-4 column">
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>

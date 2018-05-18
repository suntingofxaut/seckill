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
        <h2>修改抢购商品</h2>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="row clearfix">
                <div class="col-md-4 column">
                </div>
                <div class="col-md-4 column">
                    <form role="form" method="post" id="updateGoodForm">
                        <div class="form-group">
                            <label for="name1">商品名称</label><input type="text" name="name1" class="form-control" id="name1" />
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
                        <div class="form-group">
                            <label for="exampleInputFile">商品图片</label><input type="file" id="exampleInputFile" />
                        </div>
                        <button type="submit" class="btn btn-default" onclick="seckill.updateGood(name1.value, number.value, startTime.value, endTime.value)">确认修改</button>
                        <a type="submit" class="btn btn-default" href='http://localhost:8080/seckill/listSeller'>取消</a>
                    </form>
                </div>
                <div class="col-md-4 column">
                </div>
            </div>
        </div>
    </div>
</div>
</body>

<script src="/resource/script/seckill.js" type="text/javascript"></script>
<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
</html>

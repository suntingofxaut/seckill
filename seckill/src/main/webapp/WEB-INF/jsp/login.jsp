<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%@include file="common/tag.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>首页</title>
    <%@include file="common/head.jsp" %>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="row clearfix">
                <div class="col-md-4 column">
                </div>
                <div class="col-md-4 column">
                    <img width="390" height="250" src="../../resource/picture/index.jpg" />

                    <form role="form" method="post">
                        <div class="form-group">
                            <label for="username">用户名</label><input type="text" class="form-control" name="username" id="username" />
                        </div>
                        <div class="form-group">
                            <label for="password">密码   </label><input type="password" class="form-control" name="password" id="password" />
                        </div>
                        <div class="form-group">
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <button type="submit" class="btn btn-default" onclick="seckill.userlogin(username.value,password.value)">用户登录</button>
                            &nbsp;&nbsp;&nbsp;&nbsp;
                            <button type="submit" class="btn btn-default" onclick="seckill.sellerlogin(username.value,password.value)" >管理员登录</button>
                        </div>
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

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="http://apps.bdimg.com/libs/jquery/2.0.0/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>
</body>

</html>

<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%@include file="WEB-INF/jsp/common/tag.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>首页</title>
    <%@include file="WEB-INF/jsp/common/head.jsp" %>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="row clearfix">
                <div class="col-md-4 column">
                </div>
                <div class="col-md-4 column">
                    <img width="390" height="250" src="./resource/picture/index.jpg" />

                    <form role="form">
                        <div class="form-group">
                            <label for="user-name-label">用户名</label><input type="email" class="form-control" id="user-name-label" />
                        </div>
                        <div class="form-group">
                            <label for="password-label">密码   </label><input type="password" class="form-control" id="password-label" />
                        </div>
                        <div class="form-group">
                            &nbsp;&nbsp;&nbsp;&nbsp;
                            <a class="btn btn-info" href="/seckill/list" target="_blank">登录</a>
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

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="http://apps.bdimg.com/libs/jquery/2.0.0/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>
</body>

</html>

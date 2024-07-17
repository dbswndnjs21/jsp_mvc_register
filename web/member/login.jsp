<%--
  Created by IntelliJ IDEA.
  User: jhta
  Date: 2024-07-17
  Time: 오전 10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>로그인</h1>
<form action="<%=request.getContextPath()%>/member/login" method="post">
     아이디 <input type="text" name="id"> <br>
    비밀번호 <input type="password" name="pwd"> <br>
    <div>${msg}</div>
    <input type="submit" value="로그인">
</form>
</body>
</html>

<%@ page import="test.dto.Member" %><%--
  Created by IntelliJ IDEA.
  User: jhta
  Date: 2024-07-17
  Time: 오전 9:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Member member = (Member) request.getAttribute("member");
%>
<h1>회원 정보 수정</h1>
<form action="<%=request.getContextPath()%>/member/update" method="post">
    회원아이디 <br>
    <input type="text" name="id" value="<%=member.getId()%>" readonly="readonly">  <br>
    비밀번호 <br>
    <input type="password" name="pwd" value="<%=member.getPwd()%>"> <br>
    이메일 <br>
    <input type="text" name="email" value="<%=member.getEmail()%>">  <br>
    나이 <br>
    <input type="text" name="age" value="<%=member.getAge()%>">  <br>
    <div>가입일 <%=member.getRegdate()%></div>
    <input type="submit" value="등록">
</form>
</body>
</html>

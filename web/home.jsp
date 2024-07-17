<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>home 입니다</title>
</head>
<body>
<ul>
    <li><a href="${pageContext.request.contextPath}/member/join">☆회★원☆가★입☆</a> </li>
    <li><a href="<%=request.getContextPath()%>/member/login">로 그 인</a> </li>
    <%
        if (session.getAttribute("id") != null) {
    %>
    <li><a href="<%=request.getContextPath()%>/member/logout">로 그 아 웃</a> </li>
    <%
        }
    %>
    <li><a href="<%=request.getContextPath()%>/member/list">회 원 목 록</a> </li>
</ul>
</body>
</html>

<%@ page import="test.dto.Member" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>회원 리스트</h1>
<%
    ArrayList<Member> list = (ArrayList<Member>)request.getAttribute("list");

    StringBuilder sbHtml = new StringBuilder();

    sbHtml.append("<table width='800' border='1' cellpadding='0'>");

    for (Member to : list) {
        sbHtml.append("<tr>");
        sbHtml.append("<td>" + to.getId() + "</td>");
        sbHtml.append("<td>" + to.getPwd() + "</td>");
        sbHtml.append("<td>" + to.getEmail() + "</td>");
        sbHtml.append("<td>" + to.getAge() + "</td>");
        sbHtml.append("<td>" + to.getRegdate() + "</td>");
        sbHtml.append("<td> <a href='" + request.getContextPath() + "/member/update?id=" + to.getId() + "'>수정</a></td>");
        sbHtml.append("<td> <a href='" + request.getContextPath() + "/member/delete?id=" + to.getId() + "'>삭제</a></td>");
        sbHtml.append("</tr>");
    }
    sbHtml.append("</table>");
%>
<%=sbHtml%>
</body>
</html>

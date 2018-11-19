<%--
  Created by IntelliJ IDEA.
  User: ak
  Date: 2018/11/18
  Time: 下午5:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>测试页面</title>
</head>
<body>
<c:forEach var="error" items="${requestScope.errors}">
    ${error.defaultMessage}
</c:forEach>
<hr>
<fmt:message key="resource.welcome"/><br>
<fmt:message key="resource.exist"/>
    "welcome springMVC"<br>
    ${requestScope.student.id} - ${requestScope.student.name}<br>
    ${requestScope.student2.id} - ${requestScope.student2.name}<br>
    ${requestScope.student3.id} - ${requestScope.student3.name}<br>
    ${requestScope.student4.id} - ${requestScope.student4.name}<br>
    <hr>
    ${sessionScope.student.id} = ${sessionScope.student.name}<br>
    ${sessionScope.student2.id} = ${sessionScope.student2.name}<br>
    ${sessionScope.student3.id} = ${sessionScope.student3.name}<br>
    ${sessionScope.student4.id} = ${sessionScope.student4.name}<br>
</body>
</html>

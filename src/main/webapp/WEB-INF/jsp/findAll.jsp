<%--
  Created by IntelliJ IDEA.
  User: cotletkaman
  Date: 16.02.16
  Time: 21:08
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML>
<BODY>
<%= new java.util.Date() %>
<br>
<p>
    items in your cart :<br />
    <c:forEach var="item" items="${it}">
        ${item.name}<br />
    </c:forEach>
</p>
<br>
<a href="AddNew">AddNew</a>
</BODY>
</HTML>
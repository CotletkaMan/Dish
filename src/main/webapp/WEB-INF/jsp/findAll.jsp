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
<body>
<a href="?type=ALL">Все</a> <a href="?type=FIRST">Первое</a> <a href="?type=SECOND">Второе</a> <a href="?type=DESERT">Десерт</a>
<br>
<p>
    <h2>Dishes</h2><br>
    <ul>
    <c:forEach var="item" items="${it}">
        <li><a href="dishes/${item.id}">${item.name}</a></li>
    </c:forEach>
    </ul>
</p>
<br>
<a href="./dishes/AddNew">AddNew</a>
</body>
</HTML>
<%--
  Created by IntelliJ IDEA.
  User: cotletkaman
  Date: 08.03.16
  Time: 19:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<html>
<head>
    <title>${it.name}</title>
</head>
<body>
<label for="name">Название</label> <span id="name">${it.name}</span><br>
<label for="type">Тип</label> <span id="type">${it.typeDishes}</span><br>
<label for="description">Описание</label> <span id="description"><ul>
    <c:forEach var="item" items="${it.recipe}">
        <li>${item}</li>
    </c:forEach>
    </ul></span><br>
<input type="button" onclick="deleteFunction()" value="Delete">

</body>
<script>
    function deleteFunction() {
        $.ajax({
            url: "./${it.id}",
            type: "DELETE",
            async: false,
            success: function(){
                location.href = "/Dish-1/dishes?type=ALL"
            }
        });
    }
</script>
</html>

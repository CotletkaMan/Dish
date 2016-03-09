<%--
  Created by IntelliJ IDEA.
  User: cotletkaman
  Date: 16.02.16
  Time: 21:08
  To change this template use File | Settings | File Templates.
--%>
<HTML>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<body>
<label for="name">Название блюда</label>
<input style="width: 100px; margin-left: 2px; " type="text" id="name" name="name">
<br>
<label for="type">Тип блюда</label>
<select id = "type">
    <option>FIRST</option>
    <option>SECOND</option>
    <option>DESERT</option>
</select>
<br>
<label for="message">Описание блюда</label>
<input style="width: 100px; height: 200px ; margin-left: 2px;" type="text" id="message" name="message">
<br>
<input type="button" onclick="callServlet()" value="Add">  <a href="../dishes?type=ALL">lookAll</a>

</body>
<script>
    function callServlet() {
        var input1 = document.getElementById('name').value;
        var input2 = document.getElementById('message').value;
        var input3 = document.getElementById('type').value;
        var myData = {"name": input1, "recipe": [input2], "typeDishes": input3};
        var jsonData = JSON.stringify(myData);
        $.ajax({
            url: "../dishes/AddNew",
            type: "POST",
            contentType: "application/json",
            data: jsonData
        });
    }
</script>
</HTML>
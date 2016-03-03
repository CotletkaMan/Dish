<%--
  Created by IntelliJ IDEA.
  User: cotletkaman
  Date: 16.02.16
  Time: 21:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<HTML>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<body>
<input style="width: 100px; margin-left: 2px; " type="text" id="name" name="name">
<input style="width: 500px; height: 500px ; margin-left: 2px;" type="text" id="message" name="message">
<input type="button" onclick="callServlet()" value="Calc">

</body>
<script>
    function callServlet() {
        var input1 = document.getElementById('name').value;
        var input2 = document.getElementById('message').value;
        var myData = {"Dish": {"name": input1, "recipe": [input2]}};
        $.ajax({
            type: "PUT",
            url: ".",
            data: "papaya",
            success: function(data){
                window.alert(data);
            }
        });
    }
</script>
</HTML>
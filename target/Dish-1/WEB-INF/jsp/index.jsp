<%--
  Created by IntelliJ IDEA.
  User: cotletkaman
  Date: 16.02.16
  Time: 21:08
  To change this template use File | Settings | File Templates.
--%>
<HTML>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<body>
<input style="width: 100px; margin-left: 2px; " type="text" id="name" name="name">
<br>
<input style="width: 100px; height: 500px ; margin-left: 2px;" type="text" id="message" name="message">
<br>
<input type="button" onclick="callServlet()" value="Calc">

</body>
<script>
    function callServlet() {
        var input1 = document.getElementById('name').value;
        var input2 = document.getElementById('message').value;
        var myData = {"name": input1, "recipe": [input2]};
        var jsonData = JSON.stringify(myData);
        $.ajax({
            url: "http://localhost:8080/Dish-1/dishes/AddNew",
            type: "POST",
            contentType: "application/json",
            data: jsonData
        });
    }
</script>
</HTML>
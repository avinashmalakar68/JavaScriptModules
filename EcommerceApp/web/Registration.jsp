
<html>
    <script>
        var request;
        function one() {
            var v1=document.getElementById("email").value;
            request = new XMLHttpRequest();
            request.onreadystatechange = two;
            request.open("get", "check.jsp?id"+v1, true);
            request.send(null);
        }
        function two() {
            if (request.status == 200 && request.readyState == 4)
                document.getElementById("data").innerHTML = request.responseText;
        }
    </script>
    
    <body>
        <h1>E-Commerce Application</h1>
        <hr>
        <h2>Registration Form</h2>
        <hr>
        <form action="SaveUserData" method="post">
        <table>
            
            <tr>
                <td>Email</td><td><input type="text" id="email" name="email"/></td><td> <input type="button" value="Chk-Avlb" onclick="one()" /></td><td><div id="data">Result</div></td>
            </tr>
            <tr>
                <td>Password</td><td><input type="password" name="password"</td>
            </tr>
            <tr>
                <td>Name</td><td><input type="text" name="name"/></td>
            </tr>
             <tr>
                <td>Addess</td><td><input type="text" name="adress"/></td>
            </tr>
             <tr>
                <td>Mobile</td><td><input type="text" name="mobile"/></td>
            </tr>
            <tr>
                <td><input type="submit" value="Register"</td><td><input type="reset" value="Reset"</td>
            </tr>
        </table>  
       </form>
        <hr>
        <a href="index.jsp">Login</a>
    </body>
</html>

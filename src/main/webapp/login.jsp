<%@ page import="com.example.DB.User" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: nurga
  Date: 12.03.2023
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Log in Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
    <%%>
</head>
<body>
<%
    //ArrayList<User> user =(ArrayList<User>) request.getAttribute("user");

%>

<div class="container">
    <div class="row mt-5">
        <div class="col-sm-6 offset-3">
            <h1 class="text-center my-4">LOG IN</h1>
            <form action="login" method="post">
                <div class="form-group">
                    <label for="inputEmail">Email address</label>
                    <input type="text" class="form-control" id="inputEmail" placeholder="Enter email" name="email">
                </div>
                <div class="form-group">
                    <label for="inputPassword">Password</label>
                    <input type="password" class="form-control" id="inputPassword" placeholder="Enter password" name="password">
                </div>
                <div class="form-group">
                    <button class="btn btn-primary btn-block">Login</button>
                    <a class="btn btn-primary btn-block" href="signup">SignUp</a>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>

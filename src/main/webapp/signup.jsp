<%@ page import="java.util.logging.Handler" %>
<%@ page import="java.io.IOException" %>
<%@ page import="java.util.TimerTask" %>
<%@ page import="java.util.Timer" %><%--
  Created by IntelliJ IDEA.
  User: nurga
  Date: 12.03.2023
  Time: 16:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
    <%%>
</head>
<div class="container">
    <div class="row mt-5">
        <div class="col-sm-6 offset-3">
            <%
                String success = request.getParameter("success");
                if (success!=null){
            %>
            <div class="alert alert-success alert-dismissible fade show" role="alert">
                Accaunt has been successfully created
            </div>

            <%
                }

            %>
            <h1 class="text-center my-4">Sign Up</h1>
            <form action="signup" method="post">
                <div class="form-group">
                    <label for="firstName">Full Name</label>
                    <input type="text" class="form-control" id="firstName" placeholder="Enter full name" name="full_name">
                </div>
                <div class="form-group">
                    <label for="email">Email address</label>
                    <input type="text" class="form-control" id="email" placeholder="Enter email" name="email">
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" class="form-control" id="password" placeholder="Password" name="password">
                </div>
                <div class="form-group">
                    <label for="confirmPassword">Confirm Password</label>
                    <input type="password" class="form-control" id="confirmPassword" placeholder="Confirm Password" name="cpass">
                </div>
                <div class="form-group">
                    <label for="firstName">Birth Date</label>
                    <input type="date" class="form-control"  placeholder="Enter birth date" name="birth_date">
                </div>
                <button class="btn btn-primary">Submit</button>
                <a class="btn btn-primary btn-block" href="login.jsp">Return</a>
            </form>
        </div>
    </div>
</div>
<body>

</body>
</html>

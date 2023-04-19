<%@ page import="com.example.DB.User" %>
<%@ page import="com.example.DB.DBManager" %><%--
  Created by IntelliJ IDEA.
  User: nurga
  Date: 12.03.2023
  Time: 18:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%
        Long id = Long.valueOf(request.getParameter("id"));
        User user = DBManager.getUser(id);
        System.out.println(id);
    %>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
    <%%>
</head>
<body>
<nav class="navbar bg-primary justify-content-center">
    <ul class="nav">
        <li class="nav-item">
            <a class="nav-link" style="color: #0c0000" href="login?id=<%=id%>">Home</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" style="color: #0c0000" href="setting?id=<%=id%>">Setting</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" style="color: #0c0000" href="home">Exit</a>
        </li>
    </ul>
</nav>

<div class="container">
    <div class="row mt-5">
        <div class="col-sm-6 offset-3">
            <h1 class="text-center my-4">Setting</h1>
            <form action="setting" method="post">
                <div class="form-group">
                    <label for="inputEmail">Picture URL</label>
                    <input type="text" class="form-control" id="inputEmail" placeholder="Enter email" name="picture">
                </div>
                <input type="hidden" name="id" value="<%=id%>">
                <div class="form-group">
                    <button class="btn btn-primary btn-block">CHANGE</button>
                    <a class="btn btn-primary btn-block" href="login?id=<%=id%>">RETURN</a>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>

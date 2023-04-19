<%@ page import="com.example.DB.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.DB.Post" %><%--
  Created by IntelliJ IDEA.
  User: nurga
  Date: 12.03.2023
  Time: 13:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%
        User user =(User) request.getAttribute("user");
        ArrayList<Post> posts = (ArrayList<Post>) request.getAttribute("posts");
    %>
    <title><%=user.getFull_name()%></title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
    <%%>

</head>
<body>

<%
    String url;
    String name;
    if (user.getPicture_url() == null || user.getPicture_url().equals("")) url = "./img/avatar.jpg";
    else url = user.getPicture_url();

%>
    <nav class="navbar bg-primary justify-content-center">
        <ul class="nav">
            <li class="nav-item">
                <a class="nav-link activate" style="color: #0c0000" href="#">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" style="color: #0c0000" href="setting?id=<%=user.getId()%>">Setting</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" style="color: #0c0000" href="home">Exit</a>
            </li>
        </ul>
    </nav>
    <main style="display: flex">
        <div style="border-right: solid black 1px; width: 500px; ">
            <img src="<%=url%>" style="width: 250px; height: 250px; margin: 30px; margin-left: 100px" class="img-thumbnail" alt="avatar">
            <h2 style="margin-left: 100px"><%=user.getFull_name()%> </h2>
            <h3 style="margin-left: 100px"><%=user.getBirth_date()%></h3>
        </div>
        <div style="margin: 10px">
            <div style="margin: 10px; padding: 10px; border: solid black 1px; border-radius: 10px; width: 900px">
                <form action="post" method="post">
                    <label style="margin-left: 10px; margin-top: 5px; font-weight: bold;">TITLE:</label>
                    <input style="margin-top: 5px" type="text" class="form-control"  placeholder="Enter title" name="title">
                    <label style="margin-left: 10px; margin-top: 5px; font-weight: bold;">CONTENT:</label>
                    <textarea name="content" rows="4" cols="116" placeholder="Enter content">

                    </textarea>
                    <input style="margin-top: 5px" type="hidden" name="id" value="<%=user.getId()%>">
                    <button class="btn btn-primary btn-block"  style="margin: 10px; margin-left: 700px">POSTED</button>
                </form>
            </div>
            <h2 style="margin: 10px; text-align: center">Posts:</h2>
            <%
                for (Post p: posts){
                    if (user.getFull_name().equals(p.getAuthor_name())){
                        name = p.getAuthor_name() + " (you)";
                    } else name = p.getAuthor_name();
            %>
                <div style="margin: 20px; padding: 10px; border: solid black 1px; border-radius: 10px; width: 900px">
                    <h3><%=p.getTitle()%></h3>
                    <p><%=p.getContent()%></p>
                    <p style="text-align: end; margin: -5px; margin-right: 10px">Posted: <%=name%></p>
                    <p style="text-align: end; margin: -5px; margin-right: 10px">Posted date: <%=p.getPost_date()%></p>

                </div>
            <%
                }
            %>
        </div>
    </main>
</body>
</html>

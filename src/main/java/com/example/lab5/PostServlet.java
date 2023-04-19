package com.example.lab5;

import com.example.DB.DBManager;
import com.example.DB.Post;
import com.example.DB.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

@WebServlet("/post")
public class PostServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DBManager.connect();
        Long id = Long.valueOf(request.getParameter("id"));
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String formattedDate = currentDate.format(formatter);
        System.out.println(formattedDate);
        Post post = new Post(id, title, content, formattedDate);
        DBManager.addPost(post);

        response.sendRedirect("login?id=" + id);
    }
}

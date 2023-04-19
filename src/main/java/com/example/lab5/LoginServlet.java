package com.example.lab5;

import com.example.DB.DBManager;
import com.example.DB.Post;
import com.example.DB.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.valueOf(request.getParameter("id"));
        User user = DBManager.getUser(id);
        ArrayList<Post> posts = DBManager.getAllPosts();
        request.setAttribute("user", user);
        request.setAttribute("posts", posts);
        request.getRequestDispatcher("/profile.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DBManager.connect();
        ArrayList<User> user = DBManager.getAllUsers();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        boolean check = true;

        for (User u : user) {
            if (u.getEmail().replaceAll("\\s", "").equals(email)){
                if (u.getPassword().replaceAll("\\s", "").equals(password)){
                    ArrayList<Post> posts = DBManager.getAllPosts();
                    request.setAttribute("user", u);
                    request.setAttribute("posts", posts);
                    check = false;
                    request.getRequestDispatcher("/profile.jsp").forward(request, response);
                }
            }
        }
        if (check){
            response.sendRedirect("home");

        }

//        if (user.contains(email)){
//            int index = user.indexOf(email);
//            if (user.get(index).getPassword().equals(password)){
//                request.getRequestDispatcher("/profile.jsp").forward(request, response);
//                System.out.println(1);
//            }
//            else {
//                response.sendRedirect("home");
//                System.out.println(2);
//            }
//        }
    }
}

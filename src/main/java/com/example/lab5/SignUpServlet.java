package com.example.lab5;

import com.example.DB.DBManager;
import com.example.DB.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/signup")
public class SignUpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/signup.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        DBManager.connect();
        String full_name = request.getParameter("full_name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String cpassword = request.getParameter("cpass");
        String birth_date = request.getParameter("birth_date");
        User user = new User(email, password, full_name, birth_date);
        if (password.equals(cpassword)){
            DBManager.addUser(user);
            response.sendRedirect("/Lab5_war_exploded/signup?success");
        }else response.sendRedirect("/Lab5_war_exploded/signup");
    }
}

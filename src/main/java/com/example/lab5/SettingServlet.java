package com.example.lab5;

import com.example.DB.DBManager;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/setting")
public class SettingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(1);
        request.getRequestDispatcher("/setting.jsp").forward(request, response);
        //response.sendRedirect("/setting.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DBManager.connect();
        System.out.println(45454);
        Long id = Long.valueOf(request.getParameter("id"));
        String picture_url = request.getParameter("picture").replaceAll("\\s", "");
        DBManager.updatePicture(picture_url, id);
        response.sendRedirect("login?id=" + id);
    }
}

package com.example.oopcoursework;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "DeleteEventServlet", value = "/delete_event")
public class DeleteEventServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");

        Utils.execubeDB("DELETE FROM events WHERE name = '" + name + "'");

        response.sendRedirect("index.jsp");
    }
}

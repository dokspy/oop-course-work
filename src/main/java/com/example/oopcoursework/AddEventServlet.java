package com.example.oopcoursework;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "AddEventServlet", value = "/add_event")
public class AddEventServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String place = request.getParameter("place");
        String type = request.getParameter("type");

        Utils.execubeDB("INSERT INTO events (name, place, type) VALUES ('" + name + "','" + place + "','" + type + "')");

        response.sendRedirect("index.jsp");
    }
}

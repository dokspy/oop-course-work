package com.example.oopcoursework;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "ChangeEventServlet", value = "/change_event")
public class ChangeEventServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");

        request.setAttribute("event_name", name);

        RequestDispatcher rd = request.getRequestDispatcher("change_event.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String oldName = request.getParameter("old_name");
        String newName = request.getParameter("new_name");
        String place = request.getParameter("place");
        String type = request.getParameter("type");

        Utils.execubeDB("UPDATE events SET name = '" + newName + "', place = '" + place + "', type ='" + type
                + "' WHERE name ='" + oldName + "'");

        response.sendRedirect("index.jsp");
    }
}

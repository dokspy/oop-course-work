package com.example.oopcoursework;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "event_list", urlPatterns = {"/event_list"})
public class EventsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> arr = new ArrayList<>();
        ResultSet rs = Utils.executeDBQuery("SELECT name FROM events");

        try {
            while (rs.next())
                arr.add(rs.getString("name"));
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("events", arr);

        RequestDispatcher rd = request.getRequestDispatcher("event_list.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

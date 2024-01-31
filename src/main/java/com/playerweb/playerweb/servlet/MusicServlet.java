package com.playerweb.playerweb.servlet;

import java.io.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.playerweb.playerweb.model.MySQLController;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/music")
public class MusicServlet extends HttpServlet {
    private final MySQLController mySQLController = new MySQLController();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/json");

        System.out.println(new ObjectMapper().writeValueAsString(mySQLController.getMusics()));
        response.getWriter().write(new ObjectMapper().writeValueAsString(mySQLController.getMusics()));
    }
}
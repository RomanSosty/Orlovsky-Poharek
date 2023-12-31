package org.example.jat.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.jat.User;

import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/loginPage")
public class LoginPageServlet extends HttpServlet {
    private User user;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("login.jsp");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        BufferedReader reader = request.getReader();
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
        }

        ObjectMapper objectMapper = new ObjectMapper();
        user = objectMapper.readValue(stringBuilder.toString(), User.class);


        String login = user.getLogin();
        String password = user.getPassword();

        System.out.println("Uživatel: " + login + " Heslo: " + password);

        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type");
        response.setContentType("application/json");
        response.sendRedirect("login.jsp");
    }
}

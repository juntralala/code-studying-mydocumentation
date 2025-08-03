package com.juntralala;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@WebServlet(urlPatterns = {"nyoba-session"})
public class NgetesSession extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(true);

        session.setAttribute("name", "ujun");
        String name = (String) session.getAttribute("name");

        Files.copy(request.getInputStream(), Path.of("target/data").toAbsolutePath());
    }

}

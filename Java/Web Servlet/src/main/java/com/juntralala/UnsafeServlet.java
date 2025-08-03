package com.juntralala;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/unsafe")
public class UnsafeServlet extends HttpServlet {

    // <- Object dari UnsafeServlet itu singgleton, jadi data response bisa terbawa antar request selanjutnya
    private String response = "";

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        response = "Hello " + req.getParameter("name");

        try {
            Thread.sleep(Long.parseLong(req.getParameter("sleep")));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        res.getWriter().println(response);
    }


}

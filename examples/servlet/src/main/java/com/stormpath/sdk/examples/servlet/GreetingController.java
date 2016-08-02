package com.stormpath.sdk.examples.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicLong;

@WebServlet("/greeting")
public class GreetingController extends HttpServlet {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        ObjectMapper om = new ObjectMapper();
        String name = request.getParameter("name");
        Greeting greeting = new Greeting(counter.incrementAndGet(), String.format(template, name));
        out.print(om.writeValueAsString(greeting));
        out.flush();
    }
}

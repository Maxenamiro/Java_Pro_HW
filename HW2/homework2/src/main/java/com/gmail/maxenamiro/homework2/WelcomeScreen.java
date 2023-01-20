package com.gmail.maxenamiro.homework2;

import java.io.*;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "result" ,value = "/res")
public class WelcomeScreen extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String first = request.getParameter("java1");
        String second = request.getParameter("python2");
        String third = request.getParameter("C");

        ArrayList<String> list = new ArrayList<>();
        list.add(first);
        list.add(second);
        list.add(third);
        //System.out.println(list);
        request.setAttribute("answers", list);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/result.jsp");
        dispatcher.forward(request,response);
    }
}
package com.hillel.web.hw19;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/number")
public class ServletNumber extends HttpServlet{
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<String> list = new ArrayList<>();
        String requestNumbers = request.getParameter("numbers");

        if (requestNumbers != null) {
            list = Arrays.stream(requestNumbers.split(","))
                    .sorted()
                    .collect(Collectors.toList());
        }

        response.setContentType("text/html;charset=utf-8");
        PrintWriter pw = response.getWriter();
        pw.println(list);
        pw.close();
    }
}

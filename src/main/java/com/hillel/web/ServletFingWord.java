package com.hillel.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

@WebServlet("/world")
public class ServletFingWord extends HttpServlet{

    private Text textUtils = new Text();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int count = 0;
        String requestWord = request.getParameter("word");

        if (requestWord != null) {
            List<String> words = textUtils.splitTextToWords(textUtils.text);
            Map<String, Integer> repetitions = textUtils.toMap(words);
            count = repetitions.getOrDefault(requestWord, 0);
        }

        response.setContentType("text/html;charset=utf-8");
        PrintWriter pw = response.getWriter();
        pw.println(requestWord + "=" + count);
        pw.close();
    }
}

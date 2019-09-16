package com.hillel.web.homeLibrary.servlet;

import com.hillel.web.homeLibrary.db.WorkDB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteFilm")
public class DeleteFilm extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/jsp/deleteFilm.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        WorkDB dbWorker = new WorkDB();
        int yearToDelete = Integer.parseInt(request.getParameter("yearToDelete"));
        int count = dbWorker.deleteFilm(yearToDelete);
        request.setAttribute("count", count);
        request.getRequestDispatcher("/jsp/deleteFilm.jsp").forward(request, response);
    }

}

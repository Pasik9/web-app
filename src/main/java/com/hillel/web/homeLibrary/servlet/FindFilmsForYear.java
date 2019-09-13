package com.hillel.web.homeLibrary.servlet;

import com.hillel.web.homeLibrary.db.WorkDB;
import com.hillel.web.homeLibrary.film.Film;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/findFilmsForYear")
public class FindFilmsForYear extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/jsp/findFilmsForYear.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        WorkDB dbWork = new WorkDB();
        int y1 = 0;
        int y2 = 0;
        List<Film> filmList = dbWork.findFilmsForYear(y1, y2);
        request.setAttribute("filmList", filmList);
        request.getRequestDispatcher("/jsp/findFilmsForYear.jsp").forward(request, response);
    }
}

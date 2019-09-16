package com.hillel.web.homeLibrary.servlet;

import com.hillel.web.homeLibrary.db.WorkDB;
import com.hillel.web.homeLibrary.staff.Actor;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/findActorForFilm")
public class FindActorForFilm extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/jsp/findActorForFilm.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        WorkDB dbWorker = new WorkDB();
        String filmName = request.getParameter("filmName");
        List<Actor> actorList = dbWorker.findActorForFilm(filmName);
        request.setAttribute("actorList", actorList);
        request.getRequestDispatcher("/jsp/findActorForFilm.jsp").forward(request, response);
    }

}

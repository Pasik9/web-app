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

@WebServlet("/findActorsAsDirector")
public class FindActorAsDirector extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/jsp/findActorAsDirector.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        WorkDB dbWorker = new WorkDB();
        List<Actor> actorList = dbWorker.findActorAsDirector();
        request.setAttribute("actorList", actorList);
        request.getRequestDispatcher("/jsp/findActorAsDirector.jsp").forward(request, response);
    }

}

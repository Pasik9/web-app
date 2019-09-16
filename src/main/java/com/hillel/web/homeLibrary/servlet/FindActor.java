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

@WebServlet("/findActors")
public class FindActor extends HttpServlet {

    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/jsp/findActor.jsp").forward(request,response);
    }


    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

        WorkDB dbWorker = new WorkDB();
        int count = Integer.parseInt(request.getParameter("count"));
        List<Actor> actorList = dbWorker.findAcror(count);
        request.setAttribute("actorList",actorList);
        request.getRequestDispatcher("/jsp/findActor.jsp").forward(request,response);
    }

}

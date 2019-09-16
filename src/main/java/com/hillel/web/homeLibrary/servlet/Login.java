package com.hillel.web.homeLibrary.servlet;

import com.hillel.web.homeLibrary.db.LoginServce;
import com.hillel.web.homeLibrary.staff.User;;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/Login")
public class Login extends HttpServlet {

    private LoginServce loginService;

    public Login() {
        loginService = new LoginServce();
    }


    public LoginServce getLoginService() {
        return loginService;
    }



    public void setLoginService(Login LoginServce) {
        this.loginService = loginService;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String valid = request.getParameter("valid");

        User user = getLoginService().login(username, password);

        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            response.sendRedirect("/");
        } else {
            request.setAttribute("loginError", "not existing user");
            request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
        }
    }

}
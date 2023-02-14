package com.bull.controllers;

import com.bull.models.Bhuser;
import com.bull.services.DBUser;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author gilles
 *
 * @Override protected void doGet(HttpServletRequest request,
 * HttpServletResponse response) throws ServletException, IOException {
 *
 * }
 */
@WebServlet(name = "login", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String useremail = request.getParameter("email");
        String password = request.getParameter("password");
        String action = request.getParameter("action");
        //String remember = request.getParameter("remember");
        String nextURL = "error.jsp";
        HttpSession session = request.getSession();

        if (action.equals("logout")) {
            session.invalidate();
            nextURL = "/WEB-INF/login.jsp";
        } else {
            if (DBUser.isValidUser(useremail, password)) {
                Bhuser user = DBUser.getUserByEmail(useremail);
                session.setAttribute("user", user);
                int gravatarImageWidth = 30;
             //   String gravatarURL = DBUser.getGravatarURL(useremail, gravatarImageWidth);
               // session.setAttribute("gravatarURL", gravatarURL);
                nextURL = "WEB-INF/home.jsp";
            } else {
                nextURL = "/WEB-INF/login.jsp";
            }
        }
        this.getServletContext().getRequestDispatcher(nextURL).forward(request, response);

    }

}

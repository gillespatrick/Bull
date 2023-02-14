package com.bull.controllers;

import com.bull.models.Bhpost;
import com.bull.services.DBPost;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author gilles
 */
@WebServlet(name = "newfeed", urlPatterns = {"/newfeed"})
public class NewFeed extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        long filterByUserID = 0;
        String searchtext = "";
        String nextURL = "error.jsp";

        HttpSession session = request.getSession();

        if (session.getAttribute("user") == null) {
            nextURL = "WEB-INF/login.jsp";
            session.invalidate();
            response.sendRedirect(request.getContextPath() + nextURL);
            return;
        }

        List<Bhpost> posts = null;
        if (request.getParameter("userid") != null && !request.getParameter("userid").isEmpty()) {
            filterByUserID = Integer.parseInt(request.getParameter("userid"));
            posts = DBPost.postsOfUser(filterByUserID);
        } else if (request.getParameter("searchtext") != null && !request.getParameter("searchtext").isEmpty()) {
            searchtext = request.toString();
            posts = DBPost.searchPosts(searchtext);
        } else {
            posts = DBPost.bhPost();
        }

        request.setAttribute("post", posts);
        nextURL = "WEB-INF/newfeed.jsp";
        this.getServletContext().getRequestDispatcher(nextURL).forward(request, response);

    }

}

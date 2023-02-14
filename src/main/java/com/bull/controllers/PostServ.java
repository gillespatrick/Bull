
package com.bull.controllers;

import com.bull.models.Bhpost;
import com.bull.models.Bhuser;
import com.bull.services.DBPost;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
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
@WebServlet(name = "postserv", urlPatterns = {"/postserv"})
public class PostServ extends HttpServlet {


    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String posttext = request.getParameter("posttext");
        String nextURL = "/error.jsp";
        
        HttpSession session = request.getSession();
        
        if (session.getAttribute("user") == null) {
            nextURL = "WEB-INF/login.jsp";
            session.invalidate();
        } else {
            Bhuser bhuser = (Bhuser)session.getAttribute("user");
            
            //insert post
            Bhpost bhpost = new Bhpost();
            bhpost.setBhuserid(bhuser);
            Date postdate = Calendar.getInstance().getTime();
            bhpost.setPostdate(postdate);
            bhpost.setPosttext(posttext);
            DBPost.insert(bhpost);
            
            nextURL = "/newfeed";
        }
        
        this.getServletContext().getRequestDispatcher(nextURL).forward(request, response);
    
    }

}


package com.bull.controllers;

import com.bull.models.Bhuser;
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
 */
@WebServlet(name = "profile", urlPatterns = {"/profile"})
public class ProfileServlet extends HttpServlet {

  

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
/*
  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        String nextURL = "error.jsp";
        long userid = 0;
        String action = "";
        Bhuser profileUser = null;
        Bhuser loggedInUser = null;
        
        
        if (session.getAttribute("user") == null) {
            nextURL = "WEB-INF/login.jsp";
            session.invalidate();
            response.sendRedirect(request.getContextPath() + nextURL);
            return;
        }
        try {
            userid = Long.parseLong(request.getParameter("userid"));
            action = request.getParameter("action");
            
            if (action = updateprofile)
                    if
        } catch (Exception e) {
        }
       
    }

    
*/
}
 
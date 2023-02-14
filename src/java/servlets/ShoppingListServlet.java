package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Karsten Monteiro
 */
public class ShoppingListServlet extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("username");
        
        /**
         * Handle Logout
         */
        // the value of the 'action' param will never be null if a user is logged in
        if (request.getParameter("action") != null) {
            // invalidate session
            session.invalidate();
            
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            return;
        }
        
        /**
         * Handle Authentication
         */
        // forward any unauthenticated users to 'register.jsp'
        if (username == null) {
            
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            return;
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        /**
         * ACTIONS
         */
        String action = request.getParameter("action");
        
        // register
        if (action.equals("register")) {
            
        }
        // add
        if (action.equals("add")) {
            
        }
        // delete
        if (action.equals("delete")) {
            
        }
        
        // forward the user to 'shoppingList.jsp'
        getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
    }

}
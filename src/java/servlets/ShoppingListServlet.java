package servlets;

import java.io.IOException;
import java.util.ArrayList;
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
        
        /** register */
        if (action.equals("register")) {
            String username = request.getParameter("username");
            
            // verify that the value of 'username' is not empty
            if (username.equals("")) {
                session.setAttribute("errorMsg", "<br>Invalid username. Please try again.");
                
                getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
                return;
            }
            session.setAttribute("username", username);

            // initialize an ArrayList that will store all the items
            ArrayList<String> itemsList = new ArrayList<String>();
            session.setAttribute("itemsList", itemsList);
        }
        
        /** add */
        if (action.equals("add")) {
            ArrayList<String> itemsList = (ArrayList<String>)session.getAttribute("itemsList");
            String item = request.getParameter("item");
            
            // verify input is not empty, then add to list
            if (!(item.equals(""))) {
                itemsList.add(item);
                session.setAttribute("itemsList", itemsList);
            }
        }
        
        /** delete */
        if (action.equals("delete")) {
            ArrayList<String> itemsList = (ArrayList<String>)session.getAttribute("itemsList");
            String item = request.getParameter("item");
            
            // remove item from list, then update list
            itemsList.remove(item);
            session.setAttribute("itemsList", itemsList);
        }
        
        // forward the user to 'shoppingList.jsp'
        getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
    }

}
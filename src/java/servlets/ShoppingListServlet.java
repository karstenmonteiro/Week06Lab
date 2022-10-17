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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        
        // handle logout
        if (request.getParameter("action") != null){
            session.invalidate();
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            
            return;
        }
       
        // forward any unauthenticated users to 'register.jsp'
        if (username == null) {
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            
            return;
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/shoppinglist.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        
        /** 
         * actions 
         */
        String action = request.getParameter("action");
        
        // register
        if (action.equals("register")) {
            String username = request.getParameter("username");
            session.setAttribute("username", username);
            
            ArrayList<String> itemsList = new ArrayList<String>();
            session.setAttribute("itemsList", itemsList);
        }
        
        // add
        if (action.equals("add")) {
            ArrayList<String> itemsList = (ArrayList<String>) session.getAttribute("itemsList");
            String item = request.getParameter("item");
            
            if (!(item.equals(""))) {
                itemsList.add(item);
                session.setAttribute("itemsList", itemsList);
            }
        }
        
        // delete
        if (action.equals("delete")) {
            ArrayList<String> itemsList = (ArrayList<String>) session.getAttribute("itemsList");
            String item = request.getParameter("item");
            
            itemsList.remove(item);
            session.setAttribute("itemsList", itemsList);
        }

        getServletContext().getRequestDispatcher("/WEB-INF/shoppinglist.jsp").forward(request, response);
    }

}

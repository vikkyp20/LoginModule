package login;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class LoginPage extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
           out.println("<!DOCTYPE html>");
           out.println("<html>"); out.println("<head>"); out.println("<title>Servlet LoginPage</title>");
           out.println("</head>"); out.println("<body><center>");
           out.println("<h1>Login Panel</hl>"
           + "<form action='LoginValidate'><table width=400 height=300 bgcolor=dodgerblue>"
           + "<tr style.'color:white;font-size:16px;'><td>User Type</td><td>"
           + "<select name=utype><option>Select User Type<option>"
           + "<option value=Admin>Admin</option> <option value=Member>Member</option></select></td></tr>" 
           + "<tr style='color:white;font-size:16px;'><td>User Name</td>"
           + "<td><input type=text name=user> </td> </tr>"
           + "<tr style='color:white;font-size:16px;'><td>Password</td>"
           + "<td><input type=password name=pswd></td></tr>");
           if (request.getParameter("error")!=null)
          out.println("<tr><td colspan=2><h3 style='color:red;'>"+request.getParameter("error")+"</h3></td></tr>");
          out.println("<tr><td><input type=submit value=submit></td><td><input type=reset value=Reset></td> "
              + "</table></form>");
          out.println("</body>");
          out.println("</html>");



        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}


package jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Registration1 extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
          
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Employee Registration</title>");            
            out.println("</head>");
            out.println("<body><center>");
            out.println("<h1>Employee Registration</h1>"
                    +"<form action=Reconfig1 method=get>"
                    + "<table width=400 height=400 bgcolor=lightgrey>"
                    + "<tr><td>EmployeeCode</td><td><input type=number name=code></td></tr>"
                    + "<tr><td>EmployeeName</td><td><input type=text name=name></td></tr>"
                    + "<tr><td>EmployeePost</td><td><input type=text name=post></td></tr>"
                    + "<tr><td>EmployeeSalary</td><td><input type=text name=sal></td></tr>"
                    + "<tr><td>EmployeeAddress</td><td><input type=text name=add></td></tr>"
                    + "<tr><td>EmployeeContact</td><td><input type=text name=cont></td></tr>"
                    + "<tr><td>EmployeeMail</td><td><input type=text name=mail></td></tr>"
                    + "<tr><td><input type=submit value=Submit></td><td>"
                    + "<input type=reset value=RESET></td></tr>"
                    + "</table>"
                    + "</form>"
                    + "</center>");
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

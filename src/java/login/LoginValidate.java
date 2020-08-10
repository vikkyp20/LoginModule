
package login;

import DB.DBConnection;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginValidate extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String type=request.getParameter("utype"); 
            String user=request.getParameter("user"); 
            String pswd=request.getParameter("pswd");
            DBConnection db=new DBConnection();
           db.pstmt=db.con.prepareStatement("select ac_type from login where user=? and password=?");
           db.pstmt.setString(1,user);
           db.pstmt.setString(2,pswd);
           db.rst=db.pstmt.executeQuery(); 
           if(db.rst.next()){
             String db_type=db.rst.getString(1); 
               if(type.equals(db_type)){
                if(type.equals("Admin")){
                    
        HttpSession session=request.getSession(); 
        session.setAttribute("user",user);
                    response.sendRedirect("AdminHome");
                }
                else{
                    HttpSession session=request.getSession(); 
        session.setAttribute("user",user);
                 response.sendRedirect("MemberHome");}
               }
               else
               {
                   response.sendRedirect("LoginPage?error=Unauthorized Access");
               }
           }
           else{
                response.sendRedirect("LoginPage?error=Invalid User or Password");
           }
           
        }
        catch(Exception e){
            e.printStackTrace();
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

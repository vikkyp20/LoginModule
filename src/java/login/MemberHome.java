
package login;

import DB.DBConnection;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.catalina.util.SessionConfig;


public class MemberHome extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            HttpSession session=request.getSession();  
            
            if(session.getAttribute("user")!=null)
            {
                String uid=session.getAttribute("user").toString();
                System.out.println(uid);
               try{
                   DBConnection db=new DBConnection();
              db.pstmt=db.con.prepareStatement("select * from emp_info where ecode='"+uid+"'");
            db.rst=db.pstmt.executeQuery(); 
            while(db.rst.next()){
            out.println("<html>\n" +
"    <head>\n" +
"        <title>Regitration page</title>\n" +
"        <style>\n" +
"            .f{\n" +
"                 border: 2px solid ;\n" +
"                 border-radius: 5px;\n" +
"                 width: auto;\n" +
"                 height: 35px;\n" +
"                 margin-bottom: 0px;\n" +
"            }\n" +
"            .f1{\n" +
"                 border: 2px solid ;\n" +
"                 border-radius: 5px;\n" +
"                 width: 350px;\n" +
"                 height: 35px;\n" +
"                  \" margin-bottom: 0px\n" +
"            }\n" +
"            .l{\n" +
"                padding-right: 40px;\n" +
"                padding-left: 20px;\n" +
"                 font-size: 22px;\n" +
"                  font-weight: 700;\n" +
"                  padding-bottom: 0px\n" +
"                  \n" +
"            }\n" +
"            \n" +
"            \n" +
"        </style>\n" +
"        \n" +
"    </head>\n" +
"    <body style='background-image: repeating-radial-gradient(white,green);'>\n" +
"        <center> <a href='logout' style='text-decoration:none;padding:10px ;background-color:red'>Logout</a>\n" +
"            \n" +
"                <table style=' margin-top: 50px; padding-top: 30px; background-image: linear-gradient(green,blue, red);'>\n" +
"                    <tr>\n" +
"                        <td class='l'> Name :-</td>\n" +
"                        <td>"+db.rst.getString(2)+" </td>\n" +
"                \n" +
"                        <td class='l'>Post :-</td>\n" +
"                        <td>"+db.rst.getString(3)+"</td>\n" +
"                    </tr>\n" +
"                    <tr>\n" +
"                        <td colspan='2' class='l'>User Id :-</td>\n" +
"                        <td colspan='2'> "+db.rst.getString(1)+"</td>\n" +
"                \n" +
"                    </tr>\n" +
                   
"                    <tr>\n" +
"                        <td colspan='2' class='l'>Address :-</td>\n" +
"                        <td colspan='2'>"+db.rst.getString(5)+"</td>\n" +
"                \n" +
"                    </tr>\n" +
"                    <tr>\n" +
"                        <td colspan='2' class='l'>Contact :-</td>\n" +
"                        <td colspan='2'>"+db.rst.getString(6)+" </td>\n" +
"                \n" +
"                    </tr>\n" +
"                \n" +
"                    <tr>\n" +
"                        <td colspan='2' class='l'> Salary :-</td>\n" +
"                        <td colspan='2'>"+db.rst.getString(4)+"</td>\n" +
"                \n" +
"                    </tr>\n" +
"                    <tr>\n" +
"                        <td colspan='2' class='l'>E-mail :-</td>\n" +
"                        <td colspan='2'>"+db.rst.getString(7)+"</td>\n" +
"                \n" +
"                    </tr>\n"+
"                    \n" +
"                </table>\n" +
"        \n" +
"        </center>\n" +
"    </body>\n" +
"</html>");
            }
            }
               catch(Exception e){
                   e.printStackTrace();
               }
        }
            else{
                String err="Please Login !!";
                response.sendRedirect("loginpage?error="+err+"");
            }
        }
        catch(Exception e)
        {
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


package jdbc;

import DB.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateDelete extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
          String code=request.getParameter("code"); 
          String name=request.getParameter("name"); 
          String post=request.getParameter("post"); 
          String sal=request.getParameter("sal"); 
          String add=request.getParameter("add"); 
          String cont=request.getParameter("cont"); 
          String mail=request.getParameter("mail"); 
          String opr=request.getParameter("opr"); 
          
          DBConnection db=new DBConnection();
          db.stmt=db.con.createStatement();
          if(opr.equals("Update"))
          {
              db.pstmt=db.con.prepareStatement("update emp_info set ename=?,epost=?,"
                      + "esal=?,eadd=?,econt=?,email=? where ecode=?");
              db.pstmt.setString(2, name);
              db.pstmt.setString(3, post);
              db.pstmt.setString(4, sal);
              db.pstmt.setString(5, add);
              db.pstmt.setString(6, cont);
              db.pstmt.setString(7, mail);
              db.pstmt.setString(1, code);
              int i=db.pstmt.executeUpdate();
              if(i>0){
                  out.println("<h3>Record Updated Successfully</h3>");
              }
              else{
                  db.pstmt=db.con.prepareStatement("delete from emp_info where ecode=?");
                  db.pstmt.setString(1, code);
                  
                  i = db.pstmt.executeUpdate();
                  if(i>0)
                      out.println("<h3>Record Deleted<h3>");
                  else
                      out.println("<h3>Error in Deletion</h3>");
              }
          }
        }
        catch(Exception e){
            e.printStackTrace();
            
        }
    }

}


package jdbc;

import DB.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchRec extends HttpServlet {

    


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String code=request.getParameter("cd");
            DBConnection db=new DBConnection();
            db.stmt=db.con.createStatement();
            
            db.rst=db.stmt.executeQuery("select * from emp_info where code="+code+"");
            if(db.rst.next())
            {
             String name=db.rst.getString(2);
             String post=db.rst.getString(3);
             String sal=db.rst.getString(4);
             String add=db.rst.getString(5);
             String cont=db.rst.getString(6);
             String mail=db.rst.getString(7);
             out.println("<html>");
             out.println("<head><title>EmployeeDetails</title>");
             out.println("</head>");
             out.println("<body><center>");
             out.println("<h1>Employee Details<h1>"
                     + "<form action=UpdateDelete method=get>"
                     + "<table width=400  bgcolor=pink>"
                     + "<tr><td>EmployeeCode</td><td><input type=number value="+code+""
                             + "name=code></td></tr>"
                             + "<tr><td>EmployeeName</td><td><input type=text value="+name+""
                             + "name=name></td></tr>"
                             + "<tr><td>EmployeePost</td><td><input type=text value="+post+""
                             + "name=post></td></tr>"
                             + "<tr><td>EmployeeSalary</td><td><input type=number value="+sal+""
                             + "name=salary></td></tr>"
                             + "<tr><td>EmployeeAddress</td><td><textarea value="+add+""
                             + "name=address>+add+</textarea></td></tr>"
                             + "<tr><td>EmployeeContact</td><td><input type=number value="+cont+""
                             + "name=contact></td></tr>"
                             + "<tr><td>EmployeeMail</td><td><input type=email value="+mail+""
                             + "name=mail></td></tr>"
                             + "<tr><td><input type=submit value=Update name=opr></td><td><input type=Submit value=Delete"
                             + "name=opr></td></tr>");
             out.println("</body>");
             out.println("</html>");
             
            }
            else{
                out.println("Employee Record does not match");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    

}

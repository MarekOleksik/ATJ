package atj;

import atj.IPasswordGenerator;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "UserRegistrationServlet", urlPatterns = { "/register" })
public class RegisterServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Inject
  private User user;
  
  @Inject @QWeakPasswordGenerator
  private IPasswordGenerator weakPasswordGenerator;

  @Inject @QStrongPasswordGenerator
  private IPasswordGenerator strongPasswordGenerator;

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
    response.setContentType("text/html;charset=UTF-8");

    user.setEmail(request.getParameter("email"));
    user.setRights(request.getParameter("rights"));
    user.setAccess(request.getParameterValues("access"));        
    user.generatePassword(user.getRights().equals("superuser")?
         strongPasswordGenerator:weakPasswordGenerator);

    RequestDispatcher rd = request.getRequestDispatcher("/wynik.jsp");
    rd.forward(request, response);
        
    PrintWriter out = response.getWriter();
    try {
      out.println("<html>");
      out.println("<head>");
      out.println("<title>New user confirmation</title>");        
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>New user has been registered.</h1>");
      out.println("<table>");
      out.println("<tr>");
      out.println("<td><label>E-mail: </label></td>");
      out.println("<td><b>" + user.getEmail() + "</b></td>");
      out.println("</tr>");
      out.println("<tr>");
      out.println("<td><label>Rights:</label></td>");
      out.println("<td><b>" + user.getRights() + "</b></td>");
      out.println("</tr>");
      out.println("<tr>");
      out.println("<td><label>Access :</label></td>");
      out.println("<td><b>");
      for(String access: user.getAccess())
          out.println(access + "<br>");
      out.println("</b></td>");
      out.println("</tr>");
      out.println("<tr>");
      out.println("<td><label>Password:</label></td>");
      out.println("<td><b>" + user.getPassword() + "</b></td>");
      out.println("</tr>");
      out.println("</table>");
      out.println("</body>");
      out.println("</html>");
      } finally {        
        out.close();
      }
   }
}
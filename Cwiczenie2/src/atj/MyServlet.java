package atj;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet(asyncSupported = true, description = "Mój serwlecik", urlPatterns = { "/MyServlet" })
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//PrintWriter printWriter = response.getWriter();
		//printWriter.println("<h1>Serwlet</h1>");
		String parameter1 = request.getParameter("param1");
		PrintWriter printWriter = response.getWriter();
		printWriter.println("<h1>" + parameter1 + " Serwlet</h1>");
		for (int i=1; i<5; i++){
			Cookie name = new Cookie("Name_"+i, ""+i);
				}
			
	}

}

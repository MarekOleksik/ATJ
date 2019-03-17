package atj;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet(asyncSupported = true, description = "Mój serwlecik", urlPatterns = { "/Admin" })
public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//PrintWriter printWriter = response.getWriter();
		//printWriter.println("<h1>Serwlet</h1>");
		//String parameter1 = request.getParameter("param1");
		//PrintWriter printWriter = response.getWriter();
		//printWriter.println("<h1>" + parameter1 + " Serwlet</h1>");
		String parameter1 = request.getParameter("server");
		PrintWriter printWriter = response.getWriter();
		printWriter.println("<h1>" + "My e-mail" + " @ " + parameter1 + "</h1>");
		// czytanie wszystkich parametrów inicjalizacji serwletu
		printWriter.println("<h1>" + "Init parameters are:" + "</h1>");
		Enumeration<String> e = getServletConfig().getInitParameterNames();
		while(e.hasMoreElements()) {
		String initParameter = e.nextElement();
		String value = getServletConfig().getInitParameter(initParameter);
		printWriter.println("<p>"+ initParameter + ": " + value + "</p>");
		ServletContext sc = getServletContext();
		sc.getAttributeNames();
	}

}
}

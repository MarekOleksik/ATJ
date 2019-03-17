package atj;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet(asyncSupported = true, description = "Mój serwlecik", urlPatterns = { "/Kalkulator" })
public class Kalkulator extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Double parameter1;
	Double parameter2;
	String operator;
	Double result = 0.0;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
		// PrintWriter printWriter = response.getWriter();
		// printWriter.println("<h1>Serwlet</h1>");
		parameter1 = Double.valueOf(request.getParameter("value1"));
		parameter2 = Double.valueOf(request.getParameter("value2"));
		operator = request.getParameter("oper");
		calc();
		request.setAttribute("result", result);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("kalkulator.jsp");
		requestDispatcher.forward(request, response);

	}

	public void calc() {
		switch (operator) {
		case "+":
			result = parameter1 + parameter2;
			break;
		case "-":
			result = parameter1 - parameter2;
			break;
		case "*":
			result = parameter1 * parameter2;
			break;
		case "/":
			if (parameter2 != 0)
				result = parameter1 / parameter2;
			else 
				result = 0.0;
			break;

		}

	}

}

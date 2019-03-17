package atj;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DegreeConverterServlet
 */
@WebServlet(description = "Konwerter temperatury", urlPatterns = { "/DegreeConverterServlet" })
public class DegreeConverterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Double parameter1;
	String deg;
	Double result = 0.0;
	String resultText;
	String resultText1;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		parameter1 = Double.valueOf(request.getParameter("value1"));
		deg = request.getParameter("deg");
		calc();
		request.setAttribute("resultText", resultText);
		request.setAttribute("resultText1", resultText1);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("wynik.jsp");
		requestDispatcher.forward(request, response);
	}
	public void calc() {
		switch (deg) {
		case "K":
			result = (parameter1 - 32) / 1.8;
			resultText = parameter1 + " Fahrenheita to: ";
			resultText1 = result + " Celcjusza";
			break;
		case "C":
			result = (parameter1 * 1.8) + 32;
			resultText = parameter1 + " Celcjusza to: ";
			resultText1 = result + " Fahrenheita";
			break;
		
		}

	}

}

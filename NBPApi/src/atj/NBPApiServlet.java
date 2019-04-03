package atj;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import atj.model.ExchangeRatesSeries;

@WebServlet(urlPatterns = { "/NBPApiServlet" })
public class NBPApiServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private String table;
	private String code;
	private int topCount;
	private double averageAsk;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		table = request.getParameter("tabela");
		code = request.getParameter("waluta");
		topCount = Integer.parseInt(request.getParameter("topCount"));

		String urlString = "http://api.nbp.pl/api/exchangerates/rates/" + table + "/" + code + "/last/" + topCount
				+ "/?format=xml";
		URL url = new URL(urlString);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		connection.setRequestProperty("Accept", "application/xml");
		connection.connect();
		InputStream xml = connection.getInputStream();
		JAXBContext jaxbContext = null;
		try {
			jaxbContext = JAXBContext.newInstance(ExchangeRatesSeries.class);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Unmarshaller jaxbUnmarshaller = null;
		try {
			jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ExchangeRatesSeries rates = null;
		try {
			rates = (ExchangeRatesSeries) jaxbUnmarshaller.unmarshal(xml);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		connection.disconnect();

		switch (table) {
		case "A":
			averageAsk = rates.getAverageAskAB(topCount);

			break;
		case "B":
			averageAsk = rates.getAverageAskAB(topCount);

			break;
			
		case "C":
			averageAsk = rates.getAverageAskC(topCount);

			break;
		default:
			break;
		}

		//if (table == A || table == B) {

		//	averageAsk = rates.getAverageAskAB(topCount);
		//}

		// else if (table == "C") {
		// averageAsk = rates.getAverageAskC(topCount);
		// }

		request.setAttribute("averageAsk", averageAsk);
		request.setAttribute("table", table);
		request.setAttribute("code", code);
		request.setAttribute("topCount", topCount);

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("view.jsp");
		requestDispatcher.forward(request, response);

	}

}

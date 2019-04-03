package atj;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import atj.model.ExchangeRatesSeries;

public class Test {

	public static void main(String[] args) throws JAXBException, IOException {
		// TODO Auto-generated method stub
		String table = "C";
		String code = "USD";
		int topCount = 2;

		ExchangeRatesSeries rates = unmarshaller(table, code, topCount);
		System.out.println(rates.getCode());
		System.out.println(rates.getCurrency());
		System.out.println(rates.getTable());
		System.out.println(rates.getRates());

		if (table == "A" || table == "B") {
			System.out.println("Średni kurs sprzedaży " + code + " z tabeli " + table + " z ostatnich " + topCount
					+ " notowań wynosi: " + rates.getAverageAskAB(topCount) + " PLN");

		} else if (table == "C") {
			System.out.println("Średni kurs sprzedaży " + code + " z tabeli " + table + " z ostatnich " + topCount
					+ " notowań wynosi: " + rates.getAverageAskC(topCount) + " PLN");
		}

	}

	private static ExchangeRatesSeries unmarshaller(String table, String code, int topCount)
			throws MalformedURLException, IOException, ProtocolException, JAXBException {
		String urlString = "http://api.nbp.pl/api/exchangerates/rates/" + table + "/" + code + "/last/" + topCount
				+ "/?format=xml";
		URL url = new URL(urlString);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		connection.setRequestProperty("Accept", "application/xml");
		connection.connect();
		InputStream xml = connection.getInputStream();
		JAXBContext jaxbContext = JAXBContext.newInstance(ExchangeRatesSeries.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		ExchangeRatesSeries rates = (ExchangeRatesSeries) jaxbUnmarshaller.unmarshal(xml);

		connection.disconnect();
		return rates;
	}
}

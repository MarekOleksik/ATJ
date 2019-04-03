package atj.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ExchangeRatesSeries")
@XmlAccessorType(XmlAccessType.FIELD)
public class ExchangeRatesSeries {

	@XmlElement(name = "Rates")
	private Rates rates;

	@XmlElement(name = "Table")
	private String table;

	@XmlElement(name = "Currency")
	private String currency;

	@XmlElement(name = "Code")
	private String code;

	private double size;

	public ExchangeRatesSeries() {

	}

	public ExchangeRatesSeries(Rates rates, String table, String currency, String code) {
		this.rates = rates;
		this.table = table;
		this.currency = currency;
		this.code = code;
	}

	public Rates getRates() {
		return rates;
	}

	public void setRates(Rates rates) {
		this.rates = rates;
	}

	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
	}

	public double getAverageAskC(double size) {
		this.size = size;
		// rates = rates.getRates();

		List<Rate> rate1 = rates.getRates();
		size = rate1.size();
		double averageAsk = Double.parseDouble(rate1.get(0).getAsk());

		for (int i = 1; i < size; i++) {
			double ask = Double.parseDouble(rate1.get(i).getAsk());
			averageAsk = averageAsk + ask;
		}
		double wynik = averageAsk / size;
		return wynik;
	}
	
	public double getAverageAskAB(double size) {
		this.size = size;
		// rates = rates.getRates();

		List<Rate> rate1 = rates.getRates();
		size = rate1.size();
		double averageAsk = Double.parseDouble(rate1.get(0).getMid());

		for (int i = 1; i < size; i++) {
			double ask = Double.parseDouble(rate1.get(i).getMid());
			averageAsk = averageAsk + ask;
		}
		
		double wynik = averageAsk / size;
		return wynik;
	}
	
	@Override
	public String toString() {
		return "ExchangeRatesSeries [rates=" + rates + ", table=" + table + ", currency=" + currency + ", code=" + code
				+ "]";
	}

}
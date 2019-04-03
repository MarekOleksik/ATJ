package atj.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Rates {

	@XmlElement(name = "Rate")
	private List<Rate> rates;

	public Rates() {

	}

	public Rates(List<Rate> rates) {
		this.rates = rates;
	}

	public List<Rate> getRates() {
		return rates;
	}

	public void setRates(List<Rate> rates) {
		this.rates = rates;
	}

	@Override
	public String toString() {
		return "Rates [rates=" + rates + "]";
	}

}
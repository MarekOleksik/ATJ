package atj.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Rate {

	@XmlElement(name = "No")
	private String no;

	@XmlElement(name = "Ask")
	private String ask;

	@XmlElement(name = "Bid")
	private String bid;

	@XmlElement(name = "EffectiveDate")
	private String effectiveDate;
	
	@XmlElement(name = "Mid")
	private String mid;

	public Rate() {

	}

	public Rate(String no, String ask, String bid, String effectiveDate) {
		this.no = no;
		this.ask = ask;
		this.bid = bid;
		this.effectiveDate = effectiveDate;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getAsk() {
		return ask;
	}

	public void setAsk(String ask) {
		this.ask = ask;
	}

	public String getBid() {
		return bid;
	}

	public void setBid(String bid) {
		this.bid = bid;
	}

	public String getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	
	
	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	@Override
	public String toString() {
		return "Rate [no=" + no + ", ask=" + ask + ", bid=" + bid + ", effectiveDate=" + effectiveDate + ", mid=" + mid
				+ "]";
	}

}
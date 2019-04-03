package atj.resource;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ProtocolException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBException;

import atj.model.ExchangeRatesSeries;
import atj.service.RatesService;

@Path("rates")
@Consumes(MediaType.APPLICATION_XML)
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.TEXT_HTML, MediaType.TEXT_PLAIN})
public class RatesResources {
	private RatesService rates = new RatesService();

	@GET
	@Consumes(MediaType.APPLICATION_XML)
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.TEXT_HTML, MediaType.TEXT_PLAIN})
	public String hello() {
		return "Hello Marek!";
	}

	@GET
	@Path("{table}/{code}/{topCount}")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.TEXT_HTML, MediaType.TEXT_PLAIN})
	public ExchangeRatesSeries getRates(@PathParam("table") String table, @PathParam("code") String code,
			@PathParam("topCount") int topCount)
			throws MalformedURLException, ProtocolException, IOException, JAXBException {
		return rates.unmarshaller(table, code, topCount);

	}

	@GET
	@Path("{table}/{code}/{topCount}/average")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public ExchangeRatesSeries getAverage(@PathParam("table") String table, @PathParam("code") String code,
			@PathParam("topCount") int topCount)
			throws MalformedURLException, ProtocolException, IOException, JAXBException {
		ExchangeRatesSeries average = new ExchangeRatesSeries();
		
		return rates.unmarshaller(table, code, topCount);

	}
	
}

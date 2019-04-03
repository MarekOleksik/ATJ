package atj;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class NBPClientApp {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Client client = ClientBuilder.newClient();
		URI uri = URI.create("http://localhost:8080/NBPApi/");
		WebTarget webTarget = client.target(uri);
		webTarget = webTarget.path("exchangerates").path("rates");
		String response = webTarget.request().accept(MediaType.TEXT_PLAIN).get(Response.class).toString();
		String plainAnswer = webTarget.request().accept(MediaType.TEXT_PLAIN).get(String.class);
		String xmlAnswer = webTarget.request().accept(MediaType.TEXT_XML).get(String.class);
		String htmlAnswer = webTarget.request().accept(MediaType.TEXT_HTML).get(String.class);

		System.out.println(response);
		System.out.println(plainAnswer);
		System.out.println(xmlAnswer);
		System.out.println(htmlAnswer);

		client.close();
	}

	public NBPClientApp() {

	}

}
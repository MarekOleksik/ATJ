package atj.rest;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

// klasa główna implementująca polecenia HTTP
// jest adnotowana @Path
// jest publiczna
// ma domyślny i publiczny konstruktor
@Path("hello")
public class Hello {
	@GET
	@Produces(javax.ws.rs.core.MediaType.TEXT_PLAIN)
	public String hello() {
		return "Hello bloody student!";
	}
}

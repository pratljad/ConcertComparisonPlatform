/**
 * 
 */
package app;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.Iterator;

import javax.ws.rs.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import dao.DAO_Concert;
import data.Concert;

/**
 * @author Joulian This is the webservice with all needed roots
 */
@Path("/consert")
public class ConsertWS {

	@Context
	UriInfo uriInfo;
	@Context
	Request request;

	// http://localhost:8080/Webservice/rest/consert/concerts
	/**
	 * This method is a route to get all concerts
	 * 
	 * @return res
	 */
	@GET
	@Path("/concerts")
	@Produces(MediaType.TEXT_PLAIN)
	public String getAllConcerts() {
		String res = "No concerts found";

		DAO_Concert daoConcert = DAO_Concert.getDaoConcert();
		Set<Concert> allConcerts;

		try {
			allConcerts = daoConcert.getAllConcerts();

			if (allConcerts.isEmpty() == false) {
				res = "[";
			}

			Iterator<Concert> itConcert = allConcerts.iterator();

			while (itConcert.hasNext()) {
				Concert concert = itConcert.next();
				if (concert != null) {
					res += concert.getJSON();
					res += "\n";
				}

				if (itConcert.hasNext()) {
					res += ",";
				}
			}

			if (allConcerts.isEmpty() == false) {
				res += "]";
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return res;
	}
	
	// http://localhost:8080/Webservice/rest/consert/concerts
		/**
		 * This method is a route to get all concerts
		 * 
		 * @return res
		 */
		@GET
		@Path("/concertsbyname/{myartistname}")
		@Produces(MediaType.TEXT_PLAIN)
		public String getAllConcertsByName(@PathParam("myartistname") String myartistname) {
			String res = "No concerts found";

			DAO_Concert daoConcert = DAO_Concert.getDaoConcert();
			Set<Concert> allConcerts;

			try {
				allConcerts = daoConcert.getConcertByName(myartistname);

				if (allConcerts.isEmpty() == false) {
					res = "[";
				}

				Iterator<Concert> itConcert = allConcerts.iterator();

				while (itConcert.hasNext()) {
					Concert concert = itConcert.next();
					if (concert != null) {
						res += concert.getJSON();
						res += "\n";
					}

					if (itConcert.hasNext()) {
						res += ",";
					}
				}

				if (allConcerts.isEmpty() == false) {
					res += "]";
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return res;
		}
}

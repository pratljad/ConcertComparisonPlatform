package app;

import data.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;
import javax.jws.WebMethod;
import javax.jws.WebService;


@WebService
public class App {
	private static final long serialVersionUID = 1L;
		
    private List<Concert> getConcerts() {
    	List<Concert> allConcerts= new ArrayList();  	
    	for(int i =0; i<10;i++) {
    		allConcerts.add(new Concert(i));
    	}
    	return allConcerts;
    }

    @Context
	  UriInfo uriInfo;
	  @Context
	  Request request;
	  //Application integration  
	  
	  @GET
	  @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	  public Concert getConcert() {
		  Concert p = new Concert(1);
		  //ToDo: get the right concert
	    if (p == null) throw new RuntimeException("Get: Concert with id=" + p.getConcertID() +  " not found");
	    return p;
	  }
	  
	  // For the browser
	  @GET
	  @Produces(MediaType.TEXT_XML)
	  public Concert getPersonHTML() {
		  Concert p = new Concert(1);
		//ToDo: get the right concert
	    if (p == null) throw new RuntimeException("Get: Concert with id=" +  p.getConcertID() +  " not found");
	    return p;
	  }
	  
	  @PUT
	  @Consumes(MediaType.APPLICATION_XML)
	  public Response putPerson(JAXBElement<Concert> person) {
	    // Person p = person.getValue();
	    return putAndGetResponse(person.getValue());
	  }
	  
	  @DELETE
	  public void deletePerson() {
	    // Person p = PersonDAO.instance.getModel().remove(ssnr);
	    if (true) 
	    	throw new RuntimeException("Delete: Person with ssnr= I DUNT KNOW" +  " not found");
	  }
	  
	  private Response putAndGetResponse(Concert person) {
	    Response res = null;
	    //ToDo: check content and if okay, do something
	    if (true) {
	      res = Response.noContent().build();
	    } else {
	      res = Response.created(uriInfo.getAbsolutePath()).build();
	    }
	    //PersonDAO.instance.getModel().put(person.getSsnr(), person);
	    return res;
	  }  
}

package com.pts.rest;


import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.pts.business.BillerBusiness;
import com.pts.exception.BillerNotFoundException;
import com.pts.hibernate.BillerDAO;
import com.pts.pojo.Biller;

@Path("/biller")
public class BillerService {
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getBiller(@PathParam("id") int id) {
		Biller biller = null;
		try {
			biller = new BillerBusiness().getBiller(id);
		} catch (BillerNotFoundException e) {
			return Response.status(Status.NOT_FOUND).build();
		}
		return Response.status(Status.OK).entity(biller).build();
	}
	
	@POST
	@Path("/create")
	@Produces(MediaType.APPLICATION_JSON)
	public Biller createBiller(@FormParam("billerName") String billerName) {
		Biller biller = new BillerDAO().createBiller(billerName);
		return biller;
	}
	
	@PUT
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
	public Biller updateBiller(@FormParam("billerId") int billerId, @FormParam("billerName") String billerName) {
		Biller biller = new BillerBusiness().updateBiller(billerId, billerName);
		return biller;
	}
	
	@DELETE
	@Path("/deletee")
	@Produces(MediaType.APPLICATION_JSON)
	public boolean deleteBiller(@FormParam("billerId") int billerId) {
		return new BillerBusiness().deleteBiller(billerId);
	}

}

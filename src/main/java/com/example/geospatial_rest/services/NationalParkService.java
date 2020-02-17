package com.example.geospatial_rest.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

@Path("/parks")
public class NationalParkService extends AbstractService{

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllParks() {
		Gson gson = new Gson();
		return Response.ok(gson.toJson(getDataBean().getNationalParks())).build();
	}

}

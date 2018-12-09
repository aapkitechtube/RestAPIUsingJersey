package com.aapkitechtube.rest.service;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import com.aapkitechtube.rest.dao.RegistrationDaoImpl;
import com.aapkitechtube.rest.model.Registration;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

@Path("/registration")
@Api(value="/registration", description = "User registration related services")
public class RegistrationService {
	
	@Autowired
	private RegistrationDaoImpl registrationService;

	@POST
	@Produces("application/json")
	@ApiOperation (value="Create registration for a user",
		response=Registration.class,
		consumes="application/json",
		produces="application/json"
	)
	public Registration createRegistration(Registration registration) {
		registrationService.addRegistration(registration);
		return registration;
	}

	@Path("{registrationId}")
	@GET
	@Produces("application/json")
	@ApiOperation (value="Get user registration by email",
		response=Registration.class,
		consumes="application/json",
		produces="application/json"
	)
	@ApiResponses(value = {
			@ApiResponse(code = 400, message = "Invalid registration ID supplied"),
		    @ApiResponse(code = 404, message = "User registration not found") 
	})
	public Response getRegistration(@PathParam("registrationId") String registrationId) {
		System.out.println("registrationId=" + registrationId);
		Registration registration = registrationService.viewRegistration(registrationId);
		return Response.status(200).entity(registration).build();
	}
}

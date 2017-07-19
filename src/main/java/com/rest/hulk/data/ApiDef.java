package com.rest.hulk.data;

import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.askinfo.beans.SignIn;
import com.askinfo.beans.SignUp;
import com.askinfo.dao.LoginDaoImpl;
import com.askinfo.dao.SignUpDaoImpl;
import com.askinfo.factories.LoginDaoFactory;
import com.askinfo.factories.SignUpDaoFactory;

/**
 * Root resource (exposed at "login" path)
 */
@Path("login")
public class ApiDef {

	/**
	 * Method handling HTTP GET requests. The returned object will be sent to the
	 * client as "text/plain" media type.
	 *
	 * @return String that will be returned as a text/plain response.
	 */

	@GET
	@Path("/signin/{username}/{password}")

	@Produces(MediaType.APPLICATION_JSON)
	public Response getDetails(@PathParam("username") String username, @PathParam("password") String password) {
		SignIn user = new SignIn();
		LoginDaoImpl userDao = LoginDaoFactory.getLoginDaoImpl();
		System.out.println("username " + username + "\npassword " + password);
		user = userDao.getLoginInfo(username, password);
		if (user == null)
			return Response.status(404).entity(user).header("Access-Control-Allow-Origin", "*").allow("OPTIONS")
					.build();
		return Response.status(200).entity(user).header("Access-Control-Allow-Origin", "*").allow("OPTIONS").build();
	}

	@POST
	@Path("/signup")
	@Produces(MediaType.APPLICATION_JSON)
	public Response addUser(SignUp signUpDetails) {
		System.out.println(
				signUpDetails.getUsername() + "\n" + signUpDetails.getEmail() + "\n" + signUpDetails.getPassword());
		SignUpDaoImpl signUp = SignUpDaoFactory.getSignUpDaoImpl();
		signUp.addUser(signUpDetails);
		return Response.ok().entity(signUpDetails).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, PATCH, PUT, DELETE, OPTIONS")
				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization").allow("OPTIONS")
				.build();
	}
	
}

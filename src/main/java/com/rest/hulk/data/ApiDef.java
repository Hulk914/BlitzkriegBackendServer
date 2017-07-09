package com.rest.hulk.data;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.askinfo.beans.SignIn;
import com.askinfo.beans.SignUp;
import com.askinfo.dao.LoginDaoImpl;
import com.askinfo.factories.LoginDaoFactory;
/**
 * Root resource (exposed at "login" path)
 */
@Path("login")
public class ApiDef {

	/**
	 * Method handling HTTP GET requests. The returned object will be sent to
	 * the client as "text/plain" media type.
	 *
	 * @return String that will be returned as a text/plain response.
	 */

	@GET
    @Path("/signin")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDetails(){
    	SignIn user=new SignIn();
    	LoginDaoImpl userDao=LoginDaoFactory.getLoginDaoImpl();
    	user=userDao.getLoginInfo();
    	return Response.ok()
    			.entity(user)
    			.header("Access-Control-Allow-Origin", "*")
    			.allow("OPTIONS").build();
    }
	
	@POST
	@Path("/signup")
	@Produces(MediaType.APPLICATION_JSON)
	public Response addUser(SignUp signUpDetails){
		System.out.println(signUpDetails.getUsername());
		return Response.ok()
    			.entity(signUpDetails)
    			.header("Access-Control-Allow-Origin", "*")
    			.allow("OPTIONS").build();
	}
}

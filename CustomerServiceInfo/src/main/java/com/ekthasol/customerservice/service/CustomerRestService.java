package com.ekthasol.customerservice.service;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.ekthasol.customerservice.dao.CustomerRestServiceDAO;
import com.ekthasol.customerservice.model.Customer;

/**
 * @author Shravya Peddiraju 
 * Rest service provider to get customer details by id.
 */
@Path("/customer")
public class CustomerRestService {

	final static Logger logger = Logger.getLogger(CustomerRestService.class);

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@HeaderParam(value = "content-type = application/octet-stream")
	@Path("/{param}")
	public Customer getCustomer(@PathParam("param") int custID) {
		
		CustomerRestServiceDAO customerService = new CustomerRestServiceDAO();
		Customer customer = customerService.getCustomer(custID);

		logger.info("Retrieved Details");

		return customer;
	}
}

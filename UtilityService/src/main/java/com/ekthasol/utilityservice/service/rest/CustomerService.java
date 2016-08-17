package com.ekthasol.utilityservice.service.rest;

import com.ekthasol.utilityservice.model.registration.Customer;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class CustomerService {
	
	/**
	 * @param id
	 * @return
	 * Rest call to get the customer details from the CustomerServiceInfo application
	 */
	public Customer getCustomerDetails(Integer id) {

		Customer cust = null;
		try {
			Client client = Client.create();

			WebResource webResource = client
					.resource("http://localhost:8080/CustomerServiceInfo/RestWS/customer/" + id);
			ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			}

			System.out.println("Output from Server .... \n");
			cust = response.getEntity(Customer.class);
			System.out.println(cust.getFirstName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cust;
	}
	
	

}

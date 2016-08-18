package com.ekthasol.customerservice.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.ekthasol.customerservice.dao.CustomerSoapServiceDAO;
import com.ekthasol.customerservice.model.ServicePlan;

/**
 * @author Shravya Peddiraju 
 * Soap service provider class to get all the services
 * from the database.
 */
@WebService
public class CustomerSoapService {

	/**
	 * Method to retrieve service plans from the database.
	 * @return list of service plans
	 */
	@WebMethod
	public List<ServicePlan> getServicePlan() {

		CustomerSoapServiceDAO customerService = new CustomerSoapServiceDAO();
		List<ServicePlan> servicePlan = customerService.getServicePlans();
		return servicePlan;

	}
}

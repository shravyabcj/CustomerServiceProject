package com.ekthasol.customerservice.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.ekthasol.customerservice.dao.CustomerServiceDAO;
import com.ekthasol.customerservice.model.ServicePlan;
/**
 * @author Shravya Peddiraju
 *	Soap service provider.
 */
@WebService
public class CustomerSoapService {

	@WebMethod
	public List<ServicePlan> getServicePlan() {
		List<ServicePlan> servicePlan = CustomerServiceDAO.getServicePlan();
		return servicePlan;
	}
}

package com.ekthasol.utilityservice.service.soap;

import java.util.List;

import org.apache.log4j.Logger;

import com.ekthasol.utilityservice.service.registration.RegistrationService;
import com.ekthasol.utilityservice.webservice.CustomerSoapService;
import com.ekthasol.utilityservice.webservice.CustomerSoapServiceService;
import com.ekthasol.utilityservice.webservice.ServicePlan;

public class ServicePlanList {

	
	
	public List<ServicePlan> getServicePlan() {

		CustomerSoapServiceService customerSoapService = new CustomerSoapServiceService();

		CustomerSoapService service = customerSoapService.getCustomerSoapServicePort();

		List<ServicePlan> serviceList = service.getServicePlan();

		return serviceList;
	}


}

package com.ekthasol.utilityservice.service.registration;

import java.util.List;

import com.ekthasol.utilityservice.dao.registration.RegistrationDao;
import com.ekthasol.utilityservice.jms.registration.JmsQueueSender;
import com.ekthasol.utilityservice.model.registration.Customer;
import com.ekthasol.utilityservice.service.rest.CustomerService;
import com.ekthasol.utilityservice.service.soap.ServicePlanList;
import com.ekthasol.utilityservice.webservice.ServicePlan;

/**
 * @author Shravya Peddiraju Service class which includes all the service calls
 *         of rest, soap and JMS
 */
public class RegistrationService {

	RegistrationDao registrationDao;
	JmsQueueSender jmsQueueSender;
	String message ="not registered";

	public RegistrationService(RegistrationDao registrationDao, JmsQueueSender jmsQueueSender) {
		this.registrationDao = registrationDao;
		this.jmsQueueSender = jmsQueueSender;
	}

	/**
	 * @param customer
	 * @return cust_id Inserts the customer details in the database
	 */
	public String saveCustomer(Customer customer) {

		int cust_id = registrationDao.insertCustomer(customer);
		if (cust_id > 0) {
			ServicePlanList list = new ServicePlanList();
			List<ServicePlan> servicePlanList = list.getServicePlan();

			CustomerService service = new CustomerService();
			service.getCustomerDetails(cust_id);

			jmsQueueSender.sendMessage(cust_id + " " + servicePlanList.get(0).getServiceId());

			message = "Service Plan ID: " + servicePlanList.get(0).getServiceId() + " and service plan "
					+ servicePlanList.get(0).getServicaplan();
		}
		return message;
	}
}
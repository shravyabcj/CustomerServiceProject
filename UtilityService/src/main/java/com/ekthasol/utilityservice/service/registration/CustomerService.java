package com.ekthasol.utilityservice.service.registration;

import java.util.List;

import com.ekthasol.utilityservice.dao.registration.RegistrationDao;
import com.ekthasol.utilityservice.jms.registration.JmsQueueSender;
import com.ekthasol.utilityservice.model.registration.Customer;
import com.ekthasol.utilityservice.webservice.CustomerSoapService;
import com.ekthasol.utilityservice.webservice.CustomerSoapServiceService;
import com.ekthasol.utilityservice.webservice.ServicePlan;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 * @author Shravya Peddiraju Service class which includes all the service calls
 *         of rest, soap and JMS
 */
public class CustomerService {

	RegistrationDao registrationDao;
	JmsQueueSender jmsQueueSender;
	

	public CustomerService(RegistrationDao registrationDao, JmsQueueSender jmsQueueSender) {
		this.registrationDao = registrationDao;
		this.jmsQueueSender = jmsQueueSender;
	}

	/**
	 * @param customer
	 * @return cust_id 
	 * Inserts the customer details in the database
	 */
	public String[] saveCustomer(Customer customer) {
		
		String str = null;
		String[] result = null;

		int cust_id = registrationDao.insertCustomer(customer);
		if (cust_id > 0) {
			List<ServicePlan> servicePlanList = getServicePlan();
			jmsQueueSender.sendMessage(String.valueOf(cust_id) + " " + servicePlanList.get(0).getServiceId());
			Customer cust = getCustomerDetails(cust_id);
			str = cust.toString() + "," + servicePlanList.get(0).getServiceId() + "," +servicePlanList.get(0).getServicaplan();
			result = str.split(",");
		}
		return result;
	}

	/**
	 * @return
	 */
	public List<ServicePlan> getServicePlan() {

		CustomerSoapServiceService customerSoapService = new CustomerSoapServiceService();

		CustomerSoapService service = customerSoapService.getCustomerSoapServicePort();

		List<ServicePlan> serviceList = service.getServicePlan();

		return serviceList;
	}

	/**
	 * @param id
	 * @return 
	 * Rest call to get the customer details from the
	 * CustomerServiceInfo application
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
			cust = response.getEntity(Customer.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cust;
	}
}
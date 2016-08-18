package com.ekthasol.customerservice.service;

import com.ekthasol.customerservice.dao.MessageServiceDAO;

/**
 * @author Shravya Peddiraju 
 * JMS listener provider class to update the service plan id for the given customer id in
 * the database.
 */
public class MessageService {

	/**
	 * Method to update service plan id for the given customer id in
	 * the database.
	 * @param c_id
	 * @param serv_id
	 */
	public void setCustomerService(int c_id, int serv_id) {

		MessageServiceDAO messageService = new MessageServiceDAO();
		messageService.updateCustomer(c_id, serv_id);
	}
}

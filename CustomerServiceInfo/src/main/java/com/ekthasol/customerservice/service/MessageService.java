package com.ekthasol.customerservice.service;

import com.ekthasol.customerservice.dao.MessageServiceDAO;

/**
 * @author Shravya Peddiraju
 *	JMS listener.
 */
public class MessageService {

	
	public int setCustomerService(int c_id, int serv_id) {
	
		MessageServiceDAO messageServiceDao = new MessageServiceDAO();
		int rowUpdate = messageServiceDao.saveCustomerService(c_id, serv_id);
		return rowUpdate;
	}
}

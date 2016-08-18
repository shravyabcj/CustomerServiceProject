package com.ekthasol.customerservice.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.ekthasol.customerservice.model.Customer;
import com.ekthasol.customerservice.util.HibernateUtil;

/**
 * @author Shravya Peddiraju
 * JMS service DAO class to update the service plan id for the given customer ID 
 * in the database.
 */
public class MessageServiceDAO {
	
	/**
	 * Method to update service id for the given customer id in the database.
	 * @param c_id
	 * @param serv_id
	 */
	public void updateCustomer(int c_id, int serv_id) {

		Session session = HibernateUtil.getSession();
		session.getTransaction().begin();
		try {
			
			Customer cust = (Customer) session.get(Customer.class, c_id);
			cust.setServiceID(String.valueOf(serv_id));
			session.update(cust);
			session.getTransaction().commit();
			
		} catch (HibernateException e) {
			e.printStackTrace();
			session.close();
		}
	}
}
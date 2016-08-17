package com.ekthasol.customerservice.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.ekthasol.customerservice.model.Customer;
import com.ekthasol.customerservice.util.HibernateUtil;

/**
 * @author Shravya Peddiraju
 */
public class MessageServiceDAO {

	public int saveCustomerService(int c_id, int serv_id) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		// Customer cust = new Customer();

		session.getTransaction().begin();
		int row = 0;
		try {

			Customer cust = (Customer) session.get(Customer.class, c_id);
			cust.setServiceID(String.valueOf(serv_id));
			System.out.println(cust.getServiceID());
			session.update(cust);

			System.out.println(row);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();

			session.close();
		}
		return row;
	}
}
package com.ekthasol.customerservice.dao;


import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.ekthasol.customerservice.model.Customer;
import com.ekthasol.customerservice.util.HibernateUtil;

/**
 * @author Shravya Peddiraju
 * Rest service DAO to get customer details by id from the database.
 */
public class CustomerRestServiceDAO {

	/**
	 * Method to get customer details by id from the database.
	 * @param custID
	 * @return
	 */
	public Customer getCustomer(int custID) {
		Customer cust = null;
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();

		try {
			Query query = session.createQuery("from Customer where  id= :id ");
			query.setParameter("id", custID);
			cust = (Customer) query.list().get(0);

		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cust;
	}
}

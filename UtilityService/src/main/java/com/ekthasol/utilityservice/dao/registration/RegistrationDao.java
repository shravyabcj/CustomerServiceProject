package com.ekthasol.utilityservice.dao.registration;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.ekthasol.utilityservice.model.registration.Customer;

/**
 * @author Shravya Peddiraju 
 * DAO class to insert the customer details in the
 * database.
 */
public class RegistrationDao {

	@Autowired
	SessionFactory sessionFactory;

	public int insertCustomer(Customer customer) {
		int cust_id = 0;
		Session session = sessionFactory.openSession();
		try {
			//Transaction trans = session.beginTransaction();
			cust_id = (int) session.save(customer);
			//trans.commit();
			} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//session.close();
		return cust_id;
	}
}
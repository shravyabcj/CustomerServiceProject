package com.ekthasol.customerservice.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ekthasol.customerservice.model.ServicePlan;
import com.ekthasol.customerservice.util.HibernateUtil;

/**
 * @author Shravya Peddiraju
 * Soap service DAO class to get the service plans from the database.
 */
public class CustomerSoapServiceDAO {
	
	/**
	 * Method to retrieve service plans from the database.
	 * @return list of service plans
	 */
	@SuppressWarnings("unchecked")
	public List<ServicePlan> getServicePlans() {
		List<ServicePlan> serviceList = new ArrayList<ServicePlan>();
		Session session = HibernateUtil.getSession();

		try {
			Transaction trans = session.beginTransaction();
			serviceList = session.createQuery("from ServicePlan").list();
			trans.commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return serviceList;
	}
}

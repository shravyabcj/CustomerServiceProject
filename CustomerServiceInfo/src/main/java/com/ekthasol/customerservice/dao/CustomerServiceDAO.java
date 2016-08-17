package com.ekthasol.customerservice.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ekthasol.customerservice.model.Customer;
import com.ekthasol.customerservice.model.ServicePlan;
import com.ekthasol.customerservice.util.HibernateUtil;

/**
 * @author Shravya Peddiraju
 */
public class CustomerServiceDAO {

	public static Customer getCustomer(int custID) {
		Customer cust = null;
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		try {
			Transaction trans =  session.beginTransaction();
			Query query = session.createQuery("from Customer where  id= :id ");
			query.setParameter("id", custID);
			cust = (Customer) query.uniqueResult();
			
			//cust = (Customer) session.get(Customer.class, custID);
			trans.commit();

		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return cust;
	}
	

	@SuppressWarnings("unchecked")
	public static List<ServicePlan> getServicePlan() {
		List<ServicePlan> serviceList = new ArrayList<>();
		System.out.println(serviceList.toString());
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		try {
			Transaction trans = session.beginTransaction();
			serviceList = session.createQuery("from ServicePlan").list();
			trans.commit();

		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		System.out.println(serviceList.toString());
		return serviceList;
	}
}

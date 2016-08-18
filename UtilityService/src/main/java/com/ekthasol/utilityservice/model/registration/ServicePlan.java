package com.ekthasol.utilityservice.model.registration;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Shravya Peddiraju Entity class of ServicePlan
 */
@Entity
@Table(name = "service_plan")
public class ServicePlan {

	@Id
	@Column(name = "ID", nullable = false)
	private int serviceId;

	@Column(name = "SERVICEPLAN", nullable = true)
	private String servicePlan;

	/**
	 * @return the serviceId
	 */
	public int getServiceId() {
		return serviceId;
	}

	/**
	 * @return the servicaplan
	 */
	public String getServicaplan() {
		return servicePlan;
	}

	/**
	 * @param serviceId
	 *            the serviceId to set
	 */
	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}

	/**
	 * @param servicePlan
	 *            the serviceplan to set
	 */
	public void setServicaplan(String servicePlan) {
		this.servicePlan = servicePlan;
	}
}

package com.ekthasol.utilityservice.registration.testcases;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.Mockito;

import com.ekthasol.utilityservice.model.registration.Customer;
import com.ekthasol.utilityservice.service.registration.RegistrationService;
import com.ekthasol.utilityservice.service.rest.CustomerService;


public class MockitoTestCase {

	/*@Test
	public void test() {
		Customer customer = new Customer();
		RegistrationService rsg = Mockito.mock(RegistrationService.class);
		when(rsg.saveCustomer(customer)).thenReturn(43);
		assertEquals(rsg.saveCustomer(customer), 43);
	}*/

	@Test
	public void testGetCustomer() {
		Customer customer = new Customer();
		customer.setFirstName("Shravya");
		customer.setLastName("Peddiraju");
		customer.setEmail("speddiraju.bcj@gmail.com");
		customer.setUsername("speddiraju");
		
		CustomerService rsg = Mockito.mock(CustomerService.class);
		
		when(rsg.getCustomerDetails(1)).thenReturn(customer);
		
		assertEquals(rsg.getCustomerDetails(1), customer);
	}
}

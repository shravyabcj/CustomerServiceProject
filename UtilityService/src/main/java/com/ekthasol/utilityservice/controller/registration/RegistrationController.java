package com.ekthasol.utilityservice.controller.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ekthasol.utilityservice.model.registration.Customer;
import com.ekthasol.utilityservice.service.registration.CustomerService;

/**
 * @author Shravya Peddiraju
 * 
 */
@Controller
public class RegistrationController {

	@Autowired
	CustomerService customerService;

	@RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
	public ModelAndView handleRequest(@ModelAttribute("customer") Customer customer) {

		String[] result = customerService.saveCustomer(customer);
		if (result != null)
			return new ModelAndView("result", "customer", result);
		else
			return new ModelAndView("failure", "message", "Data could not be inserted!!!");
	}
}

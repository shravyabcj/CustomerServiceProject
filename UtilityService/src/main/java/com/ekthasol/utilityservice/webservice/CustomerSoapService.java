package com.ekthasol.utilityservice.webservice;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.1.7
 * 2016-08-18T02:58:11.160-05:00
 * Generated source version: 3.1.7
 * 
 */
@WebService(targetNamespace = "http://service.customerservice.ekthasol.com/", name = "CustomerSoapService")
@XmlSeeAlso({ObjectFactory.class})
public interface CustomerSoapService {

    @WebMethod
    @RequestWrapper(localName = "getServicePlan", targetNamespace = "http://service.customerservice.ekthasol.com/", className = "com.ekthasol.utilityservice.webservice.GetServicePlan")
    @ResponseWrapper(localName = "getServicePlanResponse", targetNamespace = "http://service.customerservice.ekthasol.com/", className = "com.ekthasol.utilityservice.webservice.GetServicePlanResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<com.ekthasol.utilityservice.webservice.ServicePlan> getServicePlan();
}

package com.ekthasol.utilityservice.webservice;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.1.7
 * 2016-08-18T02:58:11.171-05:00
 * Generated source version: 3.1.7
 * 
 */
@WebServiceClient(name = "CustomerSoapServiceService", 
                  wsdlLocation = "file:/C:/BCJMay16/Develop/Workspace/Shravya_REPO/CustomerServiceProject/UtilityService/src/main/resources/test.wsdl",
                  targetNamespace = "http://service.customerservice.ekthasol.com/") 
public class CustomerSoapServiceService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://service.customerservice.ekthasol.com/", "CustomerSoapServiceService");
    public final static QName CustomerSoapServicePort = new QName("http://service.customerservice.ekthasol.com/", "CustomerSoapServicePort");
    static {
        URL url = null;
        try {
            url = new URL("file:/C:/BCJMay16/Develop/Workspace/Shravya_REPO/CustomerServiceProject/UtilityService/src/main/resources/test.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(CustomerSoapServiceService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "file:/C:/BCJMay16/Develop/Workspace/Shravya_REPO/CustomerServiceProject/UtilityService/src/main/resources/test.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public CustomerSoapServiceService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public CustomerSoapServiceService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CustomerSoapServiceService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    public CustomerSoapServiceService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public CustomerSoapServiceService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public CustomerSoapServiceService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }    




    /**
     *
     * @return
     *     returns CustomerSoapService
     */
    @WebEndpoint(name = "CustomerSoapServicePort")
    public CustomerSoapService getCustomerSoapServicePort() {
        return super.getPort(CustomerSoapServicePort, CustomerSoapService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CustomerSoapService
     */
    @WebEndpoint(name = "CustomerSoapServicePort")
    public CustomerSoapService getCustomerSoapServicePort(WebServiceFeature... features) {
        return super.getPort(CustomerSoapServicePort, CustomerSoapService.class, features);
    }

}

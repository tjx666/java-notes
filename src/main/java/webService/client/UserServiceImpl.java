
package webService.client;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "UserServiceImpl", targetNamespace = "http://webService/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface UserServiceImpl {


    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getUserByName", targetNamespace = "http://webService/", className = "webService.client.GetUserByName")
    @ResponseWrapper(localName = "getUserByNameResponse", targetNamespace = "http://webService/", className = "webService.client.GetUserByNameResponse")
    @Action(input = "http://webService/UserServiceImpl/getUserByNameRequest", output = "http://webService/UserServiceImpl/getUserByNameResponse")
    public String getUserByName(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

}

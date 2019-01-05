
package webService.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the webService.client package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetUserByNameResponse_QNAME = new QName("http://webService/", "getUserByNameResponse");
    private final static QName _GetUserByName_QNAME = new QName("http://webService/", "getUserByName");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: webService.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetUserByNameResponse }
     * 
     */
    public GetUserByNameResponse createGetUserByNameResponse() {
        return new GetUserByNameResponse();
    }

    /**
     * Create an instance of {@link GetUserByName }
     * 
     */
    public GetUserByName createGetUserByName() {
        return new GetUserByName();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserByNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService/", name = "getUserByNameResponse")
    public JAXBElement<GetUserByNameResponse> createGetUserByNameResponse(GetUserByNameResponse value) {
        return new JAXBElement<GetUserByNameResponse>(_GetUserByNameResponse_QNAME, GetUserByNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserByName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService/", name = "getUserByName")
    public JAXBElement<GetUserByName> createGetUserByName(GetUserByName value) {
        return new JAXBElement<GetUserByName>(_GetUserByName_QNAME, GetUserByName.class, null, value);
    }

}

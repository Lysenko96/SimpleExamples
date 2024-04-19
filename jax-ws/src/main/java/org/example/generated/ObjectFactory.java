
package org.example.generated;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.example.generated package. 
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

    private final static QName _CheckJob_QNAME = new QName("http://webservice.example.org/", "checkJob");
    private final static QName _CheckJobResponse_QNAME = new QName("http://webservice.example.org/", "checkJobResponse");
    private final static QName _Hello_QNAME = new QName("http://webservice.example.org/", "hello");
    private final static QName _HelloResponse_QNAME = new QName("http://webservice.example.org/", "helloResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.example.generated
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CheckJob }
     * 
     */
    public CheckJob createCheckJob() {
        return new CheckJob();
    }

    /**
     * Create an instance of {@link CheckJobResponse }
     * 
     */
    public CheckJobResponse createCheckJobResponse() {
        return new CheckJobResponse();
    }

    /**
     * Create an instance of {@link Hello }
     * 
     */
    public Hello createHello() {
        return new Hello();
    }

    /**
     * Create an instance of {@link HelloResponse }
     * 
     */
    public HelloResponse createHelloResponse() {
        return new HelloResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckJob }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CheckJob }{@code >}
     */
    @XmlElementDecl(namespace = "http://webservice.example.org/", name = "checkJob")
    public JAXBElement<CheckJob> createCheckJob(CheckJob value) {
        return new JAXBElement<CheckJob>(_CheckJob_QNAME, CheckJob.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckJobResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CheckJobResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://webservice.example.org/", name = "checkJobResponse")
    public JAXBElement<CheckJobResponse> createCheckJobResponse(CheckJobResponse value) {
        return new JAXBElement<CheckJobResponse>(_CheckJobResponse_QNAME, CheckJobResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Hello }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Hello }{@code >}
     */
    @XmlElementDecl(namespace = "http://webservice.example.org/", name = "hello")
    public JAXBElement<Hello> createHello(Hello value) {
        return new JAXBElement<Hello>(_Hello_QNAME, Hello.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link HelloResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://webservice.example.org/", name = "helloResponse")
    public JAXBElement<HelloResponse> createHelloResponse(HelloResponse value) {
        return new JAXBElement<HelloResponse>(_HelloResponse_QNAME, HelloResponse.class, null, value);
    }

}


package pe.grupobbva.alcon.core.ws.transacciones;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "Transacciones", targetNamespace = "http://tempuri.org/", wsdlLocation = "http://172.30.10.222/WSERGENERAL/Transacciones.asmx?wsdl")
public class Transacciones
    extends Service
{

    private final static URL TRANSACCIONES_WSDL_LOCATION;
    private final static WebServiceException TRANSACCIONES_EXCEPTION;
    private final static QName TRANSACCIONES_QNAME = new QName("http://tempuri.org/", "Transacciones");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://172.30.10.222/WSERGENERAL/Transacciones.asmx?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        TRANSACCIONES_WSDL_LOCATION = url;
        TRANSACCIONES_EXCEPTION = e;
    }

    private Transacciones() {
        super(__getWsdlLocation(), TRANSACCIONES_QNAME);
    }

    public Transacciones(WebServiceFeature... features) {
        super(__getWsdlLocation(), TRANSACCIONES_QNAME, features);
    }

    public Transacciones(URL wsdlLocation) {
        super(wsdlLocation, TRANSACCIONES_QNAME);
    }

    public Transacciones(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, TRANSACCIONES_QNAME, features);
    }

    public Transacciones(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public Transacciones(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns TransaccionesSoap
     */
    @WebEndpoint(name = "TransaccionesSoap")
    public TransaccionesSoap getTransaccionesSoap() {
        return super.getPort(new QName("http://tempuri.org/", "TransaccionesSoap"), TransaccionesSoap.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns TransaccionesSoap
     */
    @WebEndpoint(name = "TransaccionesSoap")
    public TransaccionesSoap getTransaccionesSoap(WebServiceFeature... features) {
        return super.getPort(new QName("http://tempuri.org/", "TransaccionesSoap"), TransaccionesSoap.class, features);
    }

    private static URL __getWsdlLocation() {
        if (TRANSACCIONES_EXCEPTION!= null) {
            throw TRANSACCIONES_EXCEPTION;
        }
        return TRANSACCIONES_WSDL_LOCATION;
    }

}

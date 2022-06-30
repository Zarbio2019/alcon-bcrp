
package pe.grupobbva.alcon.core.ws.transacciones;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.tempuri package. 
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

    private final static QName _String_QNAME = new QName("http://tempuri.org/", "string");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.tempuri
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link EnviaTramas }
     * 
     */
    public EnviaTramas createEnviaTramas() {
        return new EnviaTramas();
    }

    /**
     * Create an instance of {@link ListaMenuGenerico }
     * 
     */
    public ListaMenuGenerico createListaMenuGenerico() {
        return new ListaMenuGenerico();
    }

    /**
     * Create an instance of {@link ListaMenuGenericoResponse }
     * 
     */
    public ListaMenuGenericoResponse createListaMenuGenericoResponse() {
        return new ListaMenuGenericoResponse();
    }

    /**
     * Create an instance of {@link ListaMenu }
     * 
     */
    public ListaMenu createListaMenu() {
        return new ListaMenu();
    }

    /**
     * Create an instance of {@link ListaMenuResponse }
     * 
     */
    public ListaMenuResponse createListaMenuResponse() {
        return new ListaMenuResponse();
    }

    /**
     * Create an instance of {@link ValidarUsuarioPorTipo }
     * 
     */
    public ValidarUsuarioPorTipo createValidarUsuarioPorTipo() {
        return new ValidarUsuarioPorTipo();
    }

    /**
     * Create an instance of {@link SoloTrama }
     * 
     */
    public SoloTrama createSoloTrama() {
        return new SoloTrama();
    }

    /**
     * Create an instance of {@link SoloTramaResponse }
     * 
     */
    public SoloTramaResponse createSoloTramaResponse() {
        return new SoloTramaResponse();
    }

    /**
     * Create an instance of {@link ListaMenuGenericoSinTeclaResponse }
     * 
     */
    public ListaMenuGenericoSinTeclaResponse createListaMenuGenericoSinTeclaResponse() {
        return new ListaMenuGenericoSinTeclaResponse();
    }

    /**
     * Create an instance of {@link ListaMenuGenericoSinTecla }
     * 
     */
    public ListaMenuGenericoSinTecla createListaMenuGenericoSinTecla() {
        return new ListaMenuGenericoSinTecla();
    }

    /**
     * Create an instance of {@link EnviaTramasResponse }
     * 
     */
    public EnviaTramasResponse createEnviaTramasResponse() {
        return new EnviaTramasResponse();
    }

    /**
     * Create an instance of {@link ValidarUsuarioResponse }
     * 
     */
    public ValidarUsuarioResponse createValidarUsuarioResponse() {
        return new ValidarUsuarioResponse();
    }

    /**
     * Create an instance of {@link ValidarUsuario }
     * 
     */
    public ValidarUsuario createValidarUsuario() {
        return new ValidarUsuario();
    }

    /**
     * Create an instance of {@link ValidarUsuarioPorTipoResponse }
     * 
     */
    public ValidarUsuarioPorTipoResponse createValidarUsuarioPorTipoResponse() {
        return new ValidarUsuarioPorTipoResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "string")
    public JAXBElement<String> createString(String value) {
        return new JAXBElement<String>(_String_QNAME, String.class, null, value);
    }

}

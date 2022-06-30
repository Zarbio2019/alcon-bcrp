
package pe.grupobbva.alcon.core.ws.transacciones;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="strIdLogin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="strIdTrama" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="strTrama" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="strAmbienteHOST" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="strIpCliente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="strSesion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="strUsuario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="strPassword" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="strCodigoSistema" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "strIdLogin",
    "strIdTrama",
    "strTrama",
    "strAmbienteHOST",
    "strIpCliente",
    "strSesion",
    "strUsuario",
    "strPassword",
    "strCodigoSistema"
})
@XmlRootElement(name = "EnviaTramas")
public class EnviaTramas {

    protected String strIdLogin;
    protected String strIdTrama;
    protected String strTrama;
    protected String strAmbienteHOST;
    protected String strIpCliente;
    protected String strSesion;
    protected String strUsuario;
    protected String strPassword;
    protected String strCodigoSistema;

    /**
     * Obtiene el valor de la propiedad strIdLogin.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrIdLogin() {
        return strIdLogin;
    }

    /**
     * Define el valor de la propiedad strIdLogin.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrIdLogin(String value) {
        this.strIdLogin = value;
    }

    /**
     * Obtiene el valor de la propiedad strIdTrama.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrIdTrama() {
        return strIdTrama;
    }

    /**
     * Define el valor de la propiedad strIdTrama.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrIdTrama(String value) {
        this.strIdTrama = value;
    }

    /**
     * Obtiene el valor de la propiedad strTrama.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrTrama() {
        return strTrama;
    }

    /**
     * Define el valor de la propiedad strTrama.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrTrama(String value) {
        this.strTrama = value;
    }

    /**
     * Obtiene el valor de la propiedad strAmbienteHOST.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrAmbienteHOST() {
        return strAmbienteHOST;
    }

    /**
     * Define el valor de la propiedad strAmbienteHOST.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrAmbienteHOST(String value) {
        this.strAmbienteHOST = value;
    }

    /**
     * Obtiene el valor de la propiedad strIpCliente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrIpCliente() {
        return strIpCliente;
    }

    /**
     * Define el valor de la propiedad strIpCliente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrIpCliente(String value) {
        this.strIpCliente = value;
    }

    /**
     * Obtiene el valor de la propiedad strSesion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrSesion() {
        return strSesion;
    }

    /**
     * Define el valor de la propiedad strSesion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrSesion(String value) {
        this.strSesion = value;
    }

    /**
     * Obtiene el valor de la propiedad strUsuario.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrUsuario() {
        return strUsuario;
    }

    /**
     * Define el valor de la propiedad strUsuario.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrUsuario(String value) {
        this.strUsuario = value;
    }

    /**
     * Obtiene el valor de la propiedad strPassword.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrPassword() {
        return strPassword;
    }

    /**
     * Define el valor de la propiedad strPassword.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrPassword(String value) {
        this.strPassword = value;
    }

    /**
     * Obtiene el valor de la propiedad strCodigoSistema.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrCodigoSistema() {
        return strCodigoSistema;
    }

    /**
     * Define el valor de la propiedad strCodigoSistema.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrCodigoSistema(String value) {
        this.strCodigoSistema = value;
    }

}

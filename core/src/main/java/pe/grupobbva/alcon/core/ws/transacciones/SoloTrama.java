
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
 *         &lt;element name="strIdTrama" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="strTrama" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="strAmbienteHOST" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="strIpCliente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "strIdTrama",
    "strTrama",
    "strAmbienteHOST",
    "strIpCliente",
    "strCodigoSistema"
})
@XmlRootElement(name = "SoloTrama")
public class SoloTrama {

    protected String strIdTrama;
    protected String strTrama;
    protected String strAmbienteHOST;
    protected String strIpCliente;
    protected String strCodigoSistema;

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


package pe.grupobbva.alcon.core.ws.transacciones;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 *         &lt;element name="ValidarUsuarioResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "validarUsuarioResult"
})
@XmlRootElement(name = "ValidarUsuarioResponse")
public class ValidarUsuarioResponse {

    @XmlElement(name = "ValidarUsuarioResult")
    protected String validarUsuarioResult;

    /**
     * Obtiene el valor de la propiedad validarUsuarioResult.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValidarUsuarioResult() {
        return validarUsuarioResult;
    }

    /**
     * Define el valor de la propiedad validarUsuarioResult.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValidarUsuarioResult(String value) {
        this.validarUsuarioResult = value;
    }

}

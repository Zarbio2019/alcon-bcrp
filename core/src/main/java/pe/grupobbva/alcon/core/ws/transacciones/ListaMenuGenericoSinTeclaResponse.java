
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
 *         &lt;element name="ListaMenuGenericoSinTeclaResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "listaMenuGenericoSinTeclaResult"
})
@XmlRootElement(name = "ListaMenuGenericoSinTeclaResponse")
public class ListaMenuGenericoSinTeclaResponse {

    @XmlElement(name = "ListaMenuGenericoSinTeclaResult")
    protected String listaMenuGenericoSinTeclaResult;

    /**
     * Obtiene el valor de la propiedad listaMenuGenericoSinTeclaResult.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getListaMenuGenericoSinTeclaResult() {
        return listaMenuGenericoSinTeclaResult;
    }

    /**
     * Define el valor de la propiedad listaMenuGenericoSinTeclaResult.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setListaMenuGenericoSinTeclaResult(String value) {
        this.listaMenuGenericoSinTeclaResult = value;
    }

}

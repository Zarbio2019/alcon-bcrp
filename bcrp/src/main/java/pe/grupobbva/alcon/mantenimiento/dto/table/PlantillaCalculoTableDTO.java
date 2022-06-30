package pe.grupobbva.alcon.mantenimiento.dto.table;

import lombok.Data;
import pe.grupobbva.alcon.mantenimiento.dto.PlantillaCalculoDTO;
import pe.grupobbva.alcon.mantenimiento.entity.PlantillaCalculo;
import pe.grupobbva.alcon.mantenimiento.entity.TipoDatoPlantilla;
import pe.grupobbva.alcon.mantenimiento.entity.TipoSigno;

@Data
public class PlantillaCalculoTableDTO extends PlantillaCalculoDTO {
	private String tipodatoplantilladescripcion;
	private String tiposignodescripcion;
	
	public PlantillaCalculoTableDTO() {
		super();
	}
	
	public PlantillaCalculoTableDTO(PlantillaCalculo entity) {
		super(entity);
	}
	/**
	 * @param id
	 * @param tipodatoplantilla
	 * @param idposicioncambiaria
	 * @param rubro
	 * @param texto
	 * @param tiposigno
	 * @param estado
	 */
	public PlantillaCalculoTableDTO(String id, TipoDatoPlantilla tipodatoplantilla, Integer idposicioncambiaria,
			String rubro, String texto, TipoSigno tiposigno, Boolean estado, String tipodatoplantilladescripcion, String tiposignodescripcion) {
		super(id, tipodatoplantilla, idposicioncambiaria, rubro, texto, tiposigno, estado);
		this.tipodatoplantilladescripcion= tipodatoplantilladescripcion;
		this.tiposignodescripcion=tiposignodescripcion;
	}
	
	
	
}

package pe.grupobbva.alcon.mantenimiento.dto.table;

import java.math.BigDecimal;

import lombok.Data;
import pe.grupobbva.alcon.mantenimiento.entity.DetalleCuadreDiario;
import pe.grupobbva.alcon.mantenimiento.entity.TipoDatoPlantilla;
import pe.grupobbva.alcon.mantenimiento.entity.TipoSigno;

@Data
public class DetallePlantillaCalculoTableDTO extends PlantillaCalculoTableDTO{
	private BigDecimal valor;

	public DetallePlantillaCalculoTableDTO() {
		super();
	}

	public DetallePlantillaCalculoTableDTO(DetalleCuadreDiario entity) {
		this.valor = entity.getValorcuadre();
	}

	/**
	 * @param id
	 * @param tipodatoplantilla
	 * @param idposicioncambiaria
	 * @param rubro
	 * @param texto
	 * @param tiposigno
	 * @param estado
	 * @param tipodatoplantilladescripcion
	 * @param tiposignodescripcion
	 */
	public DetallePlantillaCalculoTableDTO(String id, TipoDatoPlantilla tipodatoplantilla, Integer idposicioncambiaria,
			String rubro, String texto, TipoSigno tiposigno, Boolean estado, String tipodatoplantilladescripcion,
			String tiposignodescripcion,BigDecimal valor) {
		super(id, tipodatoplantilla, idposicioncambiaria, rubro, texto, tiposigno, estado, tipodatoplantilladescripcion,
				tiposignodescripcion);
		this.valor=valor;
	}
	
}

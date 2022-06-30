package pe.grupobbva.alcon.mantenimiento.dto;

import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;

import lombok.Data;
import pe.grupobbva.alcon.mantenimiento.dto.util.AbstractDTO;

import pe.grupobbva.alcon.mantenimiento.entity.PlantillaCalculo;
import pe.grupobbva.alcon.mantenimiento.entity.TipoDatoPlantilla;
import pe.grupobbva.alcon.mantenimiento.entity.TipoSigno;

@Data
public class PlantillaCalculoDTO extends AbstractDTO<PlantillaCalculo> {
	
	private TipoDatoPlantilla tipodatoplantilla;
	private Integer idposicioncambiaria;
	private String rubro;
	private String texto;
	private TipoSigno tiposigno;
	private Boolean estado;
	private Integer codigoestado;
	
	public PlantillaCalculoDTO() {
		super();
	}

	public PlantillaCalculoDTO(PlantillaCalculo entity) {
		super(entity);
		this.tipodatoplantilla=entity.getTipodatoplantilla();
		this.idposicioncambiaria=entity.getIdposicioncambiaria();
		this.rubro=entity.getRubro();
		this.texto=entity.getTexto();
		this.tiposigno=entity.getTiposigno();
		this.estado=entity.getEstado();
	}

	@Override
	public PlantillaCalculo fromDTO(PlantillaCalculo entity) {
		if (entity == null) {
			entity = new PlantillaCalculo();
		}
		if(tipodatoplantilla!=null) {
			entity.setTipodatoplantilla(this.tipodatoplantilla);
		}
		
		if(idposicioncambiaria!=null) {
			entity.setIdposicioncambiaria(this.idposicioncambiaria);
		}
		
		if(rubro!=null) {
			entity.setRubro(this.rubro);
		}
		if(texto!=null) {
			entity.setTexto(this.texto);
		}
		
		if(tiposigno!=null) {
			entity.setTiposigno(this.tiposigno);
		}
		
		if(estado!=null) {
			entity.setEstado(this.estado);
		}
		
		if(codigoestado!=null) {
			entity.setCodigoestado(this.codigoestado);
		}
		return entity;
	}
	
	@Override
	public void preactualizar() {
		super.preactualizar();
	}

	public PlantillaCalculoDTO(String id,TipoDatoPlantilla tipodatoplantilla, Integer idposicioncambiaria, String rubro,
			String texto, TipoSigno tiposigno, Boolean estado) {
		super(id);
		this.tipodatoplantilla = tipodatoplantilla;
		this.idposicioncambiaria = idposicioncambiaria;
		this.rubro = rubro;
		this.texto = texto;
		this.tiposigno = tiposigno;
		this.estado = estado;
	}
	

}

package pe.grupobbva.alcon.mantenimiento.service;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.UploadCargaAnexoOchoDTO;
import pe.grupobbva.alcon.mantenimiento.dto.UploadCargaDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.ReporteSearch;
import pe.grupobbva.alcon.mantenimiento.dto.table.CuadreAnexoOchoTableDTO;
import pe.grupobbva.alcon.mantenimiento.entity.CuadreAnexoOcho;

public interface CuadreAnexoOchoService extends AbstractService<CuadreAnexoOcho>{

	public DatatableDTO<CuadreAnexoOchoTableDTO> search(ReporteSearch reporteSearch);
	public void generar (UploadCargaAnexoOchoDTO uploadCarga);
	
}

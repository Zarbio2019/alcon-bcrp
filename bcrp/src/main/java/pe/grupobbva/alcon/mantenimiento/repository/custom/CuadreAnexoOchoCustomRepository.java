package pe.grupobbva.alcon.mantenimiento.repository.custom;


import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.UploadCargaAnexoOchoDTO;
import pe.grupobbva.alcon.mantenimiento.dto.UploadCargaDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.ReporteSearch;
import pe.grupobbva.alcon.mantenimiento.dto.table.CuadreAnexoOchoTableDTO;

public interface CuadreAnexoOchoCustomRepository {
	
	public DatatableDTO<CuadreAnexoOchoTableDTO> search(ReporteSearch reporteSearch);
	public void generar(UploadCargaAnexoOchoDTO uploadCarga);
	
}

package pe.grupobbva.alcon.mantenimiento.service;

import pe.grupobbva.alcon.mantenimiento.dto.report.DetalleAnexoOchoExcelDTO;
import pe.grupobbva.alcon.mantenimiento.dto.util.TablaDinamica;
import pe.grupobbva.alcon.mantenimiento.entity.DetalleAnexoOcho;

public interface DetalleAnexoOchoService extends AbstractService<DetalleAnexoOcho>{

	public TablaDinamica<DetalleAnexoOchoExcelDTO> generarexcel(String id);
	
	
}

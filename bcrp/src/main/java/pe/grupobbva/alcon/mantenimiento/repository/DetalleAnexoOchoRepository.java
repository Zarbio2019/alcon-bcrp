package pe.grupobbva.alcon.mantenimiento.repository;

import pe.grupobbva.alcon.mantenimiento.dto.report.DetalleAnexoOchoExcelDTO;
import pe.grupobbva.alcon.mantenimiento.dto.util.TablaDinamica;
import pe.grupobbva.alcon.mantenimiento.entity.DetalleAnexoOcho;
import pe.grupobbva.alcon.mantenimiento.repository.custom.DetalleAnexoOchoCustomRepository;

public interface DetalleAnexoOchoRepository extends AbstractRepository<DetalleAnexoOcho>, DetalleAnexoOchoCustomRepository{

	public TablaDinamica<DetalleAnexoOchoExcelDTO> getExcel(String id);
	
}

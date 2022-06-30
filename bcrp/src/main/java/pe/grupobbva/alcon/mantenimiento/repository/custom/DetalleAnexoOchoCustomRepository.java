package pe.grupobbva.alcon.mantenimiento.repository.custom;

import pe.grupobbva.alcon.mantenimiento.dto.report.DetalleAnexoOchoExcelDTO;
import pe.grupobbva.alcon.mantenimiento.dto.util.TablaDinamica;

public interface DetalleAnexoOchoCustomRepository {

	public TablaDinamica<DetalleAnexoOchoExcelDTO> getExcel(String id);
}

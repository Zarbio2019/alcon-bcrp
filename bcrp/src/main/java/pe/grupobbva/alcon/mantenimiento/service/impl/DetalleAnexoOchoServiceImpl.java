package pe.grupobbva.alcon.mantenimiento.service.impl;

import org.springframework.stereotype.Service;

import pe.grupobbva.alcon.mantenimiento.dto.report.DetalleAnexoOchoExcelDTO;
import pe.grupobbva.alcon.mantenimiento.dto.util.TablaDinamica;
import pe.grupobbva.alcon.mantenimiento.entity.DetalleAnexoOcho;
import pe.grupobbva.alcon.mantenimiento.repository.DetalleAnexoOchoRepository;
import pe.grupobbva.alcon.mantenimiento.service.DetalleAnexoOchoService;

@Service
public class DetalleAnexoOchoServiceImpl extends AbstractServiceImpl<DetalleAnexoOcho> implements DetalleAnexoOchoService{

	@Override
	public TablaDinamica<DetalleAnexoOchoExcelDTO> generarexcel(String id) {
		return ((DetalleAnexoOchoRepository) repository).getExcel(id);
	}


}

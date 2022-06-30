package pe.grupobbva.alcon.mantenimiento.service.impl;

import org.springframework.stereotype.Service;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.UploadCargaAnexoOchoDTO;
import pe.grupobbva.alcon.mantenimiento.dto.UploadCargaDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.ReporteSearch;
import pe.grupobbva.alcon.mantenimiento.dto.table.CuadreAnexoOchoTableDTO;
import pe.grupobbva.alcon.mantenimiento.entity.CuadreAnexoOcho;
import pe.grupobbva.alcon.mantenimiento.repository.CuadreAnexoOchoRepository;
import pe.grupobbva.alcon.mantenimiento.service.CuadreAnexoOchoService;

@Service
public class CuadreAnexoOchoServiceImpl extends AbstractServiceImpl<CuadreAnexoOcho> implements CuadreAnexoOchoService{

	@Override
	public DatatableDTO<CuadreAnexoOchoTableDTO> search(ReporteSearch reporteSearch) {
		return ((CuadreAnexoOchoRepository)repository).search(reporteSearch);
	}

	@Override
	public void generar(UploadCargaAnexoOchoDTO uploadCarga) {
		
		((CuadreAnexoOchoRepository)repository).generar(uploadCarga);
		
	}

}

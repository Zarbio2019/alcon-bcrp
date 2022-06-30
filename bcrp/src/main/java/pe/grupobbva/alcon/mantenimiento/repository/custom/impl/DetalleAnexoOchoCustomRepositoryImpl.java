package pe.grupobbva.alcon.mantenimiento.repository.custom.impl;

import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import pe.grupobbva.alcon.mantenimiento.dto.report.DetalleAnexoOchoExcelDTO;
import pe.grupobbva.alcon.mantenimiento.dto.util.TablaDinamica;
import pe.grupobbva.alcon.mantenimiento.repository.custom.DetalleAnexoOchoCustomRepository;

public class DetalleAnexoOchoCustomRepositoryImpl implements DetalleAnexoOchoCustomRepository{

	@Autowired
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public TablaDinamica<DetalleAnexoOchoExcelDTO> getExcel(String id) {
		TablaDinamica<DetalleAnexoOchoExcelDTO> consultaDinamica = new TablaDinamica<DetalleAnexoOchoExcelDTO>();
		
		List<DetalleAnexoOchoExcelDTO> resultados = 
				em.createNamedStoredProcedureQuery("SP_BCR_ANEXO_OCHO_DETALLE")
				.setParameter("P_ID_CUADRE_ANEXO_OCHO", id)
				.getResultList();
		
		 consultaDinamica.setColumnas(new DetalleAnexoOchoExcelDTO().headExcel());
		 consultaDinamica.setRegistros(resultados);
		return consultaDinamica;
	}

}

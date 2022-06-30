package pe.grupobbva.alcon.mantenimiento.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteCuadreDiarioC2ExcelDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.ReporteSearch;
import pe.grupobbva.alcon.mantenimiento.dto.util.TablaDinamica;
import pe.grupobbva.alcon.mantenimiento.repository.ReporteCuadreDiarioC2Repository;
import pe.grupobbva.alcon.mantenimiento.service.ReporteCuadreDiarioC2Service;

@Service
public class ReporteCuadreDiarioC2ServiceImpl implements ReporteCuadreDiarioC2Service {

	@Autowired
	private ReporteCuadreDiarioC2Repository reporteCuadreDiarioC2Repository;
	
	@Override
	public TablaDinamica<ReporteCuadreDiarioC2ExcelDTO> getExcelReport(ReporteSearch reporteSearch) {
		return reporteCuadreDiarioC2Repository.getExcelReport(reporteSearch);
	}

}

package pe.grupobbva.alcon.mantenimiento.repository.custom.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

import pe.grupobbva.alcon.core.utils.Utils;
import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.SaldoContableSearch;
import pe.grupobbva.alcon.mantenimiento.dto.table.SaldoContableTableDTO;
import pe.grupobbva.alcon.mantenimiento.entity.Carga;
import pe.grupobbva.alcon.mantenimiento.repository.custom.SaldoContableCustomRepository;

public class SaldoContableCustomRepositoryImpl implements SaldoContableCustomRepository {

	@Autowired
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public DatatableDTO<SaldoContableTableDTO> search(SaldoContableSearch saldoContableSearch) {
		
		List<SaldoContableTableDTO> resultados = 
				em.createNamedStoredProcedureQuery("SP_BCR_SALDOCONTABLE_LISTAR")
				.setParameter("P_FECHA", saldoContableSearch.getFecha())
				.getResultList();
		
		return new DatatableDTO<>(
				saldoContableSearch.getDraw(), 
					Long.valueOf(resultados != null ? resultados.size(): 0 ),
					Utils.paginador(resultados, saldoContableSearch)
				);

	}
	
	@Override
	public void saldoContableActualizarEstadoGrupo(Carga carga, Integer codigoestado) {
		
		 em.createNamedStoredProcedureQuery("SP_BCR_SALDOCONTABLE_UPDESTGRP")
		   .setParameter("P_FECHA", carga.getFecha())
		   .setParameter("P_CODIGOESTADO", codigoestado)
		   .setParameter("P_USUARIOMODIFICACION", carga.getActualizadoPor())
		   .execute();
		
	}

}

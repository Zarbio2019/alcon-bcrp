package pe.grupobbva.alcon.mantenimiento.quartz;

import org.quartz.Job;

public enum ExecuteJobType {

	JOBCARGAARCHIVO(ExecuteJob.class,"0 00 20 * * ? *");
	
	private final Class<? extends Job> clazz;
	private final String expresionProgramacion;
	
	private ExecuteJobType(final Class<? extends Job> clazz,final String expresionProgramacion) {
		this.clazz = clazz;
		this.expresionProgramacion = expresionProgramacion;
	}

	/**
	 * @return the clazz
	 */
	public Class<? extends Job> getClazz() {
		return clazz;
	}

	/**
	 * @return the expresionProgramacion
	 */
	public String getExpresionProgramacion() {
		return expresionProgramacion;
	}
}

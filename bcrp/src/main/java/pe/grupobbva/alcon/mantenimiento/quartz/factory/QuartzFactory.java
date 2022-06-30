package pe.grupobbva.alcon.mantenimiento.quartz.factory;

import pe.grupobbva.alcon.mantenimiento.quartz.bean.JobConfig;

public interface QuartzFactory {
	
	/**
     * Crea las instancias Quartz para la ejecucion del trabajo segun
     * la programacion
     * 
     * @param jobBatch, trabajo a crear
     */
    void createJob(JobConfig jobBatch);
    void inicializarJobs();

}

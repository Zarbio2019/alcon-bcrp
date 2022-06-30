package pe.grupobbva.alcon.mantenimiento.quartz.factory;

public interface JobInstanceService {
	
	/**
     * Ejecuta un trabajo
     * @param jobNameBean, nombre del trabajo
     * @param codigoRegistro, codigo de registro del usuario que realiza la invocacion o programacion
     */
    void execute(String jobNameBean, String codigoRegistro);

}

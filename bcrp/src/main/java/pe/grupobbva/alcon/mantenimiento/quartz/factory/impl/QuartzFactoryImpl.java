package pe.grupobbva.alcon.mantenimiento.quartz.factory.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import pe.grupobbva.alcon.mantenimiento.quartz.ExecuteJobType;
import pe.grupobbva.alcon.mantenimiento.quartz.bean.JobConfig;
import pe.grupobbva.alcon.mantenimiento.quartz.factory.QuartzFactory;

@Component("quartzFactory")
@Profile("!dev")
public class QuartzFactoryImpl implements QuartzFactory {
	
	@Resource(name = "quartzScheduler")
	private Scheduler scheduler;
	
	@Value("${spring.profiles.active}")
	private String scope;
	
	protected final Logger log = LogManager.getLogger(getClass());

	@Override
	public void createJob(JobConfig jobConfig) {
		
		
		String name = jobConfig.getJobName() + "Cron";
		String cronSchedule = jobConfig.getExpresionProgramacion();

		log.info("createJob : {} , expresion: {}", jobConfig.getJobName(), jobConfig.getExpresionProgramacion());
		
		JobDataMap jobDataMap = new JobDataMap();
		jobDataMap.put("jobNameBean", jobConfig.getJobName());
		
		
		JobKey jobKey = new JobKey(jobConfig.getJobName(), jobConfig.getGroupName());
		JobDetail jobDetail = null;
		
		ExecuteJobType executeJobType=ExecuteJobType.valueOf(jobConfig.getJobName());
		JobBuilder builder = JobBuilder.newJob(executeJobType.getClazz());
		jobDetail=builder.withIdentity(jobKey).setJobData(jobDataMap).build();
		
		TriggerKey triggerKey = TriggerKey.triggerKey(name, jobConfig.getGroupName());
		Trigger cronTrigger = TriggerBuilder
				.newTrigger()
				.withIdentity(triggerKey)
				.startNow()
				.withSchedule(CronScheduleBuilder.cronSchedule(cronSchedule))
				.build();

		try {

			scheduler.deleteJob(jobKey);
			scheduler.scheduleJob(jobDetail, cronTrigger);

		} catch (Exception e) {
			log.error(e);
		}
	}

	@Override
	public void inicializarJobs() {
		//Job para la carga automatica, corre cada 10 minutos desde las 9:00 hasta las 23:50.
		log.info("Inicializando jobCargaArchivo");
		
		for(ExecuteJobType job : ExecuteJobType.values()) {
			JobConfig jobConfig = new JobConfig();
			jobConfig.setJobName(job.name());
			jobConfig.setExpresionProgramacion(job.getExpresionProgramacion());
			createJob(jobConfig);
		}
		
	}

	/**
	 * Al crearse la instancia, se crear los trabajos de manera dinamica
	 */
	@PostConstruct
	public void init() {
			inicializarJobs();
	}

}

package pe.grupobbva.alcon.mantenimiento.quartz.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.Map;

public class JobConfig implements Serializable {

	private static final long serialVersionUID = 1L;
	private String dayOfMonth;
	private String month;
	private String year;
	private String hour;
	private String minute;
	private String jobName;
	private String groupName;
	private String jobId;
	private String codigoRegistro;
	private Map<String, Object> props;
	private String expresionProgramacion;

	public String getExpresionProgramacion() {
		return expresionProgramacion;
	}

	public void setExpresionProgramacion(String expresionProgramacion) {
		this.expresionProgramacion = expresionProgramacion;
	}

	public JobConfig() {
		super();
	}

	public String getDayOfMonth() {
		return dayOfMonth;
	}

	public void setDayOfMonth(String dayOfMonth) {
		this.dayOfMonth = dayOfMonth;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public String getMinute() {
		return minute;
	}

	public void setMinute(String minute) {
		this.minute = minute;
	}

	public Map<String, Object> getProps() {
		return props;
	}

	public void setProps(Map<String, Object> props) {
		this.props = props;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public String getCodigoRegistro() {
		return codigoRegistro;
	}

	public void setCodigoRegistro(String codigoRegistro) {
		this.codigoRegistro = codigoRegistro;
	}

	public JobConfig putObject(String key, Object value) {
		props.put(key, value);
		return this;
	}

	public JobConfig put(String key, BigInteger value) {
		return putObject(key, value);
	}

	public JobConfig put(String key, BigDecimal value) {
		return putObject(key, value);
	}

	public JobConfig put(String key, Long value) {
		return putObject(key, value);
	}

	public JobConfig put(String key, Integer value) {
		return putObject(key, value);
	}

	public JobConfig put(String key, Date value) {
		return putObject(key, value);
	}

	public JobConfig put(String key, Boolean value) {
		return putObject(key, value);
	}

	public JobConfig put(String key, String value) {
		return putObject(key, value);
	}

	@SuppressWarnings("unchecked")
	public <T> T get(String key) {
		return (T) props.get(key);
	}

	public String getString(String key) {
		return (String) props.get(key);
	}

	public BigInteger getBigInteger(String key) {
		return (BigInteger) props.get(key);
	}

	public BigDecimal getBigDecimal(String key) {
		return (BigDecimal) props.get(key);
	}

	public Long getLong(String key) {
		return (Long) props.get(key);
	}

	public Integer getInteger(String key) {
		return (Integer) props.get(key);
	}

	public Date getDate(String key) {
		return (Date) props.get(key);
	}

	public Boolean getBoolean(String key) {
		return (Boolean) props.get(key);
	}

}

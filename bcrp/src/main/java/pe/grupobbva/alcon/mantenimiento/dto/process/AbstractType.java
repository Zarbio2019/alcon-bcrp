package pe.grupobbva.alcon.mantenimiento.dto.process;

public abstract class AbstractType {

	private String key;
	protected Long rownum;
	
	public Boolean test() {
		return true;
	}

	public Boolean validar() {
		return true;
	}

	public Boolean agrupar() {
		return false;
	}

	public String getKey() {
		return key;
	}
	
	
	public void merge(AbstractType row) {

	}

	public  void loadKey() {
		this.key = this.rownum.toString();
	}

	public Long getRownum() {
		return rownum;
	}

	public void setRownum(Long rownum) {
		this.rownum = rownum;
	}

	public void setKey(String key) {
		this.key = key;
	}

	


	
	


	
	

}

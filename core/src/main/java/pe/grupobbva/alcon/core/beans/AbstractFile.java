package pe.grupobbva.alcon.core.beans;

import java.util.HashMap;

public abstract class AbstractFile {

	private String filename;
	private String contenttype;
	private HashMap<String, String> metadata;
	
	/**
	 * @param contenttype
	 * @param metadata
	 */
	protected AbstractFile(String contenttype, HashMap<String, String> metadata) {
		super();
		this.contenttype = contenttype;
		this.metadata = metadata;
	}

	/**
	 * @return the filename
	 */
	public String getFilename() {
		return filename;
	}

	/**
	 * @param filename the filename to set
	 */
	public void setFilename(String filename) {
		this.filename = filename;
	}

	/**
	 * @return the contenttype
	 */
	public String getContenttype() {
		return contenttype;
	}

	/**
	 * @param contenttype the contenttype to set
	 */
	public void setContenttype(String contenttype) {
		this.contenttype = contenttype;
	}

	/**
	 * @return the metadata
	 */
	public HashMap<String, String> getMetadata() {
		return metadata;
	}

	/**
	 * @param metadata the metadata to set
	 */
	public void setMetadata(HashMap<String, String> metadata) {
		this.metadata = metadata;
	}
	
}

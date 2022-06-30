package pe.grupobbva.alcon.core.beans;

import java.io.OutputStream;
import java.util.HashMap;

public class FileOutputType extends AbstractFile {
	

	protected FileOutputType(String contenttype, HashMap<String, String> metadata) {
		super(contenttype, metadata);
	}

	public FileOutputType(OutputStream os, String contenttype,HashMap<String, String> metadata) {
		super(contenttype, metadata);
		this.content=os;
	}

	/** Contenido */
	private OutputStream content;

	public OutputStream getContent() {
		return content;
	}

	public void setContent(OutputStream content) {
		this.content = content;
	}

	
	
	
}

package pe.grupobbva.alcon.mantenimiento.endpoint.util;

import java.util.Map;

import org.springframework.http.HttpStatus;

import lombok.Data;


public @Data class ApiError {
	
	 private HttpStatus status;
	    private String message;
	    private Map<String, String> errors;
	 
	    public ApiError(HttpStatus status, String message, Map<String, String> errors) {
	        super();
	        this.status = status;
	        this.message = message;
	        this.errors = errors;
	    }
	 
	   
	    
	    
	    
}

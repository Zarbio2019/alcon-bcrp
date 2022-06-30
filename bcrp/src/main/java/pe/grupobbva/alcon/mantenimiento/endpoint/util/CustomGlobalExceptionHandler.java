package pe.grupobbva.alcon.mantenimiento.endpoint.util;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

	private static final Logger log = LogManager.getLogger();
	
    // error handle for @Valid
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status, WebRequest request) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", new Date());
        body.put("status", status.value());

        log.info("Error");
        
        //Get all errors
        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(x -> x.getDefaultMessage())
                .collect(Collectors.toList());

        body.put("errors", errors);

        return new ResponseEntity<>(body, headers, status);

    }
    
    @ExceptionHandler({ ConstraintViolationException.class})
    public ResponseEntity<ApiError> handleConstraintViolation(
    		ConstraintViolationException ex, WebRequest request) {
    		log.info("Error");
    		Map<String, String> errors = new HashMap<>();
    		
    		for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
    			errors.put(violation.getPropertyPath().toString(),violation.getMessage());
			}
    		
     
        	ApiError apiError = 
          new ApiError(HttpStatus.BAD_REQUEST, "Error de validación", errors);
        return new ResponseEntity<ApiError>(
        		apiError, new HttpHeaders(), apiError.getStatus());
    }
    
    @ExceptionHandler({ ValidationException.class})
    public ResponseEntity<ApiError> handleValidarionViolation(
    		ValidationException ex, WebRequest request) {
    		
    		log.info("Error");
    	
    		Map<String, String> errors = new HashMap<>();
    		
    		errors.put(ex.getCause().getMessage() ,ex.getMessage());
    		
     
        	ApiError apiError = 
          new ApiError(HttpStatus.BAD_REQUEST, "Error de validación", errors);
        return new ResponseEntity<ApiError>(
        		apiError, new HttpHeaders(), apiError.getStatus());
    }

}


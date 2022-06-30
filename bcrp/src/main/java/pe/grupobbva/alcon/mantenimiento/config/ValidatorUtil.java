package pe.grupobbva.alcon.mantenimiento.config;

import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.ValidationException;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public abstract class ValidatorUtil {
public static <U>void validateEntity(U	entity) throws ConstraintViolationException, ValidationException {
		
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		
		// Create a bean validator and check for issues.
		Set<ConstraintViolation<Object>> violations = validator.validate(entity);
		if (!violations.isEmpty()) {
			throw new ConstraintViolationException(new HashSet<ConstraintViolation<?>>(violations));
		}
	}

	
	public static void validateMessage(String message, String description)	throws ConstraintViolationException, ValidationException {
		throw new ValidationException(description, new Throwable(message));
	}
}

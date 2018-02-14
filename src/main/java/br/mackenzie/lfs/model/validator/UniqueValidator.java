package br.mackenzie.lfs.model.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import br.mackenzie.lfs.model.annotations.Unique;
import br.mackenzie.lfs.util.FieldValueExists;

public class UniqueValidator implements ConstraintValidator<Unique, Object>{

	private String fieldName;
	private Class<?> entityClass;
	
	private FieldValueExists existsService;
	
	@Autowired
	public UniqueValidator(FieldValueExists existsService) {
		this.existsService = existsService;
	}
	
	@Override
	public void initialize(Unique unique) {
		this.fieldName = unique.fieldName();
		this.entityClass = unique.entityClass();
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		return !this.existsService.fieldValueExists(fieldName, value, entityClass);
	}

}

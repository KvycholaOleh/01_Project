package ua.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.entity.TypeDisplay;
import ua.service.TypeDisplayService;

public class TypeDisplayValidator implements Validator{
	
	private final TypeDisplayService typeDisplayService;

	public TypeDisplayValidator(TypeDisplayService typeDisplayService) {
		this.typeDisplayService = typeDisplayService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return TypeDisplay.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		TypeDisplay typeDisplay = (TypeDisplay) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "Can`t be empty");
		if(typeDisplayService.findOne(typeDisplay.getName())!=null){
			errors.rejectValue("name", "", "Already exist");
		}
		
	}

}

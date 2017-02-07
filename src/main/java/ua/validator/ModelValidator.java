package ua.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.entity.Model;
import ua.service.ModelService;

public class ModelValidator implements Validator{
	
	private final ModelService modelService;

	public ModelValidator(ModelService modelService) {
		this.modelService = modelService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return Model.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Model model = (Model) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "Can`t be empty");
		if(modelService.findOne(model.getName())!=null){
			errors.rejectValue("name", "", "Already exist");
		}
		
	}

}

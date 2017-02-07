package ua.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.entity.Os;
import ua.service.OsService;

public class OsValidator implements Validator{
	
	private final OsService osService;

	public OsValidator(OsService osService) {
		this.osService = osService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return Os.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Os os = (Os) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "Can`t be empty");
		if(osService.findOne(os.getName())!=null){
			errors.rejectValue("name", "", "Already exist");
		}
		
	}

}

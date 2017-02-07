package ua.validator;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import dto.form.ItemForm;

public class ItemValidator implements Validator {
	
	private final static Pattern PATTERN = Pattern.compile("^([0-9]{1,18}\\.[0-9]{0,2})|([0-9]{1,18}\\,[0-9]{0,2}|([0-9]{1,18}))$");

	@Override
	public boolean supports(Class<?> clazz) {
		return ItemForm.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ItemForm item = (ItemForm) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "", "Can`t be empty");
		if(!PATTERN.matcher(item.getPrice()).matches()){
			errors.rejectValue("price", "", "Wrong format, only 2 digits after separator");
		}
		if(!PATTERN.matcher(item.getBatteryCapacity()).matches()){
			errors.rejectValue("batteryCapacity", "", "Can`t be empty");
		}
		if(!PATTERN.matcher(item.getDisplaySize()).matches()){
			errors.rejectValue("displaySize", "", "Can`t be empty");
		}
		if(!PATTERN.matcher(item.getCamera()).matches()){
			errors.rejectValue("camera", "", "Can`t be empty");
		}
		
		
	}

}

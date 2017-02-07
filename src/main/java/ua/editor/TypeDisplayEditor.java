package ua.editor;

import java.beans.PropertyEditorSupport;

import ua.entity.TypeDisplay;
import ua.service.TypeDisplayService;

public class TypeDisplayEditor extends PropertyEditorSupport{
	
	private TypeDisplayService typeDisplayService;

	public TypeDisplayEditor(TypeDisplayService typeDisplayService) {
		this.typeDisplayService = typeDisplayService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		TypeDisplay typeDisplay = typeDisplayService.findOne(Integer.valueOf(text));
		setValue(typeDisplay);
	}
	
	

}

package ua.editor;

import java.beans.PropertyEditorSupport;

import ua.entity.Model;
import ua.service.ModelService;

public class ModelEditor extends PropertyEditorSupport{
	
	private ModelService modelService;

	public ModelEditor(ModelService modelService) {
		this.modelService = modelService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Model model = modelService.findOne(Integer.valueOf(text));
		setValue(model);
	}
	
	
	
	

}

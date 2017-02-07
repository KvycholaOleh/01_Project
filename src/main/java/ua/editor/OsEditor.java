package ua.editor;

import java.beans.PropertyEditorSupport;

import ua.entity.Os;
import ua.service.OsService;

public class OsEditor extends PropertyEditorSupport{
	
	private OsService osService;

	public OsEditor(OsService osService) {
		this.osService = osService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Os os = osService.findOne(Integer.valueOf(text));
		setValue(os);
	}
	
	

}

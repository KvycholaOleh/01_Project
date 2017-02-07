package ua.service;

import java.util.List;

import dto.form.ItemForm;
import ua.entity.Item;

public interface ItemService {

	Item findOne (int id);
	 
	 List<Item> findAll();
	 
	 void delete (int id);

	void save(ItemForm itemForm);
	
	ItemForm findForm(int id);
}

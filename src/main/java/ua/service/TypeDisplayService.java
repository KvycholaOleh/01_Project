package ua.service;

import java.util.List;

import ua.entity.TypeDisplay;

public interface TypeDisplayService {

	
	TypeDisplay findOne (int id);
	 
	 List<TypeDisplay> findAll();
	 
	 void save(TypeDisplay color);
	 
	 void delete (int id);

	TypeDisplay findOne(String name);
}

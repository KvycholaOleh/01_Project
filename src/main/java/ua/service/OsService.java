package ua.service;

import java.util.List;

import ua.entity.Os;

public interface OsService {

	
	Os findOne (int id);
	 
	 List<Os> findAll();
	 
	 void save(Os color);
	 
	 void delete (int id);

	Os findOne(String name);
}

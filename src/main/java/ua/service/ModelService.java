package ua.service;

import java.util.List;

import ua.entity.Model;

public interface ModelService {

	Model findOne (int id);
	 
	 List<Model> findAll();
	 
	 void save(Model color);
	 
	 void delete (int id);

	Model findOne(String name);
}

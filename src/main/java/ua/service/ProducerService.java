package ua.service;

import java.util.List;

import ua.entity.Producer;

public interface ProducerService {

	
	Producer findOne (int id);
	 
	 List<Producer> findAll();
	 
	 void save(Producer color);
	 
	 void delete (int id);
	 
	 Producer findByName(String name);
}

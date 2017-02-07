package ua.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.entity.TypeDisplay;
import ua.repository.TypeDisplayRepository;
import ua.service.TypeDisplayService;

@Service
public class TypeDisplayServiceImpl implements TypeDisplayService{
	
	@Autowired
	private TypeDisplayRepository typeDisplayRepository;

	@Override
	public TypeDisplay findOne(int id) {
		return typeDisplayRepository.findOne(id);
	}

	@Override
	public List<TypeDisplay> findAll() {
		return typeDisplayRepository.findAll();
	}

	@Override
	public void save(TypeDisplay typeDisplay) {
		typeDisplayRepository.save(typeDisplay);
	}

	@Override
	public void delete(int id) {
		typeDisplayRepository.delete(id);
	}

	@Override
	public TypeDisplay findOne(String name) {
		return typeDisplayRepository.findByName(name);
	}
	

}

package ua.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.entity.Color;
import ua.repository.ColorRepository;
import ua.service.ColorService;

@Service
public class ColorServiceImpl implements ColorService{

	@Autowired
	private ColorRepository colorRepository;

	@Override
	@Transactional(readOnly = true)
	public Color findOne(int id) {
		return colorRepository.findOne(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Color> findAll() {
		return colorRepository.findAll();
	}

	@Override
	public void save(Color color) {
		colorRepository.save(color);
	}

	@Override
	public void delete(int id) {
		colorRepository.delete(id);
	}

	@Override
	public Color findOne(String name) {
		return colorRepository.findByName(name);
	}
}

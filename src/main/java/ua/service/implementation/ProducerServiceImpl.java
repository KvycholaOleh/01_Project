package ua.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.entity.Producer;
import ua.repository.ProducerRepository;
import ua.service.ProducerService;

@Service
public class ProducerServiceImpl implements ProducerService{
	
	@Autowired
	private ProducerRepository producerRepository;

	@Override
	@Transactional(readOnly = true)
	public Producer findOne(int id) {
		return producerRepository.findOne(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Producer> findAll() {
		return producerRepository.findAll();
	}

	@Override
	public void save(Producer producer) {
		producerRepository.save(producer);
	}

	@Override
	public void delete(int id) {
		producerRepository.delete(id);
	}

	@Override
	public Producer findByName(String name) {
		return producerRepository.findByName(name);
	}
	
	

}

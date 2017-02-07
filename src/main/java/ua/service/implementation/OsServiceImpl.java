package ua.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.entity.Os;
import ua.repository.OsRepository;
import ua.service.OsService;

@Service
public class OsServiceImpl implements OsService{
	
	@Autowired
	private OsRepository osRepository;

	@Override
	@Transactional(readOnly = true)
	public Os findOne(int id) {
		return osRepository.findOne(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Os> findAll() {
		return osRepository.findAll();
	}

	@Override
	public void save(Os os) {
		osRepository.save(os);
	}

	@Override
	public void delete(int id) {
		osRepository.delete(id);
	}

	@Override
	public Os findOne(String name) {
		return osRepository.findByName(name);
	}

}

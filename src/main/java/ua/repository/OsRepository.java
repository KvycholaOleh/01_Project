package ua.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.entity.Os;

public interface OsRepository extends JpaRepository<Os, Integer>{

	Os findByName(String name);

}

package ua.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.entity.TypeDisplay;

public interface TypeDisplayRepository extends JpaRepository<TypeDisplay, Integer>{

	TypeDisplay findByName(String name);

}

package ua.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.entity.Producer;

public interface ProducerRepository extends JpaRepository<Producer, Integer>{
	@Query("SELECT ss FROM Producer ss LEFT JOIN FETCH ss.country WHERE ss.id=:id")
	Producer findOne(@Param("id")int id);
	
	Producer findByName(String name);
}

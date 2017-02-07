package ua.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Integer>{
	
	@Query("SELECT r FROM Item r JOIN FETCH r.producer p LEFT JOIN FETCH r.model LEFT JOIN FETCH r.color LEFT JOIN FETCH r.os LEFT JOIN FETCH r.typeDisplay LEFT JOIN FETCH p.country")
	List<Item> findAll();
	
	
	@Query("SELECT ss FROM Item ss LEFT JOIN FETCH ss.color LEFT JOIN FETCH ss.producer LEFT JOIN FETCH ss.model LEFT JOIN FETCH ss.os LEFT JOIN FETCH ss.typeDisplay WHERE ss.id=:id")
	Item findOne(@Param("id")int id);

}

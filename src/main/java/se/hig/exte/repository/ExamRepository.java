package se.hig.exte.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import se.hig.exte.model.Exam;

public interface ExamRepository extends CrudRepository<Exam, Long>{
	
	/*
	 * The CrudRepository interface is the Spring equivalent of DAO classes.
	 */
	
	List<Exam> findByName(String name);
	
	Exam findById(long id);
}

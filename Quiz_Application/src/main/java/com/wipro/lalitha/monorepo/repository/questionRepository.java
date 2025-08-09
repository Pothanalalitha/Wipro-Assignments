package com.wipro.lalitha.monorepo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wipro.lalitha.monorepo.entity.Category;
import com.wipro.lalitha.monorepo.entity.Question;

@Repository
public interface questionRepository extends JpaRepository<Question,Long> 
{

	@Query(value ="SELECT * FROM question q WHERE q.category = :category AND q.difficulty_level = :difficultyLevel ORDER BY RAND() LIMIT 3",nativeQuery=true)
	List<Question> findRandomQuestionsByCategoryAndLevel(String category, String difficultyLevel);
	
	List<Question> findByCategory(Category category);

	

}

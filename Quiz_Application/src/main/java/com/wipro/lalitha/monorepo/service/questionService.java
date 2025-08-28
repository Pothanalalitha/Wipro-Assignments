package com.wipro.lalitha.monorepo.service;

import java.util.List;

import com.wipro.lalitha.monorepo.entity.Category;
import com.wipro.lalitha.monorepo.entity.Question;

public interface questionService 
{

	Question save(Question question);

	List<Question> getQuestionByCategory(Category category);

	List<Question> getAllQuestions();

	Question patchUpdateQuestionById(Long id,Question question);

	void deleteQuestionById(Long id);
  
}

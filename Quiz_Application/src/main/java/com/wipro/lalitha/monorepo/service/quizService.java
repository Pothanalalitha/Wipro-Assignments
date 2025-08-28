package com.wipro.lalitha.monorepo.service;

import java.util.List;

import com.wipro.lalitha.monorepo.entity.QuestionWrapper;
import com.wipro.lalitha.monorepo.entity.Quiz;
import com.wipro.lalitha.monorepo.entity.Response;

public interface quizService 
{

	Quiz createQuiz(String category, String difficultyLevel, String response);

	List<QuestionWrapper> getQuizQuestions(Integer id);

	Integer caluclateResult(int id, List<Response> response);

}

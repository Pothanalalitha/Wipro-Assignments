package com.wipro.lalitha.monorepo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.lalitha.monorepo.entity.QuestionWrapper;
import com.wipro.lalitha.monorepo.entity.Quiz;
import com.wipro.lalitha.monorepo.entity.Response;
import com.wipro.lalitha.monorepo.service.quizService;
import com.wipro.lalitha.monorepo.service.quizServiceImpl;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api/v1/quiz")
public class quizController 
{
	private static final Logger logger = LoggerFactory.getLogger(quizController.class);
	@Autowired
  private quizService quizservice;
	
	@PostMapping("/create")
	public Quiz createQuiz(@RequestParam String category,@RequestParam String difficultyLevel,@RequestParam String response)
	{
		logger.info("Creating quiz with category={}, difficultyLevel={}", category, difficultyLevel);
		return quizservice.createQuiz(category,difficultyLevel,response);
	}
	
	@GetMapping("/getQuizById/{id}")
	public List<QuestionWrapper> getQuizQuestions(@PathVariable Integer id)
	{
		logger.info("Fetching quiz questions for quizId={}", id);
		return quizservice.getQuizQuestions(id);
	}
	@PostMapping("/submitQuiz/{id}")
	public Integer submitQuiz(@PathVariable int id,@RequestBody List<Response> response)
	{
		logger.info("Submitting quiz for quizId={}, responsesCount={}", id, response.size());
		return quizservice.caluclateResult(id,response);
	}
	
	
}

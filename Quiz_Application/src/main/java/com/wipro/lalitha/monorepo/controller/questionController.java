package com.wipro.lalitha.monorepo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.wipro.lalitha.monorepo.entity.Category;
import com.wipro.lalitha.monorepo.entity.Question;
import com.wipro.lalitha.monorepo.service.questionService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api/v1/question")
public class questionController 
{
	@Autowired
   private questionService questionservice;
	private static final Logger logger = LoggerFactory.getLogger(questionController.class);
	
	@PostMapping("/addQuestion")
	public Question addQuestion(@RequestBody Question question)
	{
		logger.info("Adding new question: {}", question);
		return questionservice.save(question);
	}
	@GetMapping("/getQuestionByCategory/{category}")
	public List<Question> getQuestionById(@PathVariable Category category)
	{
		logger.info("Fetching questions by category={}", category);
		return questionservice.getQuestionByCategory(category);
	}
	@GetMapping("/getAllQuestions")
	public List<Question> getAllQuestions()
	{
		logger.info("Fetching all questions");
		return questionservice.getAllQuestions();
	}
	@PatchMapping("/updateQuestionById/{id}")
	public Question patchUpdateQuestionById(@PathVariable Long id,@RequestBody Question question)
	{
		logger.info("Updating question id={} with details={}", id, question);
		return questionservice.patchUpdateQuestionById(id,question);
	}
	@DeleteMapping("/deleteQuestionById/{id}")
	public String deleteQuestionById(@PathVariable Long id)
	{
		questionservice.deleteQuestionById(id);
		return "Question Deleted Successfully";
	}
}

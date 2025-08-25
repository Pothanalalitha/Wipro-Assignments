package com.wipro.lalitha.monorepo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.wipro.lalitha.monorepo.entity.Question;
import com.wipro.lalitha.monorepo.entity.QuestionWrapper;
import com.wipro.lalitha.monorepo.entity.Quiz;
import com.wipro.lalitha.monorepo.entity.Response;
import com.wipro.lalitha.monorepo.repository.questionRepository;
import com.wipro.lalitha.monorepo.repository.quizRepository;

@Service
public class quizServiceImpl implements quizService 
{
	@Autowired
  private quizRepository quizrepository;
	@Autowired
	private questionRepository questionrepository;

	@Override
	public Quiz createQuiz(String category, String difficultyLevel, String response) 
	{
		List<Question> questions = questionrepository
                .findRandomQuestionsByCategoryAndLevel(category, difficultyLevel);
		Quiz quiz = new Quiz();
       quiz.setresponse(response);
        quiz.setQuestion(questions);

        return quizrepository.save(quiz);
		
		
	}

	@Override
	public List<QuestionWrapper> getQuizQuestions(Integer id) 
	{
		 Optional<Quiz> quiz = quizrepository.findById(id);
	        
	       List<Question> questionsFromDB = quiz.get().getQuestion();
	       
	        List<QuestionWrapper> questionsForUser = new ArrayList<>();
	        for(Question q : questionsFromDB){
	            QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
	            questionsForUser.add(qw);
	        }

	        return questionsForUser;
		
	}

	@Override
	public Integer caluclateResult(int id, List<Response> response) 
	{
		
		 Quiz quiz = quizrepository.findById(id).get();
	        List<Question> questions = quiz.getQuestion();
	        int rightAnswerScore = 0;

	        for (Response responses : response ) 
	        {
	            for (Question question : questions) 
	            {
	                if (question.getId() == responses.getId()) 
	                {
	                    if (question.getCorrectAnswer().equalsIgnoreCase(responses.getUserAnswer())) {
	                    	rightAnswerScore++;
	                    }
	                    break;
	                }
	            }
	        }

	        return rightAnswerScore;
	    }
	}

	

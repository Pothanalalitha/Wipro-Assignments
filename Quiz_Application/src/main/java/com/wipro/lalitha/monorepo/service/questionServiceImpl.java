package com.wipro.lalitha.monorepo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.lalitha.monorepo.entity.Category;
import com.wipro.lalitha.monorepo.entity.Question;
import com.wipro.lalitha.monorepo.repository.questionRepository;

@Service
public class questionServiceImpl implements questionService 
{
	@Autowired
  private questionRepository questionrepository;
	
	public class QuestionNotFoundException extends RuntimeException 
	{
	    public QuestionNotFoundException(String message) 
	    {
	        super(message);
	    }
	}

	@Override
	public Question save(Question question) 
	{
		
		return questionrepository.save(question);
	}

	@Override
	public List<Question> getQuestionByCategory(Category category)
	{
		
		return questionrepository.findByCategory(category);
		
				}

	@Override
	public List<Question> getAllQuestions() 
	{
		
		return questionrepository.findAll();
	}

	@Override
	public Question patchUpdateQuestionById(Long id,Question question) 
	{
		Question existedQuestion=questionrepository.findById(id).
				orElseThrow(()->new QuestionNotFoundException("Question Not Found With That"+id));
		if(question.getQuestionTitle()!=null)
		{
			existedQuestion.setQuestionTitle(question.getQuestionTitle());
		}
		if(question.getOption1()!=null)
		{
			existedQuestion.setOption1(question.getOption1());
		}
		if(question.getOption2()!=null)
		{
			existedQuestion.setOption2(question.getOption2());
		}
		if(question.getOption3()!=null)
		{
			existedQuestion.setOption3(question.getOption3());
		}
		if(question.getOption4()!=null)
		{
			existedQuestion.setOption4(question.getOption4());
		}
		if(question.getCorrectAnswer()!=null)
		{
			existedQuestion.setCorrectAnswer(question.getCorrectAnswer());
		}
		if(question.getDifficultyLevel()!=null)
		{
			existedQuestion.setDifficultyLevel(question.getDifficultyLevel());
		}
		if(question.getCategory()!=null)
		{
			existedQuestion.setCategory(question.getCategory());
		}
		return questionrepository.save(existedQuestion);
	}

	@Override
	public void deleteQuestionById(Long id) 
	{
		questionrepository.deleteById(id);
		
	}
	
}

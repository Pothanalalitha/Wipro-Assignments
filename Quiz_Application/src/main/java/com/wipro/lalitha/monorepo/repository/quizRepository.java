package com.wipro.lalitha.monorepo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wipro.lalitha.monorepo.entity.Question;
import com.wipro.lalitha.monorepo.entity.Quiz;

@Repository
public interface quizRepository extends JpaRepository<Quiz, Integer> 
{

}

package com.task.surveyAPI.services;

import com.task.surveyAPI.entity.Question;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface QuestionSerivce {




    List<Question> retrieveSuervyquestions(Long id);

    ResponseEntity<String> addnewQuestion(Long id, Question question);
}



package com.task.surveyAPI.services;

import com.task.surveyAPI.Exception.NotFoundException;
import com.task.surveyAPI.entity.Question;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface QuestionSerivce {




    List<Question> retrieveSuervyquestions(Long id) throws NotFoundException;

    ResponseEntity<Object> addnewQuestion(Long id, Question question) throws NotFoundException;

    ResponseEntity<Object> updateSuervyByID(Long questionId, Question question)throws NotFoundException;

    ResponseEntity<Object> DeleteSuervyByID(Long id)throws NotFoundException;
}



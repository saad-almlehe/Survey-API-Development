package com.task.surveyAPI.services;

import com.task.surveyAPI.Exception.NotFoundException;
import com.task.surveyAPI.entity.Survey;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SuervyService {
     List<Survey> retrieveSuervys() throws NotFoundException;


     ResponseEntity<Object> addnewSuervey(Survey survey);




    Survey retrieveSuervyByID(Long id) throws NotFoundException;

    ResponseEntity<Object> updateSuervyByID(Long id, Survey survey) throws NotFoundException;

    ResponseEntity<String> DeleteSuervyByID(Long id) throws NotFoundException;

     boolean validateSuervyDate (Survey survey);
}

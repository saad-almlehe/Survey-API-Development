package com.task.surveyAPI.services;

import com.task.surveyAPI.entity.Survey;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SuervyService {
     List<Survey> retrieveSuervys();


     ResponseEntity<String> addnewSuervey(Survey survey);

      boolean validateMandtoryfields(Survey survey);



}

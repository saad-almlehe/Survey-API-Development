package com.task.surveyAPI.services;

import com.task.surveyAPI.entity.Survey;

import java.util.List;

public interface SuervyService {
     List<Survey> retrieveSuervys();


     void addnewSuervey(Survey survey);



}

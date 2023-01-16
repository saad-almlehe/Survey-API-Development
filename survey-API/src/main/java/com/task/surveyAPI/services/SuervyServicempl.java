package com.task.surveyAPI.services;

import com.task.surveyAPI.entity.Survey;
import com.task.surveyAPI.repository.QuestionRepository;
import com.task.surveyAPI.repository.SurevyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuervyServicempl implements SuervyService{
    @Autowired
    private SurevyRepository surevyRepository;


    public List<Survey> retrieveSuervys(){

        return (List<Survey>) surevyRepository.findAll();
    }

    public void addnewSuervey(Survey survey){

        surevyRepository.save(survey);

    }


}

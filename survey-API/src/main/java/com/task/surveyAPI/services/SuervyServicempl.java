package com.task.surveyAPI.services;

import com.task.surveyAPI.entity.Survey;
import com.task.surveyAPI.repository.QuestionRepository;
import com.task.surveyAPI.repository.SurevyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuervyServicempl implements SuervyService{
    @Autowired
    private SurevyRepository surevyRepository;


    public List<Survey> retrieveSuervys(){

        return (List<Survey>) surevyRepository.findAll();
    }

    public ResponseEntity<String> addnewSuervey(Survey survey){

        if(!validateMandtoryfields(survey)){
            return new ResponseEntity<>("mandatory field of survey is missing", HttpStatus.BAD_REQUEST);
        }

        surevyRepository.save(survey);

        return new ResponseEntity<>("survey has initiated with new ID of"+survey.getId() , HttpStatus.OK);
    }


    public boolean validateMandtoryfields(Survey survey){

        if (survey.getTitle() == null || survey.getTitle().isEmpty())
            return false;

        else if (survey.getActive() == null || survey.getActive().isEmpty())
            return false;

        else if (survey.getMax_response() == null || survey.getMax_response().isEmpty())
            return false;

        else if(survey.getEndDate() == null || survey.getEndDate().isEmpty())
            return false;

        else if(survey.getType() == null || survey.getType().isEmpty())
            return false;

        else return true;

    }


    //ResponseEntity<>(
    //                "survey has initiated with new ID of"+survey.getId(),
    //                HttpStatus.OK);

}



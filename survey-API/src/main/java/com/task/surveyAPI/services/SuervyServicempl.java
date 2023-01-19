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

    public Survey retrieveSuervyByID(Long id){

        System.out.println(surevyRepository.findSuervyByid(id));

        return surevyRepository.findSuervyByid(id);

    }

    public ResponseEntity<String> addnewSuervey(Survey survey){

        if(!validateMandtoryfields(survey)){
            return new ResponseEntity<>("mandatory field of survey is missing", HttpStatus.BAD_REQUEST);
        }

        surevyRepository.save(survey);

        return new ResponseEntity<>("survey has initiated with new ID of"+survey.getId() , HttpStatus.OK);
    }

    public ResponseEntity<String> updateSuervyByID(Long id, Survey survey){

        if(surevyRepository.findSuervyByid(id) != null){
            survey.setId(id);
            surevyRepository.save(survey);
            return new ResponseEntity<>("survey has updated with ID of"+ survey.getId() , HttpStatus.OK);
        }



        return new ResponseEntity<>("suervey ID inccrooect", HttpStatus.NOT_FOUND);

                //surevyRepository.updateSuervy(id,updatedSuervy.getTitle(),updatedSuervy.getDescription(),updatedSuervy.getStartDate(),updatedSuervy.getEndDate()
        //                                             ,updatedSuervy.getMax_response(),updatedSuervy.getActive(),updatedSuervy.getQuestion());


    }
    public ResponseEntity<String> DeleteSuervyByID(Long id){

        if(surevyRepository.findSuervyByid(id) != null){
            Long delted = id;
            surevyRepository.deleteById(id);
            return new ResponseEntity<>("survey has deleted with ID of "+delted, HttpStatus.OK);

        }

        return new ResponseEntity<>("suervey ID inccrooect", HttpStatus.NOT_FOUND);
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

        else return true;

    }


    //ResponseEntity<>(
    //                "survey has initiated with new ID of"+survey.getId(),
    //                HttpStatus.OK);

}



package com.task.surveyAPI.services;

import com.task.surveyAPI.Exception.NotFoundException;
import com.task.surveyAPI.entity.Survey;
import com.task.surveyAPI.repository.QuestionRepository;
import com.task.surveyAPI.repository.SurevyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

@Service
public class SuervyServicempl implements SuervyService{
    @Autowired
    private SurevyRepository surevyRepository;


    public List<Survey> retrieveSuervys() throws NotFoundException {

        List<Survey> suervy = (List<Survey>) surevyRepository.findAll();

        if(!suervy.isEmpty()){
            return suervy;
        }else throw new NotFoundException("no survey stored");
    }

    public Survey retrieveSuervyByID(Long id) throws NotFoundException {

        Survey suervy = surevyRepository.findSuervyByid(id);
        if(suervy != null ){
            return suervy;
        }else throw new NotFoundException("Survey not found with ID "+id);

    }

    public ResponseEntity<Object> addnewSuervey(Survey survey){

         if(!validateSuervyDate(survey)) {
             HashMap<String, Object> map = new HashMap<>();
             map.put("error message","end Date cant be before start date");
             map.put("timestamp", LocalDateTime.now());
             return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
         }

        surevyRepository.save(survey);

        return new ResponseEntity<>("survey has initiated with new ID of "+ survey.getId() , HttpStatus.CREATED);
    }

    public ResponseEntity<Object> updateSuervyByID(Long id, Survey survey) throws NotFoundException {

        if(surevyRepository.findSuervyByid(id) != null){

            if(!validateSuervyDate(survey)) {
                HashMap<String, Object> map = new HashMap<>();
                map.put("error message","end Date cant be before start date");
                map.put("timestamp", LocalDateTime.now());
                return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
            }

            survey.setId(id);
            surevyRepository.save(survey);
            HashMap<String, Object> map = new HashMap<>();
            map.put("Message","survey has updated with ID of"+ survey.getId());
            map.put("timestamp", LocalDateTime.now());
            return new ResponseEntity<>(map , HttpStatus.OK);
        } else throw new NotFoundException("Survey not found with ID "+id);

                //surevyRepository.updateSuervy(id,updatedSuervy.getTitle(),updatedSuervy.getDescription(),updatedSuervy.getStartDate(),updatedSuervy.getEndDate()
        //                                             ,updatedSuervy.getMax_response(),updatedSuervy.getActive(),updatedSuervy.getQuestion());

    }
    public ResponseEntity<String> DeleteSuervyByID(Long id) throws NotFoundException {

        if(surevyRepository.findSuervyByid(id) != null){
            Long delted = id;
            surevyRepository.deleteById(id);
            return new ResponseEntity<>("survey has deleted with ID of "+delted, HttpStatus.OK);

        } else throw new NotFoundException("Survey not found with ID "+id);


    }

    public boolean validateSuervyDate (Survey survey){

        if(survey.getStartDate() == null){
            survey.setStartDate(LocalDate.now());
        }

        if(survey.getEndDate().isBefore(survey.getStartDate())){
            return false;
        }

        if(LocalDate.now().isBefore(survey.getEndDate())
                && LocalDate.now().isAfter(survey.getStartDate()))
            survey.setActive(true);
        else survey.setActive(false);


        return true;
    }

    //ResponseEntity<>(
    //                "survey has initiated with new ID of"+survey.getId(),
    //                HttpStatus.OK);

}



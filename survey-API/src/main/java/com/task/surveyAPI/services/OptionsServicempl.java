package com.task.surveyAPI.services;

import com.task.surveyAPI.Exception.NotFoundException;
import com.task.surveyAPI.entity.Options;
import com.task.surveyAPI.entity.Question;
import com.task.surveyAPI.repository.OptionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

@Service
public class OptionsServicempl implements OptionsService{

    @Autowired
    private OptionsRepository optionsRepository;

    public List<Options> retrieveQuestionsOptions(Long questionID) throws NotFoundException {
        List<Options> options = optionsRepository.findQuestionOptions(questionID);
        if(options != null){
            return options;
        } else throw new NotFoundException("Question with ID "+questionID+" is not found");
    }

    public ResponseEntity<Object> addnewOptions(Long questionID, Options options) throws NotFoundException {
        if(optionsRepository.findQuestionOptions(questionID) != null){


            optionsRepository.save(options);
            optionsRepository.addOptionToQuestion(questionID,options.getId());

            HashMap<String, Object> map = new HashMap<>();
            map.put("Message","option has been added to question ID "+ questionID);
            map.put("timestamp", LocalDateTime.now());
            return new ResponseEntity<>(map  , HttpStatus.OK);

        } else throw new NotFoundException("suervy with ID "+questionID+" is not found");


    }

    public ResponseEntity<Object> DeleteOptionByID(Long optionID, Long questionID) throws NotFoundException {
        List<Options> options =optionsRepository.findOptionsinQuestion(optionID,questionID);
        if( options != null){
            optionsRepository.deleteById(optionID);
            HashMap<String, Object> map = new HashMap<>();
            map.put("Message","Option has been deleted with ID of"+ optionID);
            map.put("timestamp", LocalDateTime.now());
            return new ResponseEntity<>(map , HttpStatus.OK);
        } else throw new NotFoundException("Option with ID "+optionID+" can not be found");






    }






}

package com.task.surveyAPI.services;

import com.task.surveyAPI.entity.Question;
import com.task.surveyAPI.entity.Response;
import com.task.surveyAPI.repository.QuestionRepository;
import com.task.surveyAPI.repository.ResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class ResponseSerivcempl implements ResponseSerivce {


    @Autowired
    private ResponseRepository responseRepository;




    public List<Response> retrieveSuervyResponse(Long id) {

        return responseRepository.findResponseSuervy(id);
    }

    public ResponseEntity<Object> addnewResponse(Long id, Response response) {

        responseRepository.save(response);
        responseRepository.addResponseTosuervy(id,response.getId());


             return new ResponseEntity<>("response has been added to survey ID "+id  , HttpStatus.OK);


    }

    public boolean checkResponseCrossbpond (List < Question > questions, Response response){








        return false;
    }
}

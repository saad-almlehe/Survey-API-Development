package com.task.surveyAPI.services;


import com.task.surveyAPI.Exception.NotFoundException;
import com.task.surveyAPI.entity.Question;
import com.task.surveyAPI.entity.Response;
import com.task.surveyAPI.entity.Survey;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ResponseSerivce {


    List<Response> retrieveSuervyResponse(Long id);

    ResponseEntity<Object> addnewResponse(Long id, Response response) throws NotFoundException;

     boolean checkResponse ( Response response , List<Question> question);

     boolean checkSuervyAvailibialty(Survey suervyByid);
}

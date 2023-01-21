package com.task.surveyAPI.services;


import com.task.surveyAPI.entity.Response;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ResponseSerivce {


    List<Response> retrieveSuervyResponse(Long id);

    ResponseEntity<Object> addnewResponse(Long id, Response response);
}

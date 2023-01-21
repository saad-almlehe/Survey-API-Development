package com.task.surveyAPI.controller;


import com.task.surveyAPI.Exception.NotFoundException;
import com.task.surveyAPI.entity.Question;
import com.task.surveyAPI.entity.Response;
import com.task.surveyAPI.services.QuestionSerivce;
import com.task.surveyAPI.services.ResponseSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/survey/{id}/response")
public class ResponseController {

    private ResponseSerivce responseSerivce;

    @Autowired
    public ResponseController(ResponseSerivce responseSerivce) {this.responseSerivce = responseSerivce;}

    @GetMapping
    public List<Response> getSuervyResponse(@PathVariable Long id) {

        return responseSerivce.retrieveSuervyResponse(id);
    }

    @PostMapping
    public ResponseEntity<Object> addNewResponse(@PathVariable Long id , @RequestBody Response response ) throws NotFoundException {

        return responseSerivce.addnewResponse(id, response);
    }

}

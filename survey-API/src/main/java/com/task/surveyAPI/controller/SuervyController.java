package com.task.surveyAPI.controller;

import com.task.surveyAPI.Exception.NotFoundException;
import com.task.surveyAPI.entity.Survey;
import com.task.surveyAPI.services.SuervyService;
import com.task.surveyAPI.services.SuervyServicempl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/survey")
public class SuervyController {

    private SuervyService suervyService;

    @Autowired
    public void setsuervyService(SuervyService suervyServicempl) {
        this.suervyService = suervyServicempl;
    }

    @GetMapping
    public ResponseEntity<List<Survey>> getAllDogs() throws NotFoundException {
        List<Survey> list = suervyService.retrieveSuervys();
        return new ResponseEntity<List<Survey>>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Survey getSuervybyID(@PathVariable Long id) throws NotFoundException {

        return suervyService.retrieveSuervyByID(id);
    }

    @PostMapping
    public ResponseEntity<Object> addNewSuervy(@RequestBody @Valid Survey survey ){
        return suervyService.addnewSuervey(survey);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateSuervy(@PathVariable Long id,@RequestBody @Valid Survey survey) throws NotFoundException {
        return suervyService.updateSuervyByID(id,survey);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteSuervy(@PathVariable Long id) throws NotFoundException {
        return suervyService.DeleteSuervyByID(id);
    }


    }




    //ResponseEntity<>(
    //                "survey has initiated with new ID of"+survey.getId(),
    //                HttpStatus.OK);




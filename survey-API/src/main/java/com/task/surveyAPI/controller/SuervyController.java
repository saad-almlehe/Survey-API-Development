package com.task.surveyAPI.controller;

import com.task.surveyAPI.entity.Survey;
import com.task.surveyAPI.services.SuervyService;
import com.task.surveyAPI.services.SuervyServicempl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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
    public ResponseEntity<List<Survey>> getAllDogs() {
        List<Survey> list = suervyService.retrieveSuervys();
        return new ResponseEntity<List<Survey>>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Survey getSuervybyID(@PathVariable Long id) {

        return suervyService.retrieveSuervyByID(id);
    }

    @PostMapping
    public ResponseEntity<String> addNewSuervy(@RequestBody Survey survey ){
        return suervyService.addnewSuervey(survey);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateSuervy(@PathVariable Long id,@RequestBody Survey survey) {
        return suervyService.updateSuervyByID(id,survey);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSuervy(@PathVariable Long id) {
        return suervyService.DeleteSuervyByID(id);
    }




    }




    //ResponseEntity<>(
    //                "survey has initiated with new ID of"+survey.getId(),
    //                HttpStatus.OK);




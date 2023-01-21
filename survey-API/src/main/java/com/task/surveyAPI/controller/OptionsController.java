package com.task.surveyAPI.controller;

import com.task.surveyAPI.Exception.NotFoundException;
import com.task.surveyAPI.entity.Options;
import com.task.surveyAPI.entity.Question;
import com.task.surveyAPI.services.OptionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/survey/question/{questionID}/options")
public class OptionsController {


private OptionsService optionsService;

@Autowired
    public OptionsController(OptionsService optionsService) {this.optionsService = optionsService;}

    @GetMapping
    public List<Options> getQuestionsOptions(@PathVariable Long questionID) throws NotFoundException {

        return optionsService.retrieveQuestionsOptions(questionID);
    }

    @PostMapping
    public ResponseEntity<Object> addNewquestion(@PathVariable Long questionID , @RequestBody @Valid Options options ) throws NotFoundException {

        return optionsService.addnewOptions(questionID, options);
    }

    @DeleteMapping("{optionID}")
    public ResponseEntity<Object> deleteSuervy(@PathVariable Long questionID , @PathVariable Long optionID ) throws NotFoundException {
        return optionsService.DeleteOptionByID(optionID,questionID);
    }


}

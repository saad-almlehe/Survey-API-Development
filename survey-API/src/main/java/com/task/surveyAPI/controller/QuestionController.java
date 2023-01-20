package com.task.surveyAPI.controller;

import com.task.surveyAPI.entity.Question;
import com.task.surveyAPI.entity.Survey;
import com.task.surveyAPI.services.QuestionSerivce;
import com.task.surveyAPI.services.SuervyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("api/survey/{id}/question")
public class QuestionController {

    private QuestionSerivce questionSerivce;

    @Autowired
    public void QuestionSerivce(QuestionSerivce questionServicempl) {
        this.questionSerivce = questionServicempl;
    }


    @GetMapping
        public List<Question> getSuervyQuestions(@PathVariable Long id) {

        return questionSerivce.retrieveSuervyquestions(id);
    }

    @PostMapping
    public ResponseEntity<String> addNewquestion( @PathVariable Long id , @RequestBody Question question ){

        return questionSerivce.addnewQuestion(id, question);
    }

}

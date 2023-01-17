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
@RequestMapping("api/survey/questions")
public class QuestionController {

    private QuestionSerivce questionSerivce;

    @Autowired
    public void QuestionSerivce(QuestionSerivce questionServicempl) {
        this.questionSerivce = questionServicempl;
    }


    @GetMapping
        public ResponseEntity<List<Question>> getAllQuestions() {
        List<Question> list = questionSerivce.retrievequestions();
        return new ResponseEntity<List<Question>>(list, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addNewquestion( @RequestBody Question question ){
        questionSerivce.addnewQuestion(question);
        return new ResponseEntity<>(
                "survey has initiated with new ID of"+question.getId(),
                HttpStatus.OK);
    }

}

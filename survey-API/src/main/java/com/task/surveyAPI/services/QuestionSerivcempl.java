package com.task.surveyAPI.services;

import com.task.surveyAPI.Exception.NotFoundException;
import com.task.surveyAPI.entity.Question;
import com.task.surveyAPI.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionSerivcempl implements QuestionSerivce {

    @Autowired
    private QuestionRepository questionRepository;


    public List<Question> retrieveSuervyquestions(Long id) throws NotFoundException {

        List<Question> questions = questionRepository.findQuestionsSuervy(id);

        if(questions != null){
            return questions;
        } else throw new NotFoundException("suervy with ID"+id+" is not found");
    }

    public ResponseEntity<String> addnewQuestion(Long id, Question question) throws NotFoundException {

        if(questionRepository.findQuestionsSuervy(id) != null){


            questionRepository.save(question);
            questionRepository.addQuestionTosuervy(id,question.getId());

            return new ResponseEntity<>("question has been added to survey ID "+ id  , HttpStatus.OK);

        } else throw new NotFoundException("suervy with ID"+id+" is not found");


    }



}

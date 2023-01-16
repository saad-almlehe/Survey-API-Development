package com.task.surveyAPI.services;

import com.task.surveyAPI.entity.Question;
import com.task.surveyAPI.entity.Survey;
import com.task.surveyAPI.repository.AnswerRepository;
import com.task.surveyAPI.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionSerivcempl implements QuestionSerivce {

    @Autowired
    private QuestionRepository questionRepository;


    public List<Question> retrievequestions(){

       return (List<Question>) questionRepository.findAll();
    }

    public void addnewQuestion(Question question){

        questionRepository.save(question);
    }


}

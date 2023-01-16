package com.task.surveyAPI.services;

import com.task.surveyAPI.entity.Question;

import java.util.List;

public interface QuestionSerivce {


    List<Question> retrievequestions();

    void addnewQuestion(Question question);
}



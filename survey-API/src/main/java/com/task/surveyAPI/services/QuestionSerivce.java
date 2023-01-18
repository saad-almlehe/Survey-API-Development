package com.task.surveyAPI.services;

import com.task.surveyAPI.entity.Question;

import java.util.List;

public interface QuestionSerivce {



    void addnewQuestion(Question question);

    List<Question> retrieveSuervyquestions(Long id);
}



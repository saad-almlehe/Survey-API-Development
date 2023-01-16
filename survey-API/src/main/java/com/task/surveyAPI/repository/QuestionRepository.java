package com.task.surveyAPI.repository;

import com.task.surveyAPI.entity.Question;
import com.task.surveyAPI.entity.Survey;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<Question, Long> {


}

package com.task.surveyAPI.repository;

import com.task.surveyAPI.entity.Answer;
import org.springframework.data.repository.CrudRepository;

public interface AnswerRepository extends CrudRepository<Answer, Long> {
}

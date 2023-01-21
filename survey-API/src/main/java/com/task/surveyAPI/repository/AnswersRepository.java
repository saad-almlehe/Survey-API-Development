package com.task.surveyAPI.repository;

import com.task.surveyAPI.entity.Answers;
import org.springframework.data.repository.CrudRepository;

public interface AnswersRepository extends CrudRepository<Answers, Long> {
}

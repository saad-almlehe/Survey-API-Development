package com.task.surveyAPI.repository;

import com.task.surveyAPI.entity.Answers;
import com.task.surveyAPI.entity.Response;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AnswersRepository extends CrudRepository<Answers, Long> {

}

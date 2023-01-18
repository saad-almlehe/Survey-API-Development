package com.task.surveyAPI.repository;
import com.task.surveyAPI.entity.Question;
import com.task.surveyAPI.entity.Survey;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface QuestionRepository extends CrudRepository <Question, Long> {


    @Query(value = "SELECT * FROM Question t WHERE t.FK_SURVEY_ID=:id", nativeQuery = true)
    List<Question> findQuestionsSuervy(Long id);
}

package com.task.surveyAPI.repository;
import com.task.surveyAPI.entity.Question;
import com.task.surveyAPI.entity.Survey;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface QuestionRepository extends CrudRepository <Question, Long> {


    @Query(value = "SELECT * FROM Question t WHERE t.FK_SURVEY_ID=:id", nativeQuery = true)
    List<Question> findQuestionsSuervy(Long id);

    @Modifying
    @Transactional
    @Query(value = "update Question t set t.FK_SURVEY_ID=:id where t.id=:questionID", nativeQuery = true)
    void addQuestionTosuervy (Long id, Long questionID);
}

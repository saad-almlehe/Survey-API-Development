package com.task.surveyAPI.repository;

import com.task.surveyAPI.entity.Options;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface OptionsRepository extends CrudRepository<Options, Long> {

    @Query(value = "SELECT * FROM Options t WHERE t.FK_SURVEY_ID=:questionID", nativeQuery = true)
    List<Options> findQuestionOptions(Long questionID);

    @Modifying
    @Transactional
    @Query(value = "update Options t set t.FK_QUESTION_ID=:id where t.id=:questionID", nativeQuery = true)
    void addOptionToQuestion(Long questionID, Long id);

    @Query(value = "SELECT * FROM Options t WHERE t.FK_QUESTION_ID=:questionID AND t.id=:optionID", nativeQuery = true)
    List<Options> findOptionsinQuestion(Long optionID, Long questionID);
}

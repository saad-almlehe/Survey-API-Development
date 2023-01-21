package com.task.surveyAPI.repository;

import com.task.surveyAPI.entity.Question;
import com.task.surveyAPI.entity.Response;
import com.task.surveyAPI.entity.Survey;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface ResponseRepository extends CrudRepository<Response, Long> {


    @Modifying
    @Transactional
    @Query(value = "update Response t set t.FK_SURVEY_ID=:id where t.id=:responseID", nativeQuery = true)
    void addResponseTosuervy(Long id, Long responseID);

    @Query(value = "SELECT * FROM Response t WHERE t.FK_SURVEY_ID=:id", nativeQuery = true)
    List<Response> findResponseSuervy(Long id);


    @Query("select e from Survey e where e.id=:id ")
    Survey findSuervyByid(@Param("id") Long id);
}

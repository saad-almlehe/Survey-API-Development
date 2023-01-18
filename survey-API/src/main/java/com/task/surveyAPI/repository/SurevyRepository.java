package com.task.surveyAPI.repository;

import com.task.surveyAPI.entity.Survey;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface SurevyRepository extends CrudRepository<Survey, Long> {

    @Query("select e from Survey e where e.id=:id ")
    Survey findSuervyByid(@Param("id") Long id);
}

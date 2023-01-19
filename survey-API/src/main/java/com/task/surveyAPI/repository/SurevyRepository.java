package com.task.surveyAPI.repository;

import com.task.surveyAPI.entity.Question;
import com.task.surveyAPI.entity.Survey;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SurevyRepository extends CrudRepository<Survey, Long> {

    @Query("select e from Survey e where e.id=:id ")
    Survey findSuervyByid(@Param("id") Long id);


    //@Modifying
    //    @Query("update Survey e set e.id=?1 , e.title=?2 , e.description=?3, e.startDate=?4 , " +
    //            "e.endDate=?5 , e.maxResponse=?6 , e.active=?7 , e.question=?8")
    //    ResponseEntity<String> updateSuervy(Long id, String title, String description, String startDate, String endDate, String maxResponse, String active, List<Question> question);
}

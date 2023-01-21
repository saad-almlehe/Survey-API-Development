package com.task.surveyAPI.services;

import com.task.surveyAPI.Exception.NotFoundException;
import com.task.surveyAPI.entity.Options;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OptionsService {
    List<Options> retrieveQuestionsOptions(Long questionID) throws NotFoundException;

    ResponseEntity<Object> addnewOptions(Long questionID, Options options) throws NotFoundException;

    ResponseEntity<Object> DeleteOptionByID(Long optionID, Long questionID) throws NotFoundException;
}

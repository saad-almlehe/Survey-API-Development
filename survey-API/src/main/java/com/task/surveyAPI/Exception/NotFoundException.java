package com.task.surveyAPI.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


public class NotFoundException extends Exception{

    public NotFoundException(String message) {
        super(message);
    }
}

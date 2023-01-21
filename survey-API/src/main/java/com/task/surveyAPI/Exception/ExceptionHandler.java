package com.task.surveyAPI.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;


@RestControllerAdvice
public class ExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @org.springframework.web.bind.annotation.ExceptionHandler ({MethodArgumentNotValidException.class})
    public Map<String,Object> handelInvaildArgument(MethodArgumentNotValidException exception){

        Map<String,Object> errorMap = new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(error -> {
            errorMap.put(error.getField(),error.getDefaultMessage());
        });
        errorMap.put("timestamp", LocalDateTime.now());



        return errorMap;


    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
@org.springframework.web.bind.annotation.ExceptionHandler(NotFoundException.class)
    public Map<String,Object> handelnotFound(NotFoundException exception){

        Map<String,Object> errorMap = new HashMap<>();
        errorMap.put("errorMessage",exception.getMessage());
        errorMap.put("timestamp", LocalDateTime.now());
        return errorMap;

    }


}

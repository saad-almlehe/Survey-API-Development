package com.task.surveyAPI.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.HashMap;

@Entity
public class Response {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String date;


    private Long questionID;

    private HashMap<Long,String> responses = new HashMap<>();


    public Response() {
    }

    public Response(Long id, Long questionID, HashMap<Long, String> responses , String username , String date ) {
        this.id = id;
        this.questionID = questionID;
        this.responses = responses;
        this.date = date;
        this.username =username;
    }

    public Response(Long questionID, HashMap<Long, String> responsesm,String username , String date) {
        this.questionID = questionID;
        this.responses = responses;
        this.date = date;
        this.username =username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQuestionID() {
        return questionID;
    }

    public void setQuestionID(Long questionID) {
        this.questionID = questionID;
    }

    public HashMap<Long, String> getResponses() {
        return responses;
    }

    public void setResponses(HashMap<Long, String> responses) {
        this.responses = responses;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

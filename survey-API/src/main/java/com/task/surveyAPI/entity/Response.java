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

    private HashMap<Long,String> answer = new HashMap<>();


    public Response() {
    }

    public Response(Long id, Long questionID, HashMap<Long, String> answer, String username , String date ) {
        this.id = id;
        this.questionID = questionID;
        this.answer = answer;
        this.date = date;
        this.username =username;
    }

    public Response(Long questionID, HashMap<Long, String> responsesm,String username , String date) {
        this.questionID = questionID;
        this.answer = answer;
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

    public HashMap<Long, String> getAnswer() {
        return answer;
    }

    public void setAnswer(HashMap<Long, String> answer) {
        this.answer = answer;
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

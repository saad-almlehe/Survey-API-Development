package com.task.surveyAPI.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Response {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private Date date;
    private String questionID;

    private String username;
    private int answerID;

    public Response(int id, Date date, String questionID, String username, int answerID) {
        this.id = id;
        this.date = date;
        this.questionID = questionID;
        this.username = username;
        this.answerID = answerID;
    }

    public Response(Date date, String questionID, String username, int answerID) {
        this.date = date;
        this.questionID = questionID;
        this.username = username;
        this.answerID = answerID;
    }
    public Response(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getQuestionID() {
        return questionID;
    }

    public void setQuestionID(String questionID) {
        this.questionID = questionID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAnswerID() {
        return answerID;
    }

    public void setAnswerID(int answerID) {
        this.answerID = answerID;
    }
}

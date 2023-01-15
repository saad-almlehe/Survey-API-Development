package com.task.surveyAPI.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String qustion;
    private String mandotry;
    private String type;

    private int surveyID;


    public Question(int id, String qustion, String mandotry, String type, int surveyID) {
        this.id = id;
        this.qustion = qustion;
        this.mandotry = mandotry;
        this.type = type;
        this.surveyID = surveyID;
    }

    public Question(String qustion, String mandotry, String type, int surveyID) {
        this.qustion = qustion;
        this.mandotry = mandotry;
        this.type = type;
        this.surveyID = surveyID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQustion() {
        return qustion;
    }

    public void setQustion(String qustion) {
        this.qustion = qustion;
    }

    public String getMandotry() {
        return mandotry;
    }

    public void setMandotry(String mandotry) {
        this.mandotry = mandotry;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSurveyID() {
        return surveyID;
    }

    public void setSurveyID(int surveyID) {
        this.surveyID = surveyID;
    }
}

package com.task.surveyAPI.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Survey {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String title;
    private String startDate;
    private String endDate;
    private String max_response;
    private String active;

    public Survey(int id, String title, String startDate, String endDate, String max_response, String active) {
        this.id = id;
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.max_response = max_response;
        this.active = active;
    }

    public Survey(String title, String startDate, String endDate, String max_response, String active) {
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.max_response = max_response;
        this.active = active;
    }

    public Survey(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getMax_response() {
        return max_response;
    }

    public void setMax_response(String max_response) {
        this.max_response = max_response;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }
}

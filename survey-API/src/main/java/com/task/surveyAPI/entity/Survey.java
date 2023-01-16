package com.task.surveyAPI.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Survey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String startDate;
    private String endDate;
    private String max_response;
    private String active;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="fk_survey_id",referencedColumnName = "id")
    private List<Question> question;


    public Survey(Long id, String title, String startDate, String endDate, String max_response, String active,List<Question> question) {
        this.id = id;
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.max_response = max_response;
        this.active = active;
        this.question=question;
    }

    public Survey(String title, String startDate, String endDate, String max_response, String active,List<Question> question) {
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.max_response = max_response;
        this.active = active;
        this.question=question;
    }

    public Survey(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Question> getQuestion() {
        return question;
    }

    public void setQuestion(List<Question> question) {
        this.question = question;
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

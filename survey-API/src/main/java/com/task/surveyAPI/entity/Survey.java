package com.task.surveyAPI.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import net.bytebuddy.implementation.bind.annotation.Empty;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;


@Entity
public class Survey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotBlank(message = "missing mandatory field title")
    private String title;

    private String description;

    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate startDate;

    @NotNull(message = "missing mandatory field endDate")
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate endDate;

    @NotNull(message = "missing mandatory field max_response")
    @Min(1)
    @Max(1000)
    private Integer max_response;



    private boolean active;


    @Valid
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="fk_survey_id",referencedColumnName = "id")
    private List<Question> question;



    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="fk_survey_id",referencedColumnName = "id")
    private List<Response> responses;




    public Survey(Long id, String title, LocalDate startDate, LocalDate endDate, Integer max_response, boolean active,String description,List<Question> question) {
        this.id = id;
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.max_response = max_response;
        this.active = active;
        this.question=question;
        this.description=description;
    }

    public Survey(String title, LocalDate startDate, LocalDate endDate, Integer max_response, boolean active,String description,List<Question> question) {
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.max_response = max_response;
        this.active = active;
        this.question=question;
        this.description=description;
    }

    public Survey(String title, LocalDate startDate, LocalDate endDate, Integer max_response, boolean active,String description) {
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.max_response = max_response;
        this.active = active;
        this.description=description;


    }

    public Survey(){}



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

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

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Integer getMax_response() {
        return max_response;
    }

    public void setMax_response(Integer max_response) {
        this.max_response = max_response;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<Response> getResponses() {
        return responses;
    }

    public void setResponses(List<Response> responses) {
        this.responses = responses;
    }
}

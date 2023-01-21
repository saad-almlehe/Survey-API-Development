package com.task.surveyAPI.entity;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Response {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "missing mandatory field username")
    private String username;

    private String date;

    @Valid
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="fk_response_id",referencedColumnName = "id")
    private List<Answers> answers;


    public Response() {
    }

    public Response(Long id,  List<Answers> answers, String username , String date ) {
        this.id = id;

        this.answers = answers;
        this.date = date;
        this.username =username;
    }

    public Response(List<Answers> answers, String username , String date) {

        this.answers = answers;
        this.date = date;
        this.username =username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<Answers> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answers> answers) {
        this.answers = answers;
    }
}

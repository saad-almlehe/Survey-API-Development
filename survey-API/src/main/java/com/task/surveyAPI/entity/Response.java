package com.task.surveyAPI.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Response {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String date;


    private Long questionID;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="fk_response_id",referencedColumnName = "id")
    private List<Answers> answers;


    public Response() {
    }

    public Response(Long id, Long questionID, List<Answers> answers, String username , String date ) {
        this.id = id;
        this.questionID = questionID;
        this.answers = answers;
        this.date = date;
        this.username =username;
    }

    public Response(Long questionID, List<Answers> answers, String username , String date) {
        this.questionID = questionID;
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

    public Long getQuestionID() {
        return questionID;
    }

    public void setQuestionID(Long questionID) {
        this.questionID = questionID;
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

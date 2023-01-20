package com.task.surveyAPI.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String question;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="fk_question_id",referencedColumnName = "id")
    private List<Options> options;


    public Question() {
    }

    public Question(Long id, String question) {
        this.id = id;
        this.question = question;

    }

    public Question(String question) {
        this.question = question;
    }

    public List<Options> getAnswers() {
        return options;
    }

    public void setAnswers(List<Options> options) {
        this.options = options;
    }


    public Question(String question,List<Options> options) {
        this.question = question;
        this.options = options;
    }




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}

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
    private List<Answer> answers;


    public Question() {
    }

    public Question(Long id, String question) {
        this.id = id;
        this.question = question;

    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public Question(String question) {
        this.question = question;

    }

    public Question(String question,List<Answer> answers) {
        this.question = question;
        this.answers=answers;
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

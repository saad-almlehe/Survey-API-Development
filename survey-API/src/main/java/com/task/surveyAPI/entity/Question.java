package com.task.surveyAPI.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "missing mandatory filed question")
    private String question;

    @NotNull(message = "missing is a question mandatory or not")
    private boolean mandatory;



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

    public List<Options> getoptions() {
        return options;
    }

    public void setoptions(List<Options> options) {
        this.options = options;
    }


    public Question(String question,boolean mandatory,List<Options> options) {
        this.question = question;
        this.options = options;
        this.mandatory=mandatory;
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


    public boolean isMandatory() {
        return mandatory;
    }

    public void setMandatory(boolean mandatory) {
        this.mandatory = mandatory;
    }

}

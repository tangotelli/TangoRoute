package com.example.tangoroute.persistence;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.tangoroute.models.Question;

@Entity(tableName = QuestionEntity.QUESTIONS)
public class QuestionEntity {

    public static final String QUESTIONS = "questions";

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String wonderName;
    private String statement;
    private String[] answerOptions;
    private int correctAnswer;
    private int points;

    public QuestionEntity() {
        //empty from framework
    }

    public QuestionEntity(Question question) {
        this.wonderName = question.getWonderName();
        this.statement = question.getStatement();
        this.answerOptions = question.getAnswerOptions();
        this.correctAnswer = question.getCorrectAnswer();
        this.points = question.getPoints();
    }

    public Question toQuestion() {
        return Question.builder()
                .wonderName(this.wonderName)
                .statement(this.statement)
                .answerOptions(this.answerOptions)
                .correctAnswer(this.correctAnswer)
                .points(this.points)
                .build();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWonderName() {
        return wonderName;
    }

    public void setWonderName(String wonderName) {
        this.wonderName = wonderName;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public String[] getAnswerOptions() {
        return answerOptions;
    }

    public void setAnswerOptions(String[] answerOptions) {
        this.answerOptions = answerOptions;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}

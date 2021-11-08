package com.example.tangoroute.models;

public class Question {

    private String wonderName;
    private String statement;
    private String[] answerOptions;
    private int correctAnswer;
    private int points;

    public static QuestionBuilders.WonderName builder() {
        return new QuestionBuilder();
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

    public static class QuestionBuilder implements QuestionBuilders.WonderName, QuestionBuilders.Statement,
            QuestionBuilders.AnswerOptions, QuestionBuilders.CorrectAnswer,
            QuestionBuilders.Points, QuestionBuilders.Optional {

        private Question question;

        public QuestionBuilder() {
            this.question = new Question();
        }

        @Override
        public QuestionBuilders.Statement wonderName(String wonderName) {
            this.question.wonderName = wonderName;
            return this;
        }

        @Override
        public QuestionBuilders.AnswerOptions statement(String statement) {
            this.question.statement = statement;
            return this;
        }

        @Override
        public QuestionBuilders.CorrectAnswer answerOptions(String[] answerOptions) {
            this.question.answerOptions = answerOptions;
            return this;
        }

        @Override
        public QuestionBuilders.Points correctAnswer(int correctAnswer) {
            this.question.correctAnswer = correctAnswer;
            return this;
        }

        @Override
        public QuestionBuilders.Optional points(int points) {
            this.question.points = points;
            return this;
        }

        @Override
        public Question build() {
            return this.question;
        }
    }
}

package com.example.tangoroute.models;

public interface QuestionBuilders {

    interface WonderName {
        QuestionBuilders.Statement wonderName(String wonderName);
    }

    interface Statement {
        QuestionBuilders.AnswerOptions statement(String statement);
    }

    interface AnswerOptions {
        QuestionBuilders.CorrectAnswer answerOptions(String[] answerOptions);
    }

    interface CorrectAnswer {
        QuestionBuilders.Points correctAnswer(int correctAnswer);
    }

    interface Points {
        QuestionBuilders.Optional points(int points);
    }

    interface Optional {
        Question build();
    }
}

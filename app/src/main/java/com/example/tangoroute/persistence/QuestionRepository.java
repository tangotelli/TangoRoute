package com.example.tangoroute.persistence;

import android.app.Application;

import com.example.tangoroute.models.Question;
import com.example.tangoroute.models.Wonder;

import java.util.ArrayList;
import java.util.List;

public class QuestionRepository {

    private static QuestionRepository repository;
    private QuestionDAO questionDAO;

    private QuestionRepository(Application application) {
        QuestionDatabase database = QuestionDatabase.getDatabase(application);
        this.questionDAO = database.questionDAO();
    }

    public static QuestionRepository getInstance(Application application) {
        if (repository == null) {
            repository = new QuestionRepository(application);
        }
        return repository;
    }

    public List<Question> findByWonderName(String wonderName) {
        List<QuestionEntity> questionEntities = this.questionDAO.findByWonderName(wonderName);
        List<Question> questions = new ArrayList<>();
        for (QuestionEntity entity : questionEntities) {
            questions.add(entity.toQuestion());
        }
        return questions;
    }

    public void deleteAll() {
        this.questionDAO.deleteAll();
    }

    public Long insert(Question question) {
        return this.questionDAO.insert(new QuestionEntity(question));
    }
}

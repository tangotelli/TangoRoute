package com.example.tangoroute.persistence;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface QuestionDAO {

    @Query("SELECT * FROM " + QuestionEntity.QUESTIONS
            + " WHERE wonderName = :wonderName")
    List<QuestionEntity> findByWonderName(String wonderName);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insert(QuestionEntity questionEntity);

    @Query("DELETE FROM " + QuestionEntity.QUESTIONS)
    void deleteAll();
}

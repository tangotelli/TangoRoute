package com.example.tangoroute.persistence;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface WonderDAO {

    @Query("SELECT * FROM " + WonderEntity.WONDERS
            + " WHERE name = :name")
    WonderEntity findByName(String name);

    @Query("SELECT * FROM " + WonderEntity.WONDERS)
    List<WonderEntity> findAll();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insert(WonderEntity wonderEntity);
}

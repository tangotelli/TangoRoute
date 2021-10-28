package com.example.tangoroute.persistence;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface WonderDAO {

    @Query("SELECT * FROM " + WonderEntity.WONDERS
            + " WHERE name = :name")
    WonderEntity findByName(String name);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insert(WonderEntity wonderEntity);
}

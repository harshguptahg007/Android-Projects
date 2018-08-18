package com.example.harsh.fetch2;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by harsh on 30/3/18.
 */

@Dao
public interface MyPredicationsDao {

    @Insert
    public void tablePredictionsAdd(Predictions predictions);


    @Query("select * from predictions")
    public List<Predictions> getUsers();
}

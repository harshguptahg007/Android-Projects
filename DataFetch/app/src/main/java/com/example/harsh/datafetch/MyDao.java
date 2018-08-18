package com.example.harsh.datafetch;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by harsh on 30/3/18.
 */

@Dao
public interface MyDao {

    @Insert
    public void tableAdd(Predictions prediction);

    @Query("select * from predictions")
    public List<Predictions> getEntries();
}

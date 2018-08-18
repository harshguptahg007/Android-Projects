package com.example.harsh.datafetch;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by harsh on 30/3/18.
 */

@Database(entities = {Predictions.class},version = 2)
public abstract class MyAppDatabase extends RoomDatabase {

    public abstract MyDao myDao();
}

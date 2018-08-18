package com.example.harsh.fetch2;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by harsh on 30/3/18.
 */

@Database(entities = {Predictions.class}, version = 1 )
public abstract class MyPredictionDatabase extends RoomDatabase {

    public abstract MyPredicationsDao myPredictionsDao();
}

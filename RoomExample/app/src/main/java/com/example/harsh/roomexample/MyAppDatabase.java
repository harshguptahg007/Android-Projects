package com.example.harsh.roomexample;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by harsh on 29/3/18.
 */

@Database(entities = {User.class},version = 1)
public abstract class MyAppDatabase extends RoomDatabase {

    public abstract MyDao myDao();

}

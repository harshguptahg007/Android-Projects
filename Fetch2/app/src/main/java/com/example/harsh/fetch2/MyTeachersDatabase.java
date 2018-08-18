package com.example.harsh.fetch2;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by harsh on 31/3/18.
 */

@Database(entities = {Teachers.class},version=1)
public abstract class MyTeachersDatabase extends RoomDatabase{

    public abstract MyTeachersDao myTeachersDao();
}

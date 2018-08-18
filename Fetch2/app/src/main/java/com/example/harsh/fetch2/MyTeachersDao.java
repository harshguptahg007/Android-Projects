package com.example.harsh.fetch2;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by harsh on 31/3/18.
 */

@Dao
public interface MyTeachersDao {

    @Insert
    public void tableTeachersAdd(Teachers teacher);

    @Query("select * from teachers")
    public List<Teachers> getTeachersDetail();
}

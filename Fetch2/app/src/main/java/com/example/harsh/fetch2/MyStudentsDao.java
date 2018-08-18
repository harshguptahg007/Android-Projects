package com.example.harsh.fetch2;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by harsh on 30/3/18.
 */

@Dao
public interface MyStudentsDao {

    @Insert
    public void tableStudentsAdd(Students students);

    @Query("select * from students")
    public List<Students> getStudentsDetails();

    @Query("select * from students")
    public List<Students> getStudentLoginDetails();
}

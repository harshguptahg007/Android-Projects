package com.example.harsh.roomexample;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by harsh on 29/3/18.
 */

@Dao
public interface MyDao {

    @Insert
    public void userAdd(User user);

    @Query("select * from users")
    public List<User> getUsers();

    @Delete
    public void deleteUser(User user);

    @Update
    public void updateUser(User user);
}

package com.example.harsh.roomexample;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by harsh on 29/3/18.
 */
@Entity(tableName = "users")
public class User {

    @PrimaryKey
    private int id;

    @ColumnInfo(name = "user_name")
    private String name;

    @ColumnInfo(name = "user_email")
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

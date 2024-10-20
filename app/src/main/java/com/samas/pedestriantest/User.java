package com.samas.pedestriantest;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity(tableName = "users")
public class User {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String name;
    public String password;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

}
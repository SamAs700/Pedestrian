package com.samas.pedestriantest;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM users WHERE name = :username LIMIT 1")
    User findByUsername(String username);

    @Insert
    void insert(User user);

    @Delete
    void delete(User user);
}
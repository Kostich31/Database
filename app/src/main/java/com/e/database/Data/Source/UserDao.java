package com.e.database.Data.Source;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.e.database.Data.Models.User;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface UserDao {
    @Insert(onConflict = REPLACE)
    void insert(User userData);

    @Delete
    void delete(User userData);

    @Delete
    void reset(List<User> userData);

    @Query("UPDATE User SET mail = :sMail, password = :sPassword   WHERE id = :sID")
    void update(int sID,String sMail, String sPassword);

    @Query("SELECT * FROM User")
    List<User> getAll();

}

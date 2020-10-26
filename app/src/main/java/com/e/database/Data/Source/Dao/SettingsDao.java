package com.e.database.Data.Source.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.e.database.Data.Models.Settings;
import com.e.database.Data.Models.User;

import java.util.List;

@Dao
public interface SettingsDao {

    @Insert
    void insert(Settings setting);

    @Update
    void update (Settings setting);

    @Delete
    void delete(Settings setting);

    @Query("SELECT * FROM user")
    LiveData<List<Settings>> getSettings();
}

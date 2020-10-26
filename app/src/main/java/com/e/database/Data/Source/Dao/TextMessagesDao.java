package com.e.database.Data.Source.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.e.database.Data.Models.Settings;
import com.e.database.Data.Models.TextMessages;

import java.util.List;

@Dao
public interface TextMessagesDao {

    @Insert
    void insert(TextMessages textMessage);

    @Update
    void update (TextMessages textMessage);

    @Delete
    void delete(TextMessages textMessage);

    @Query("SELECT * FROM user")
    LiveData<List<TextMessages>> getTextMessages();
}

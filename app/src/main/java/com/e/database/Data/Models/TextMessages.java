package com.e.database.Data.Models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Text_Messages")
public class TextMessages {
    @PrimaryKey(autoGenerate = true)
    private long id;

    private String message;

}
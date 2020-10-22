package com.e.database.Data.Models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Settings")
public class Settings {
    @PrimaryKey(autoGenerate = true)
    private long id;

    private String name;

    private String value;
}

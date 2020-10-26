package com.e.database.Data.Models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Settings")
public class Settings {

    @PrimaryKey(autoGenerate = true)
    private long id;

    private String name;

    private String value;

    public Settings(long id, String name, String value) {
        this.id = id;
        this.name = name;
        this.value = value;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

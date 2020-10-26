package com.e.database.Data.Models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "text_messages")
public class TextMessages {

    @PrimaryKey(autoGenerate = true)
    private long id;

    private String text;

    public TextMessages(long id, String text) {
        this.id = id;
        this.text = text;
    }


    public long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

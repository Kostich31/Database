package com.e.database.Data.Models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user")
public class User {

    @PrimaryKey(autoGenerate = true)
    private long id;
    private String mail;
    private String password;

    public User(long id, String mail, String password) {
        this.id = id;
        this.mail = mail;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public String getPassword() {
        return password;
    }

}

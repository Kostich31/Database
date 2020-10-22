package com.e.database.Data.Source;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.e.database.Data.Models.Settings;
import com.e.database.Data.Models.TextMessages;
import com.e.database.Data.Models.User;

@Database(entities = {Settings.class, TextMessages.class, User.class}, version = 1, exportSchema = false)

public abstract class InternalDatabase extends RoomDatabase {
    private static InternalDatabase database;
    private static String DATABASE_NAME = "internalDatabase";
    public synchronized static InternalDatabase getInstance(Context context)

    {
        if(database== null)
        {
            database = Room.databaseBuilder(context.getApplicationContext()
            ,InternalDatabase.class,DATABASE_NAME)
            .fallbackToDestructiveMigration().build();
        }

        return database;


    }
    public abstract UserDao userDao();
    //public SettingsDao settingsDao();
    //public TextMessagesDao textMessagesDao();

}

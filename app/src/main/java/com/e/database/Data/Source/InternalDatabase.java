package com.e.database.Data.Source;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.e.database.Data.Models.User;
import com.e.database.Data.Source.Dao.SettingsDao;
import com.e.database.Data.Source.Dao.TextMessagesDao;
import com.e.database.Data.Source.Dao.UserDao;

@Database(entities = {User.class}, version = 1)
public abstract class InternalDatabase extends RoomDatabase {

    private static InternalDatabase instance;

    public abstract UserDao userDao();

    public abstract SettingsDao settingsDao();

    public abstract TextMessagesDao textMessagesDao();



    public static synchronized InternalDatabase getInstance(Context context)
    {
        if(instance == null)
        {
            instance = Room.databaseBuilder(context.getApplicationContext(), InternalDatabase.class, "internal_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

    private static InternalDatabase.Callback roomCallback = new RoomDatabase.Callback()
    {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
        }
    };



}

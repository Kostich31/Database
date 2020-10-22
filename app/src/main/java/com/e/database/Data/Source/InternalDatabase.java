package com.e.database.Data.Source;

import androidx.room.Database;

import com.e.database.Data.Models.Settings;
import com.e.database.Data.Models.TextMessages;
import com.e.database.Data.Models.User;

@Database(entities = {Settings.class, TextMessages.class, User.class}, version = 1, exportSchema = false)

public class InternalDatabase {
}

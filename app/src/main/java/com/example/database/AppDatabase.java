package com.example.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Citizens.class, Cars.class, Addresses.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract CitizensDao CitizensDao();
}

package com.example.to_dolistproject.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {NoteModel.class}, version = 1, exportSchema = false)
public abstract class NoteDatabase extends RoomDatabase {
    private static volatile NoteDatabase INSTANCE;

    public abstract NoteDao noteDao();

}


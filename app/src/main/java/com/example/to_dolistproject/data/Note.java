package com.example.to_dolistproject.data;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Fts4;
import androidx.room.PrimaryKey;

@Fts4(languageId = "lid")
@Entity(tableName = "note_table")
public class Note {
    @PrimaryKey(autoGenerate = true)
    protected int id;
    @ColumnInfo(name = "task_name")
    protected String taskName;
    @ColumnInfo(name = "lid")
    protected int languageId;
}

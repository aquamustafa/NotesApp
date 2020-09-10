package com.example.andsadroid.room.Model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "note_table")
public class Notes {
    public Notes() {
    }

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String Note;
    private String Description;
    public int getId() {
        return id;
    }

    public void setNote(String note) {
        Note = note;
    }

    public void setDescription(String description) {
        Description = description;
    }


    public Notes(String note, String description ) {
        Note = note;
        Description = description;
   }

    public void setId(int id) {
        this.id = id;
    }

    public String getNote() {
        return Note;
    }

    public String getDescription() {
        return Description;
    }

 }

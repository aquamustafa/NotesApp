package com.example.andsadroid.room.Database;

import com.example.andsadroid.room.Model.Notes;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

//contains the operations on the database
@Dao
public interface NoteDao {


    @Query("SELECT * FROM note_table ORDER BY id desc")
    LiveData<List<Notes>> getAllnotes ();

    @Insert
    void insert(Notes notes);

    @Update
    void update(Notes notes);

    @Delete
    void delete(Notes notes);

    @Query("DELETE FROM note_table")
    void deleteAllNotes();

}

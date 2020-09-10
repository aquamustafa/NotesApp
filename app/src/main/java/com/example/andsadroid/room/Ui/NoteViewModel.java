package com.example.andsadroid.room.Ui;
import android.app.Application;

import com.example.andsadroid.room.Database.Repositry;
import com.example.andsadroid.room.Model.Notes;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class    NoteViewModel extends ViewModel {
   Repositry repositry;
   LiveData<List<Notes>> allNote;



    public NoteViewModel(@NonNull Application application) {
         repositry=new Repositry(application);
        allNote=repositry.getAllNOTES();


    }

    public void insert(Notes notes){
        repositry.insert(notes);
    }
    public void update(Notes notes){
        repositry.update(notes);
    }
    public void delete(Notes notes){
        repositry.delete(notes);
    }
    public void deleteAllNOTES(){
        repositry.deleteAllNotes();
    } public LiveData<List<Notes>> getAllNOTES(){
        return  repositry.getAllNOTES();
    }
}

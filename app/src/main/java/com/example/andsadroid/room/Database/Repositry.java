package com.example.andsadroid.room.Database;

import android.app.Application;
import android.os.AsyncTask;

import com.example.andsadroid.room.Model.Notes;

import java.util.List;

import androidx.lifecycle.LiveData;

public class Repositry {
    public NoteDao notedao;
    LiveData<List<Notes>> notes;

    public Repositry(Application aplication) {
        NoteDatabase roomDatabase=NoteDatabase.getInstance(aplication);
        notedao=roomDatabase.noteDao();
        notes=notedao.getAllnotes();

    }


    public void insert(Notes note){
        new InserTNoteAsynTask(notedao).execute(note);

    }

    public void delete(Notes note){

     new DeleteNoteAsynTask(notedao).execute(note);
    }
    public void update(Notes note){
     new UpdateNoteAsynTask(notedao).execute(note);
    }
    public void deleteAllNotes(){
        new DeleteAllNotesAsynTask(notedao).execute();
    }
    public LiveData<List<Notes>> getAllNOTES(){
        return notes;
    }

    private static class InserTNoteAsynTask extends AsyncTask<Notes,Void,Void>{
     private NoteDao noteDao_as;
        public InserTNoteAsynTask(NoteDao noteDao) {
            this.noteDao_as = noteDao;
        }


        @Override
        protected Void doInBackground(Notes... notes) {
          noteDao_as.insert(notes[0]);
            return null;
        }
    }
    private static class UpdateNoteAsynTask extends AsyncTask<Notes,Void,Void>{
        private NoteDao noteDao_as;

        public UpdateNoteAsynTask(NoteDao noteDao) {
            this.noteDao_as = noteDao;
        }


        @Override
        protected Void doInBackground(Notes... notes) {
            noteDao_as.update(notes[0]);
            return null;
        }
    }
    private static class DeleteNoteAsynTask extends AsyncTask<Notes,Void,Void> {
    private NoteDao noteDao_as;

    public DeleteNoteAsynTask(NoteDao noteDao) {
        this.noteDao_as = noteDao;
    }


    @Override
    protected Void doInBackground(Notes... notes) {
        noteDao_as.delete(notes[0]);
        return null;
    }
}

 private static   class DeleteAllNotesAsynTask extends AsyncTask<Void,Void,Void>{
        private NoteDao noteDao_as;

        public DeleteAllNotesAsynTask(NoteDao noteDao) {
            this.noteDao_as = noteDao;
        }


        @Override
        protected Void doInBackground(Void... voids) {
           noteDao_as.deleteAllNotes();
            return null;
        }
    }
}

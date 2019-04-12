package id.ac.polinema.notesapp.repositories;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

import id.ac.polinema.notesapp.dao.AppDatabase;
import id.ac.polinema.notesapp.dao.NoteDao;
import id.ac.polinema.notesapp.models.Note;

public class NoteRepository {
    private NoteDao noteDao;

    private LiveData<List<Note>> notes;

    public NoteRepository(Application application){
        AppDatabase db = AppDatabase.getInstance((application));
        noteDao = db.noteDao();
        notes = noteDao.getAll();
    }

    public void insert(Note note){
        new InsertAsyncTask(noteDao).execute(note);
    }

    public void update(Note note){
        new UpdateAsyncTask(noteDao).execute(note);
    }

    public LiveData<List<Note>> getNotes(){
        return notes;
    }

    private class InsertAsyncTask extends AsyncTask<Note,Void,Void > {
        public InsertAsyncTask(NoteDao noteDao) {
        }

        @Override
        protected Void doInBackground(Note... notes) {
            return null;
        }
    }

    private class UpdateAsyncTask extends AsyncTask<Note, Void, Void>{

        @Override
        protected Void doInBackground(Note... notes) {
            return null;
        }

        public  UpdateAsyncTask(NoteDao noteDao){
        }
    }
}

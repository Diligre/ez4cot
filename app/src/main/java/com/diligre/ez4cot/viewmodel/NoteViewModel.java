package com.diligre.ez4cot.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.diligre.ez4cot.model.Note;
import com.diligre.ez4cot.model.NoteRepository;

import java.util.List;

public class NoteViewModel extends AndroidViewModel {
    private NoteRepository repository;
    private LiveData<List<Note>> allNotes;

    public NoteViewModel(@NonNull Application application) {
        super(application);
        repository = new NoteRepository(application);
        allNotes = repository.getAllNotes();

    }



    public void update (Note note){
        repository.update(note);
    }




    public LiveData<List<Note>> getAllNotes(){
        return allNotes;
    }
}

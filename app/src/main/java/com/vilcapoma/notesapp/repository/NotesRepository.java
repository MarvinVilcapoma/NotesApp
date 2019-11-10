package com.vilcapoma.notesapp.repository;

import android.content.Context;
import android.widget.Toast;

import com.orm.SugarRecord;
import com.vilcapoma.notesapp.models.Notes;
import com.vilcapoma.notesapp.models.User;

import java.util.List;

public class NotesRepository {
    public static List<Notes> list(){
        List<Notes> notes = SugarRecord.listAll(Notes.class);
        return notes;
    }

    public static Notes Read(Long id){
        Notes note = SugarRecord.findById(Notes.class,id);
        return note;
    }

    public static void Create(String title,String content){
        Notes note = new Notes(title,content);
        SugarRecord.save(note);
    }

    public static void Update(Long id,String title,String content){
        Notes note = SugarRecord.findById(Notes.class,id);
        note.setTitle(title);
        note.setContent(title);
        SugarRecord.save(note);
    }

    public static void Delete(Long id){
        Notes note = SugarRecord.findById(Notes.class,id);
        SugarRecord.delete(note);
    }

}

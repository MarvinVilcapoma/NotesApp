package com.vilcapoma.notesapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.EditText;
import android.widget.Toast;

import com.vilcapoma.notesapp.R;
import com.vilcapoma.notesapp.repository.NotesRepository;


public class RegistroNotes extends AppCompatActivity {

    private EditText et_title;
    private EditText et_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_notes);

        et_title=(EditText)findViewById(R.id.title_input);
        et_content=(EditText)findViewById(R.id.content_input);


    }
    public void callRegisterForm(View view){
        String title=et_title.getText().toString();
        String content =et_content.getText().toString();

        if(title.isEmpty() || content.isEmpty()){
            Toast.makeText(this, "Es necesario completar todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }

        NotesRepository.Create(title,content);
        finish();

    }
}

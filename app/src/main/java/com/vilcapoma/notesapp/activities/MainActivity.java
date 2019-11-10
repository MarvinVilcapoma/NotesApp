package com.vilcapoma.notesapp.activities;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.vilcapoma.notesapp.R;
import com.vilcapoma.notesapp.adapters.NotesAdapter;
import com.vilcapoma.notesapp.fragments.ArchiverFragment;
import com.vilcapoma.notesapp.fragments.FavoriteFragment;
import com.vilcapoma.notesapp.fragments.HomeFragment;
import com.vilcapoma.notesapp.models.Notes;
import com.vilcapoma.notesapp.repository.NotesRepository;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView notesList;
    private BottomNavigationView menu;
    private TextView bienvenida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bienvenida = findViewById(R.id.bienvenida);
        bienvenida.setText("Bienvenido " + getIntent().getExtras().getString("fullname"));

        menu = findViewById(R.id.menu);
        menu.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.item1:
                        fragment1();
                        break;

                    case R.id.item2:
                        fragment2();
                        break;

                    case R.id.item3:
                        fragment3();
                        break;

                    case R.id.logout_item:
                        callLogout();
                        break;
                }
                return false;
            }
        });

        fragment1();

    }

    private void fragment1(){
        Fragment hf = new HomeFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.content, hf)
                .commit();
    }

    private void fragment2(){
        Fragment ff = new FavoriteFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.content, ff)
                .commit();
    }

    private void fragment3(){
        Fragment sf = new ArchiverFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.content, sf)
                .commit();
    }

    private void callLogout(){
        //Eliminar el estado isLogged del sp
        SharedPreferences sp= PreferenceManager.getDefaultSharedPreferences(this);
        sp.edit().remove("isLogged").commit();

        //Solo finalizamos
        finish();
        //Solo finalizamos o además redireccionamos al LoginActivity

        startActivity(new Intent(this,LoginActivity.class));

    }

}

package com.example.andsadroid.room.Ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;

import com.example.andsadroid.room.Events;
import com.example.andsadroid.room.Model.Notes;
import com.example.andsadroid.room.R;
import com.example.andsadroid.room.Adapters.RecycleAdapter;
import com.example.andsadroid.room.databinding.ActivityMainBinding;

import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;


public class MainActivity extends AppCompatActivity implements Events {

    NoteViewModel noteViewModel;
     RecycleAdapter adapter;
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       Views();
       SettingUpTheViewModel();
    }

    private void SettingUpTheViewModel() {
        noteViewModel = ViewModelProviders.of(this).get(NoteViewModel.class);
        // every time the data in the table changes this onchanged method is triggered ,
        // so the adapter data will change too ,based on the change that happened in the database
        noteViewModel.getAllNOTES().observe(this, new Observer<List<Notes>>() {
            @Override
            public void onChanged(@Nullable List<Notes> notes) {

                adapter.setNotes(notes);
            }
        });

    }

    private void Views() {
        binding= DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.recycleView.setLayoutManager(new LinearLayoutManager(this));
        adapter=new RecycleAdapter();
        binding.recycleView.setAdapter(adapter);
        binding.setEvents(this);
    }
    @Override
    public void onButtonclick() {
        startActivityForResult(new Intent(MainActivity.this, insert_note.class),1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if(resultCode == Activity.RESULT_OK){
                Notes note =new Notes(data.getStringExtra("title"),data.getStringExtra("description"));
                noteViewModel.insert(note);
            }
        }
    }
}

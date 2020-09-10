package com.example.andsadroid.room.Ui;

import android.content.Intent;
 import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.NumberPicker;

import com.example.andsadroid.room.Events;
import com.example.andsadroid.room.R;
import com.example.andsadroid.room.databinding.ActivityInsertNoteBinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
//open this activity for result
// enter the data that u want to insert without missing any field
//get the data and return it to the other activity

public class insert_note extends AppCompatActivity implements Events {

    EditText Titile_edt;
    EditText description_Edt;
    ActivityInsertNoteBinding binding;
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         Views();
     }

    private void Views() {
         binding= DataBindingUtil.setContentView(this,R.layout.activity_insert_note);
         binding.setEvents(this);
     }

    @Override
    public void onButtonclick() {
        if (description_Edt.getText().toString().trim().isEmpty() ||
                Titile_edt.getText().toString().trim().isEmpty())
        {
            return;
        }
        Intent intent=new Intent();
        intent.putExtra("title",Titile_edt.getText().toString().trim());
        intent.putExtra("description",description_Edt.getText().toString().trim());
        setResult(RESULT_OK,intent);
        finish();
    }
}

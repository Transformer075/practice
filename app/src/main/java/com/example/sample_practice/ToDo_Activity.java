package com.example.sample_practice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;

public class ToDo_Activity extends AppCompatActivity {

    Button add;
    EditText edit_name;
    ListView listView;
    ArrayList<String> friends;
    ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do);

        edit_name = findViewById(R.id.edit_name);
        listView = findViewById(R.id.list);
        add = findViewById(R.id.button4);

        friends = new ArrayList<String>();
        friends.add("Haseeb");
        friends.add("Saad");
        friends.add("Syed Ali");
        friends.add("Ahmed");

        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, friends);
        listView.setAdapter(arrayAdapter);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!edit_name.getText().toString().equals("")){
                    friends.add(edit_name.getText().toString());
                    Collections.sort(friends);
                    arrayAdapter.notifyDataSetChanged();

                }
            }
        });


    }
}
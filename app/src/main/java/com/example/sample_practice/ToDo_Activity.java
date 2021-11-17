package com.example.sample_practice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class ToDo_Activity extends AppCompatActivity {

    Button add;
    EditText edit_name;
    ListView listView;
    ArrayList<String> friends;
    //ArrayAdapter<String> arrayAdapter;
    MyArray arrayAdapter;
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

        arrayAdapter = new MyArray(this, friends);
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

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ToDo_Activity.this, "" + friends.get(position), Toast.LENGTH_SHORT).show();
            }
        });


    }
}
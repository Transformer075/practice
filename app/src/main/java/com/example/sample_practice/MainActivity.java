package com.example.sample_practice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn1;
    TextView textView1;
    TextView textView2;
    CheckBox checkBox1;
    Switch switch1;
    Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView1 = findViewById(R.id.name);
        textView2 = findViewById(R.id.result);
        btn1 = findViewById(R.id.btn_1);
        btn2 = findViewById(R.id.buttonSend);
        checkBox1 = findViewById(R.id.checkbox1);
        switch1 = findViewById(R.id.switch1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBox1.isChecked()) {
                    textView2.setText(textView1.getText().toString());
                }
                else
                    textView2.setText("Checkbox not checked");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = textView1.getText().toString();
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, message);
                startActivity(intent);
            }
        });

    }
    public void switchClicked(View view){
        if(switch1.isChecked()) {
            switch1.setText("On");
        }
        else
            switch1.setText("Off");
    }

    public void nextActivity(View view) {
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        intent.putExtra("key", textView1.getText().toString());
        startActivity(intent);
    }
}
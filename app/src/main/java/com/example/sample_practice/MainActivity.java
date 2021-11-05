package com.example.sample_practice;

import androidx.appcompat.app.AppCompatActivity;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView1 = findViewById(R.id.name);
        textView2 = findViewById(R.id.result);
        btn1 = findViewById(R.id.btn_1);
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

    }
    public void switchClicked(View view){
        if(switch1.isChecked()) {
            switch1.setText("On");
        }
        else
            switch1.setText("Off");
    }

}
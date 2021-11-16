package com.example.sample_practice;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btn1;
    TextView textView1;
    TextView textView2;
    CheckBox checkBox1;
    Switch switch1;
    Button btn2;

    String[] colors = {"Green, Red, Yellow"};
    ArrayList<Integer> selectedItems = new ArrayList();
    //String[] ary = getResources().getStringArray(R.array.ary);

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
        //textView1.setText(ary[1]);

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

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Select multiple colors");
        builder.setMultiChoiceItems(colors, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                if(isChecked)
                    selectedItems.add(which);
                else if(selectedItems.contains(which))
                    selectedItems.remove(Integer.valueOf(which));
            }
        });
        builder.setCancelable(false);

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String msg = "";
                for(int i=0; i< selectedItems.size(); i++){
                    msg = msg + "\n" + (i+1) + ": " + colors[selectedItems.get(i)];
                }
                Toast.makeText(MainActivity.this, "Total: "+ selectedItems.size() + " Items Selected.\n"+
                        msg, Toast.LENGTH_LONG).show();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "No option Selected", Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

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
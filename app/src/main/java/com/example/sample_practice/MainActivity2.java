package com.example.sample_practice;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    TextView textView1;
    TextView textView2;
    Button button;
    Button toastButton;
    Button btn_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textView1 = findViewById(R.id.txtview1);
        btn_next = findViewById(R.id.btn_nextt);

        Intent intent = getIntent();
        textView1.setText(intent.getStringExtra("key"));

        textView2 = findViewById(R.id.editTextPhone);
        button = findViewById(R.id.button);
        toastButton = findViewById(R.id.button3);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("tel:+923001234567");

                Intent intent = new Intent(Intent.ACTION_DIAL, uri);

                startActivity(intent);


            }
        });
//        btn_next.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d("T2", "onClick: btn_next");
//                Intent intent = new Intent(MainActivity2.this, ToDo_Activity.class);
//                startActivity(intent);
//            }
//        });

        Toast toast = Toast.makeText(this, "Hello, I am Haseeb", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.RIGHT, 100,10);
        toastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toast.show();
            }
        });

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity2.this);
        builder.setTitle("Continue");
        builder.setMessage("Do you want to Continue?");
        builder.setCancelable(false);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }

    public void Todo(View v){
        Log.d("T3", "Todo: ");
        Intent intent= new Intent(MainActivity2.this,ToDo_Activity.class);
        startActivity(intent);
    }
}
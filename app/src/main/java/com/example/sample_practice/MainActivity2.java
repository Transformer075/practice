package com.example.sample_practice;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    TextView textView1;
    TextView textView2;
    Button button;
    Button toastButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textView1 = findViewById(R.id.txtview1);
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

        Toast toast = Toast.makeText(this, "Hello, I am Haseeb", Toast.LENGTH_LONG);

        toastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toast.show();
            }
        });

    }
}
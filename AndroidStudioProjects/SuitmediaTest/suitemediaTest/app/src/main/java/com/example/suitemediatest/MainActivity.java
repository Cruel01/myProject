package com.example.suitemediatest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name, palindrom;
    Button check, next;
    String a = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        palindrom = findViewById(R.id.palindrom);
        check = findViewById(R.id.check);
        next = findViewById(R.id.next);

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String palindrom1 = palindrom.getText().toString();

                int strlength = palindrom1.length();

                for (int i = (strlength - 1); i >= 0; i--) {
                    a = a + palindrom1.charAt(i);
                }

                if (palindrom1.toLowerCase().equals(a.toLowerCase())) {
                    Toast.makeText(MainActivity.this, "Is a palindrome", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Is not a Palindrome", Toast.LENGTH_SHORT).show();
                }
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name1 = name.getText().toString();
                Intent save = new Intent(MainActivity.this, user.class);
                save.putExtra("name", name1);
                startActivity(save);

            }
        });

    }
}
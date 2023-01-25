package com.example.suitemediatest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class user extends AppCompatActivity {

    Button choose;
    TextView name;
    View back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        choose = findViewById(R.id.choose);
        back = findViewById(R.id.back);

        name = findViewById(R.id.name2);

        Intent name3 = getIntent();

        name.setText(name3.getStringExtra("name"));

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent save = new Intent(user.this, MainActivity.class);
                startActivity(save);
            }
        });

        choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent save = new Intent(user.this, listUser.class);
                startActivity(save);
            }
        });

    }
}
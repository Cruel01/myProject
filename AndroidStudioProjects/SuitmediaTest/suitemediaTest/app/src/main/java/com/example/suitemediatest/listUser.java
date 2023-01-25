package com.example.suitemediatest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class listUser extends AppCompatActivity {

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    Redapter adapter;
    List<post> post1 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_user);

        recyclerView = findViewById(R.id.view1);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new Redapter(post1);
        recyclerView.setAdapter(adapter);

        fetchPost();

    }

    private void fetchPost() {
        retrofit.getRetrofitClient().getPost().enqueue(new Callback<List<post>>() {
            @Override
            public void onResponse(Call<List<post>> call, Response<List<post>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    post1.addAll(response.body());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<post>> call, Throwable t) {
                Toast.makeText(listUser.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
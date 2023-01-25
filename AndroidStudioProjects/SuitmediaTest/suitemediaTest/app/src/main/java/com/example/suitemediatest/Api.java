package com.example.suitemediatest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    @GET("/users?page=2")
    Call<List<post>> getPost();
}

package com.example.suitemediatest;


import com.google.gson.annotations.SerializedName;

public class post {

    private String first_name;
    private String email;

    public post(String first_name, String email) {
        this.first_name = first_name;
        this.email = email;
    }

    public String getName() {
        return first_name;
    }

    public String getEmail() {
        return email;
    }
}

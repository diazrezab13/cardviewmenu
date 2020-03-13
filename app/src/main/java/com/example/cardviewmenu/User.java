package com.example.cardviewmenu;

public class User {

    private int id, login_count;
    private String username, email, gender;

    public User(int id, String username, String email, String gender, int login_count) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.gender = gender;
        this.login_count = login_count;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public int getLogin_count() {
        return login_count;
    }
}

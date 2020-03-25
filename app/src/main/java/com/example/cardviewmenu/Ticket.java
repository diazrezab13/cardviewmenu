package com.example.cardviewmenu;

public class Ticket {

    private int id,user_id;
    private Boolean hasUsed;

    public Ticket(int id, int user_id, boolean hasUsed) {
        this.id = id;
        this.user_id = user_id;
        this.hasUsed = hasUsed;
    }

    public int getId() {
        return id;
    }

    public int getUser_id() {
        return user_id;
    }

    public boolean gethasUsed() {
        return hasUsed;
    }
}

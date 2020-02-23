package com.example.cardviewmenu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class KudaPoniMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menukudaponi);
    }

    public void onClickBack2 (View v){
        Intent newIntent = new Intent(KudaPoniMenuActivity.this, GTicketActivity.class);
        finish();
        startActivity(newIntent);
    }

    public void onClickLeader (View v){
        Intent newIntent = new Intent(KudaPoniMenuActivity.this, LeaderboardActivity.class);
        finish();
        startActivity(newIntent);
    }
}

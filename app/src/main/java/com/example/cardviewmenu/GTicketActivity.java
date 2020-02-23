package com.example.cardviewmenu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class GTicketActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gticket);
    }
    public void onClickPlay (View v){
        Intent newIntent = new Intent(GTicketActivity.this, KudaPoniMenuActivity.class);
        finish();
        startActivity(newIntent);
    }
}

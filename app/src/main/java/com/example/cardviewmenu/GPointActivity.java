package com.example.cardviewmenu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class GPointActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gpoint);
    }

    public void onClickBack3 (View v){
        Intent newIntent = new Intent(GPointActivity.this, KudaPoniMenuActivity.class);
        finish();
        startActivity(newIntent);
    }
}

package com.example.cardviewmenu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cardviewmenu.voucherfragments.VoucherActivity;

public class GPointActivity extends AppCompatActivity {

    TextView txtPoint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gpoint);

        String username = getIntent().getStringExtra("USERNAME");
        String point = getIntent().getStringExtra("POINT");

        txtPoint = findViewById(R.id.txtGPoint);
        txtPoint.setText(point);
    }

    public void onClickBack3 (View v){
        Intent newIntent = new Intent(GPointActivity.this, KudaPoniMenuActivity.class);
        finish();
        startActivity(newIntent);
    }

    public void onClickRedeem (View v){
        Intent newIntent = new Intent(GPointActivity.this, VoucherActivity.class);
        finish();
        startActivity(newIntent);
    }
}

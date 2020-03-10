package com.example.cardviewmenu.voucherfragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cardviewmenu.GPointActivity;
import com.example.cardviewmenu.KudaPoniMenuActivity;
import com.example.cardviewmenu.R;
import com.example.cardviewmenu.leaderboardfragment.LeaderboardActivity;

public class VoucherActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voucher);
    }

    public void onClickBack4 (View v){
        Intent newIntent = new Intent(VoucherActivity.this, GPointActivity.class);
        finish();
        startActivity(newIntent);
    }
}

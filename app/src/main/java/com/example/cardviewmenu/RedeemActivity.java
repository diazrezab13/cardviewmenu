package com.example.cardviewmenu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cardviewmenu.voucherfragments.VoucherActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RedeemActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redeem);

        String Name = getIntent().getStringExtra("NAME");
        String Point = getIntent().getStringExtra("POINT");
        String Image = getIntent().getStringExtra("IMAGE");
        String Terms = getIntent().getStringExtra("TERMS");

        TextView point = (TextView) findViewById(R.id.txtPoint);
        ImageView imag = (ImageView) findViewById(R.id.imgVoucher);
        TextView name = (TextView) findViewById((R.id.txtTitle2));
        TextView terms = (TextView) findViewById((R.id.txtDetail));

        Button btnBack = (Button) findViewById(R.id.buttonBack1);
        Button btnBuy = (Button) findViewById(R.id.buttonBuy);

        point.setText(Point);
        name.setText(Name);
        terms.setText(Terms);
        Picasso.with(getApplicationContext())
                .load(Image)
                .into(imag);

        btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "belum gaes karena endpoint belum ada. :|", Toast.LENGTH_SHORT).show();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newIntent = new Intent(RedeemActivity.this, VoucherActivity.class);
                finish();
                startActivity(newIntent);
            }
        });
    }
}

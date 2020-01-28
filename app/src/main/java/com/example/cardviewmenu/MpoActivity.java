package com.example.cardviewmenu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cardviewmenu.pulsafragments.PulsaActivity;

public class MpoActivity extends AppCompatActivity {

    private Button mBtLaunchPulsaActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mpo);

        mBtLaunchPulsaActivity = (Button) findViewById(R.id.buttonPulsa);

        mBtLaunchPulsaActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MpoActivity.this, PulsaActivity.class);
                startActivity(intent);
            }
        });
    }
}

package com.example.cardviewmenu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.cardviewmenu.pulsafragments.Step1Fragment;
import com.example.cardviewmenu.registrationfragments.page_email;
import com.example.cardviewmenu.registrationfragments.page_otp;
import com.example.cardviewmenu.registrationfragments.page_password;
import com.example.cardviewmenu.registrationfragments.page_userdata;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;

public class RegistrationActivity extends AppCompatActivity {
    private ViewPager pg;
    private PagerAdapter pa;
    private Button btnBack;
    CircleIndicator circleIndicator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        loadFragment();

        btnBack = (Button) findViewById(R.id.buttonBack5);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Intent newIntent = new Intent(RegistrationActivity.this, LoginActivity.class);
                startActivity(newIntent);
            }
        });;
    }

    private void loadFragment() {
        getSupportFragmentManager().beginTransaction()
                .add(R.id.frame_layout, new page_userdata())
                .commit();
    }

}

package com.example.cardviewmenu;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

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
    CircleIndicator circleIndicator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        circleIndicator = findViewById(R.id.circleIndicator2);

        List<Fragment> lFragment= new ArrayList<>();
        lFragment.add(new page_userdata());
        lFragment.add(new page_otp());
        lFragment.add(new page_email());
        lFragment.add(new page_password());

        pg = findViewById(R.id.registrationpage);
        pa = new HomeSlider(getSupportFragmentManager(), lFragment);
        pg.setAdapter(pa);
        circleIndicator.setViewPager(pg);
    }

}

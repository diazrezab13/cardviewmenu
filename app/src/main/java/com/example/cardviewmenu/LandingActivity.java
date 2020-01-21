package com.example.cardviewmenu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.cardviewmenu.homefragments.page_home;
import com.example.cardviewmenu.homefragments.page_home2;
import com.example.cardviewmenu.homefragments.page_home3;
import com.example.cardviewmenu.homefragments.page_home4;
import com.example.cardviewmenu.homefragments.page_home5;

import java.util.ArrayList;
import java.util.List;

public class LandingActivity extends AppCompatActivity implements View.OnClickListener {
    private ViewPager pg;
    private PagerAdapter pa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        List<Fragment> lFragment= new ArrayList<>();
        lFragment.add(new page_home());
        lFragment.add(new page_home2());
        lFragment.add(new page_home3());
        lFragment.add(new page_home4());
        lFragment.add(new page_home5());

        pg = findViewById(R.id.homepage);
        pa = new HomeSlider(getSupportFragmentManager(), lFragment);
        pg.setAdapter(pa);
    }

    @Override
    public void onClick (View v){
        Intent newIntent = new Intent(LandingActivity.this, MainActivity.class);
        startActivity(newIntent);
    }
}

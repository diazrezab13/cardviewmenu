package com.example.cardviewmenu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.example.cardviewmenu.iklanfragments.iklan_num1;
import com.example.cardviewmenu.iklanfragments.iklan_num2;
import com.example.cardviewmenu.iklanfragments.iklan_num3;
import com.example.cardviewmenu.leaderboardfragment.LeaderboardAdapter;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;

public class LeaderboardActivity extends AppCompatActivity {
    private ViewPager pg;
    private PagerAdapter pa;
    CircleIndicator circleIndicator;
    RecyclerView recyclerView;
    LeaderboardAdapter adapter;
//    RequestQueue queue; //to load JSON data


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);

        circleIndicator = findViewById(R.id.circleIndicator);

        List<Fragment> lFragment= new ArrayList<>();
        lFragment.add(new iklan_num1());
        lFragment.add(new iklan_num2());
        lFragment.add(new iklan_num3());

        pg = findViewById(R.id.iklanleaderboard);
        pa = new HomeSlider(getSupportFragmentManager(), lFragment);
        pg.setAdapter(pa);
        circleIndicator.setViewPager(pg);

        recyclerView =findViewById(R.id.recycleLeaderboard);
        adapter = new LeaderboardAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        queue = Volley.newRequestQueue(this); //to load JSON data
//        queue.add(getFashion("harry%20potter")); //to load JSON data
    }


    public void onClickBack3 (View v){
        Intent newIntent = new Intent(LeaderboardActivity.this, KudaPoniMenuActivity.class);
        finish();
        startActivity(newIntent);
    }

    public void leftClick (View v){
        pg.arrowScroll(ViewPager.FOCUS_LEFT);
    }

    public void rightClick (View v){
        pg.arrowScroll(ViewPager.FOCUS_RIGHT);
    }
}

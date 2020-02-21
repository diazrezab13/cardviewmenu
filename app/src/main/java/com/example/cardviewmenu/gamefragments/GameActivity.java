package com.example.cardviewmenu.gamefragments;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cardviewmenu.MainActivity;
import com.example.cardviewmenu.R;
import com.example.cardviewmenu.SharedPrefManager;
import com.example.cardviewmenu.pulsafragments.Step1Fragment;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity {

    public static int position = 0;
    private Button mBtBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        loadComponent();
        loadFragment();
    }

        private void loadComponent() {

            mBtBack = (Button) findViewById(R.id.buttonback);

            mBtBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onBackBtnPressed();
                }
            });
        }

        private void loadFragment() {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.frame_layout, new Step1GameFragment())
                    .commit();
        }

        @Override
        public void onBackPressed() {
            finish();
            super.onBackPressed();
        }

        public void onBackBtnPressed() {
            position--;
//            if (position == 1) {
//                backToStepBiodataDiri();
//            } else if (position == 2) {
//                backToStepOrangTua();
//            }
            super.onBackPressed();
        }

    }


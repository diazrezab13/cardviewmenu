package com.example.cardviewmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import android.os.Handler;



public class GameActivity extends AppCompatActivity {
    boolean doubleBackToExitPressedOnce = false;

    WebView wv;
    String URL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        URL = "https://kelompoktigab.000webhostapp.com/lalala/index.html";
        wv=(WebView)findViewById(R.id.web);
        wv.getSettings().setJavaScriptEnabled(true);
        wv.loadUrl(URL);
        wv.setWebViewClient(new WebViewClient());
        Toast.makeText(getApplicationContext(),"Jawab Pertanyaannya Untuk Mendapatkan Hadiah !", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        if(wv.canGoBack()){
            wv.goBack();
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Mainkan Hingga Akhir Untuk Mendapatkan Hadiah !", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 10);
    }
}

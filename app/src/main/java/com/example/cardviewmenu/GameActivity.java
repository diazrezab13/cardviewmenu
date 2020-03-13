package com.example.cardviewmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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
        Toast.makeText(getApplicationContext(),"Jawab Pertanyaan & Dapatkan Hadiah !", Toast.LENGTH_SHORT).show();
    }

    public void onClickBack (View v){
        Intent newIntent = new Intent(GameActivity.this, GTicketActivity.class);
        finish();
        startActivity(newIntent);
    }
}

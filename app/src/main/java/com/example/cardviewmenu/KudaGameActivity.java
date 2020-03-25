package com.example.cardviewmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import android.os.Handler;



public class KudaGameActivity extends AppCompatActivity {
    boolean doubleBackToExitPressedOnce = false;

    WebView wv;
    String URL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuda_game);
        URL = "https://kelompoktigab.000webhostapp.com/dakota/index.html";
        wv=(WebView)findViewById(R.id.web);
        wv.addJavascriptInterface(new WebAppInterface(this), "AndroidInterface");
        wv.getSettings().setJavaScriptEnabled(true);
        wv.loadUrl(URL);
        wv.setWebViewClient(new WebViewClient());
        Toast.makeText(getApplicationContext(),"Jawab Pertanyaan & Dapatkan Hadiah !", Toast.LENGTH_SHORT).show();
    }

    public void onClickBack (View v){
        Intent newIntent = new Intent(KudaGameActivity.this, GTicketActivity.class);
        finish();
        startActivity(newIntent);
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

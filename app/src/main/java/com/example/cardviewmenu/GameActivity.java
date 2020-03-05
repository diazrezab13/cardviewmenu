package com.example.cardviewmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity {

    WebView wv;
    String URL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        URL = "https://kelompoktigab.000webhostapp.com/keltigabaru/index.html";
        wv=(WebView)findViewById(R.id.web);
        wv.getSettings().setJavaScriptEnabled(true);
        wv.loadUrl(URL);
        wv.setWebViewClient(new WebViewClient());
        Toast.makeText(getApplicationContext(),"tesasjdklaj", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {
        if(wv.canGoBack()){
            wv.goBack();
        }else{
            super.onBackPressed();
        }
    }
}

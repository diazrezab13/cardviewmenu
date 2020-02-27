package com.example.cardviewmenu;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cardviewmenu.leaderboardfragment.LeaderboardActivity;

public class KudaPoniMenuActivity extends AppCompatActivity {
    Button popupAgreement;
    TextView popupClosed;
    RelativeLayout agreementLayout;
    PopupWindow popupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menukudaponi);

        popupAgreement = (Button) findViewById(R.id.buttonTerm);

        agreementLayout = (RelativeLayout) findViewById(R.id.layoutKudaPoni);
        popupAgreement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater layoutInflater = (LayoutInflater) KudaPoniMenuActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View newView = layoutInflater.inflate(R.layout.popup_termncond, null);
                popupClosed =  newView.findViewById(R.id.txtAgree);
                popupWindow = new PopupWindow(newView, RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                popupWindow.showAtLocation(agreementLayout, Gravity.CENTER, 0, 0);
                popupClosed.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popupWindow.dismiss();
                    }
                });

            }
        });


    }

    public void onClickBack2 (View v){
        Intent newIntent = new Intent(KudaPoniMenuActivity.this, GTicketActivity.class);
        finish();
        startActivity(newIntent);
    }

    public void onClickLeader (View v){
        Intent newIntent = new Intent(KudaPoniMenuActivity.this, LeaderboardActivity.class);
        finish();
        startActivity(newIntent);
    }

    public void onClickPoin (View v){
        Intent newIntent = new Intent(KudaPoniMenuActivity.this, GPointActivity.class);
        finish();
        startActivity(newIntent);
    }

}

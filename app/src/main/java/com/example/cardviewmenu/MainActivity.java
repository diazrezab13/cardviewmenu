package com.example.cardviewmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button mBtLaunchMpoActivity;
    private Button mBtLogout;
    private TextView TextViewUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextViewUsername = (TextView) findViewById(R.id.TxtUser);
        mBtLaunchMpoActivity = (Button) findViewById(R.id.buttonMpo);
        mBtLogout = (Button) findViewById(R.id.buttonLogout);

        User user = SharedPrefManager.getInstance(this).getUser();

        TextViewUsername.setText(String.valueOf(user.getUsername()));

        mBtLaunchMpoActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MpoActivity.class);
                startActivity(intent);
            }
        });

        mBtLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                SharedPrefManager.getInstance(getApplicationContext()).logout();
            }
        });
    }
}

package com.example.cardviewmenu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private Button mBtLaunchMpoActivity;
    private Button mBtLogout;
    private TextView TextViewUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
//        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
//                R.id.navigation_home, R.id.navigation_history, R.id.navigation_notification, R.id.navigation_profile)
//                .build();
//        //NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
//
//        TextViewUsername = (TextView) findViewById(R.id.TxtUser);
//        mBtLaunchMpoActivity = (Button) findViewById(R.id.buttonMpo);
//        mBtLogout = (Button) findViewById(R.id.buttonLogout);

        BottomNavigationView navView = findViewById(R.id.nav_view);
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupWithNavController(navView, navController);

        User user = SharedPrefManager.getInstance(this).getUser();

//        TextViewUsername.setText(String.valueOf(user.getUsername()));
//
//        mBtLaunchMpoActivity.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, MpoActivity.class);
//                startActivity(intent);
//            }
//        });

//        mBtLogout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                finish();
//                SharedPrefManager.getInstance(getApplicationContext()).logout();
//            }
//        });
    }
}

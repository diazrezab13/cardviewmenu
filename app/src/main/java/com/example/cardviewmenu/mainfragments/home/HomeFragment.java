package com.example.cardviewmenu.mainfragments.home;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.cardviewmenu.GTicketActivity;
import com.example.cardviewmenu.MpoActivity;
import com.example.cardviewmenu.R;
import com.example.cardviewmenu.SharedPrefManager;
import com.example.cardviewmenu.User;

import org.w3c.dom.Text;

public class HomeFragment extends Fragment {
//    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        User user = SharedPrefManager.getInstance(rootView.getContext()).getUser();

        TextView textView_Username = rootView.findViewById(R.id.TxtUser);
        textView_Username.setText(String.valueOf(user.getUsername()));

        Button button_Mpo = rootView.findViewById(R.id.buttonMpo);
        button_Mpo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(rootView.getContext(), MpoActivity.class);
                startActivity(intent);
            }
        });

        Button button_GTicket = rootView.findViewById(R.id.buttonGTicket);
        button_GTicket.setOnClickListener(new View.OnClickListener ()  {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(rootView.getContext(), GTicketActivity.class);
                startActivity(intent);
            }
        });

        Button button_Logout = rootView.findViewById(R.id.buttonLogout);
        button_Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPrefManager.getInstance(rootView.getContext()).logout();
                ((Activity) rootView.getContext()).finish();
            }
        });







//        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);

//        final TextView textView = root.findViewById(R.id.text_home);
//        homeViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        return rootView;
    }}

package com.example.cardviewmenu.mainfragments.home;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
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
        int loginCount = user.getLogin_count();

        if(loginCount == 0){
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    PopUpHome popUpClass = new PopUpHome();
                    popUpClass.showPopupWindow(rootView);
                }
            }, 100);
        }

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

        return rootView;
    }
}

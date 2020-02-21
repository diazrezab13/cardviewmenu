package com.example.cardviewmenu.gamefragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.cardviewmenu.R;

import java.util.ArrayList;

public class Step3GameFragment extends Fragment implements View.OnClickListener {

    private View view;
    private Button buttonBack;

    public Step3GameFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_game_tiket, container, false);
        loadComponent();
        return view;
    }

    private void loadComponent() {
//        buttonBack = (Button) view.findViewById(R.id.buttonback);
//        buttonBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == buttonBack) {

            getFragmentManager().beginTransaction()
                    .replace(R.id.frame_layout, new Step1GameFragment())
                    .addToBackStack(null)
                    .commit();
        }
    }
}


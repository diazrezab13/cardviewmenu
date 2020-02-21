package com.example.cardviewmenu.gamefragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.cardviewmenu.R;
import com.example.cardviewmenu.pulsafragments.PulsaActivity;
import com.example.cardviewmenu.pulsafragments.Step2Fragment;

import java.util.ArrayList;

public class Step1GameFragment extends Fragment implements View.OnClickListener {

    private View view;
    private EditText editTextNamaLengkap;
    private Spinner spinnerPulsa;
    private Button buttonPodium;

    public Step1GameFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_game_main, container, false);
        loadComponent();
        return view;
    }

    private void loadComponent() {
        buttonPodium = (Button) view.findViewById(R.id.buttonPodium);
        buttonPodium.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == buttonPodium) {

            getFragmentManager().beginTransaction()
                    .replace(R.id.frame_layout, new Step2GameFragment())
                    .commit();
        }
    }
}




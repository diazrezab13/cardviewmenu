package com.example.cardviewmenu.registrationfragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.cardviewmenu.R;
import com.example.cardviewmenu.pulsafragments.PulsaActivity;
import com.example.cardviewmenu.pulsafragments.Step1Fragment;
import com.example.cardviewmenu.pulsafragments.Step2Fragment;

import java.util.ArrayList;

public class page_email extends Fragment implements View.OnClickListener {

    private EditText editEmail;
    private Button btnNext;
    private View view;
    private String nama;
    private String nomor;

    public page_email() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.page_email, container, false);
        Bundle bundle = getArguments();
        nama = bundle.getString("nama");
        nomor = bundle.getString("nomor");

        loadComponent();
        return view;
    }

    @Override
    public void onClick(View view) {
        if (view == btnNext) {
            String email = editEmail.getText().toString().trim();

            boolean InputEmpty = checkInput(email);

            if(!InputEmpty){
                page_password Page_password = new page_password();
                Bundle bundle = new Bundle();
                bundle.putString("email", email);
                bundle.putString("nama", nama);
                bundle.putString("nomor", nomor);
                Page_password.setArguments(bundle);
                getFragmentManager().beginTransaction()
                        .setCustomAnimations(R.anim.slide_in_from_right, R.anim.slide_out_from_right, R.anim.slide_in_from_left, R.anim.slide_out_from_left)
                        .replace(R.id.frame_layout, Page_password)
                        .addToBackStack(null)
                        .commit();
            }
        }
    }

    private void loadComponent() {
        editEmail = (EditText) view.findViewById(R.id.inputEmail);
        btnNext = (Button) view.findViewById(R.id.arrow);
        btnNext.setOnClickListener(this);

    }

    private boolean checkInput(String email){

        if (email.matches("")) {
            Toast.makeText(this.getActivity(), "You did not enter a email", Toast.LENGTH_SHORT).show();
            return true;
        }

        return false;
    }
}

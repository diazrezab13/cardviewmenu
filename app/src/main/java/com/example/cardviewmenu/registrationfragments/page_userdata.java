package com.example.cardviewmenu.registrationfragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.cardviewmenu.R;

public class page_userdata extends Fragment implements View.OnClickListener{

    private EditText editNama;
    private EditText editNomorTelepon;
    private Button btnNext;
    private View view;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.page_userdata, container, false);
        loadComponent();

        return view;
    }

    @Override
    public void onClick(View view) {
        if (view == btnNext) {
            String nama = editNama.getText().toString().trim();
            String nomor = editNama.getText().toString().trim();

            boolean InputEmpty = checkInput(nama,nomor);

            if(!InputEmpty){
                page_email Page_email = new page_email();
                Bundle bundle = new Bundle();
                bundle.putString("nama", nama);
                bundle.putString("nomor", nomor);
                Page_email.setArguments(bundle);
                getFragmentManager().beginTransaction()
                        .setCustomAnimations(R.anim.slide_in_from_right, R.anim.slide_out_from_right, R.anim.slide_in_from_left, R.anim.slide_out_from_left)
                        .replace(R.id.frame_layout, Page_email)
                        .addToBackStack(null)
                        .commit();
            }
        }
    }

    private void loadComponent() {
        editNama = (EditText) view.findViewById(R.id.editName);
        editNomorTelepon = (EditText) view.findViewById(R.id.editPhone);
        btnNext = (Button) view.findViewById(R.id.arrow);
        btnNext.setOnClickListener(this);

    }

    private boolean checkInput(String nama, String nomor){

        if (nama.matches("")) {
            Toast.makeText(this.getActivity(), "You did not enter a nama", Toast.LENGTH_SHORT).show();
            return true;
        }

        if (nomor.matches("")) {
            Toast.makeText(this.getActivity(), "You did not enter a nomor", Toast.LENGTH_SHORT).show();
            return true;
        }

        return false;
    }
}

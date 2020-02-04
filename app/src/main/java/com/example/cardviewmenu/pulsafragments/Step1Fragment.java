package com.example.cardviewmenu.pulsafragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.fragment.app.Fragment;

import com.example.cardviewmenu.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Step1Fragment extends Fragment implements View.OnClickListener {

    private View view;
    private EditText editTextNamaLengkap;
    private Spinner spinnerPulsa;
    private Button buttonNext;

    public Step1Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_step1, container, false);
        loadComponent();
        return view;
    }



    private void loadComponent() {
        editTextNamaLengkap = (EditText) view.findViewById(R.id.edit_text_nama_lengkap);
        spinnerPulsa = (Spinner) view.findViewById(R.id.pulsaSpinner);
        buttonNext = (Button) view.findViewById(R.id.button_next_fragment_step_1);
        buttonNext.setOnClickListener(this);

        ArrayList<Nominal> contacts = new ArrayList<>();

        contacts.add(new Nominal("-", "-"));
        contacts.add(new Nominal("Rp 10.000-", "1"));
        contacts.add(new Nominal("Rp 20.000-", "2"));
        contacts.add(new Nominal("Rp 30.000-", "3"));
        contacts.add(new Nominal("Rp 40.000-", "4"));
        contacts.add(new Nominal("Rp 50.000-", "5"));
        contacts.add(new Nominal("Rp 60.000-", "6"));
        contacts.add(new Nominal("Rp 70.000-", "7"));
        contacts.add(new Nominal("Rp 80.000-", "8"));
        contacts.add(new Nominal("Rp 90.000-", "9"));
        contacts.add(new Nominal("Rp 100.000-", "10"));

        ArrayAdapter<Nominal> adapter =
                new ArrayAdapter<Nominal>(getActivity().getApplicationContext(),  android.R.layout.simple_spinner_dropdown_item, contacts);
        adapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item);

        spinnerPulsa.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {
        if (view == buttonNext) {
            String namaLengkap = editTextNamaLengkap.getText().toString().trim();
//            String alamat = editTextAlamat.getText().toString().trim();
            PulsaActivity.goToStepOrangTua();
            Step2Fragment step2Fragment = new Step2Fragment();
            Bundle bundle = new Bundle();
            bundle.putString("namaLengkap", namaLengkap.isEmpty() ? "-" : namaLengkap);
//            bundle.putString("alamat", alamat.isEmpty() ? "-" : alamat);
            step2Fragment.setArguments(bundle);
            getFragmentManager().beginTransaction()
                    .setCustomAnimations(R.anim.slide_in_from_right, R.anim.slide_out_from_right, R.anim.slide_in_from_left, R.anim.slide_out_from_left)
                    .replace(R.id.frame_layout, step2Fragment)
                    .addToBackStack(null)
                    .commit();

        }
    }

    private class Nominal {
        private String Nominal_name;
        private String Nominal_id;

        public Nominal() {
        }

        public Nominal(String nominal_name, String nominal_id) {
            this.Nominal_name = nominal_name;
            this.Nominal_id = nominal_id;
        }

        public String getNominal_name() {
            return Nominal_name;
        }

        public void setNominal_name(String nominal_name) {
            this.Nominal_name = nominal_name;
        }

        public String getNominal_id() {
            return Nominal_id;
        }

        public void setNominal_id(String nominal_id) {
            this.Nominal_id = nominal_id;
        }

        @Override
        public String toString() {
            return Nominal_name;
        }
    }
}

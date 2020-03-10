package com.example.cardviewmenu.pulsafragments;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.cardviewmenu.R;
import com.example.cardviewmenu.SharedPrefManager;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Step1Fragment extends Fragment {

    private View view;
    private EditText editTextNamaLengkap;
    private String Nominal;
    private ListView listView;

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

        //        buttonNext.setOnClickListener(this);

        ArrayList<Nominal> contacts = new ArrayList<>();

        contacts.add(new Nominal("-", "-"));
        editTextNamaLengkap.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                listView = (ListView) view.findViewById(R.id.listNominalPulsa);
                String[] listArray = {};

                if(start >= 3){
                    listArray = getResources().getStringArray(R.array.array_pulsa);
                    ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(getActivity(), R.layout.list_tes, listArray);
                    listView.setAdapter(adapter2);

                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            String nomor = editTextNamaLengkap.getText().toString().trim();
                            Nominal = "";

                            if (position == 0){
                                Nominal = "Rp 20000-";
                            }else if (position == 1) {
                                Nominal = "Rp 25000-";
                            }else if (position == 2){
                                Nominal = "Rp 50000-";
                            }else if (position == 3){
                                Nominal = "Rp 100000-";
                            }else if (position == 4){
                                Nominal = "Rp 200000-";
                            }

                            boolean InputEmpty = checkInput(nomor, Nominal);

                            if(!InputEmpty){
                                PulsaActivity.goToStepOrangTua();
                                Step2Fragment step2Fragment = new Step2Fragment();
                                Bundle bundle = new Bundle();
                                bundle.putString("nomor", nomor);
                                bundle.putString("nominal", Nominal);
                                step2Fragment.setArguments(bundle);
                                getFragmentManager().beginTransaction()
                                        .setCustomAnimations(R.anim.slide_in_from_right, R.anim.slide_out_from_right, R.anim.slide_in_from_left, R.anim.slide_out_from_left)
                                        .replace(R.id.frame_layout, step2Fragment)
                                        .addToBackStack(null)
                                        .commit();
                            }

                        }
                    });
                }else {
                    ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, listArray);
                    listView.setAdapter(adapter2);
                }


            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



    }

    private boolean checkInput(String nomor, String nominal){

        if (nomor.matches("")) {
            Toast.makeText(this.getActivity(), "You did not enter a nomor", Toast.LENGTH_SHORT).show();
            return true;
        }

        if (nominal.matches("")) {
            Toast.makeText(this.getActivity(), "You did not enter nominal", Toast.LENGTH_SHORT).show();
            return true;
        }

        return false;
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

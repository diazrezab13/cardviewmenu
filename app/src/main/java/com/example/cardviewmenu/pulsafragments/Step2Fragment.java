package com.example.cardviewmenu.pulsafragments;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cardviewmenu.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Step2Fragment extends Fragment implements View.OnClickListener {

    private View view;
    private Button buttonNext;
    private String nomor;
    private String nominal;
    private Spinner spinnerBank;
    private TextView textViewNomor;
    private TextView textViewNominal;

    public Step2Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_step2, container, false);
        loadComponent();
        return view;
    }

    private void loadComponent() {
        textViewNomor = (TextView) view.findViewById(R.id.text_view_nomor_hp);
        textViewNominal = (TextView) view.findViewById(R.id.text_view_nominal);
        spinnerBank = (Spinner) view.findViewById(R.id.bankSpinner);
        buttonNext = (Button) view.findViewById(R.id.button_next_fragment_step_2);
        buttonNext.setOnClickListener(this);

        Bundle bundle = getArguments();
        nomor = bundle.getString("nomor");
        nominal = bundle.getString("nominal");

        textViewNomor.setText(nomor);
        textViewNominal.setText(nominal);

        ArrayList<Bank> banks = new ArrayList<>();

        banks.add(new Bank("-", "-"));
        banks.add(new Bank("BNI", "1"));
        banks.add(new Bank("BRI", "2"));
        banks.add(new Bank("MANDIRI", "3"));

        ArrayAdapter<Bank> adapter =
                new ArrayAdapter<Bank>(getActivity().getApplicationContext(),  android.R.layout.simple_spinner_dropdown_item, banks);
        adapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item);

        spinnerBank.setAdapter(adapter);

    }

    @Override
    public void onClick(View view) {
        if (view == buttonNext) {
            String bank = spinnerBank.getSelectedItem().toString();

            boolean bankEmpty = checkinput(bank);

            if (!bankEmpty){
                PulsaActivity.goToStepUlasan();
                Step3Fragment step3Fragment = new Step3Fragment();

                Bundle bundle = new Bundle();
                bundle.putString("nomor", nomor);
                bundle.putString("nominal", nominal);
                bundle.putString("bank", bank);

                step3Fragment.setArguments(bundle);
                getFragmentManager().beginTransaction()
                        .setCustomAnimations(R.anim.slide_in_from_right, R.anim.slide_out_from_right, R.anim.slide_in_from_left, R.anim.slide_out_from_left)
                        .replace(R.id.frame_layout, step3Fragment)
                        .addToBackStack(null)
                        .commit();
            }
        }
    }

    private boolean checkinput(String bank){
        if (bank.matches("-")) {
            Toast.makeText(this.getActivity(), "You did not enter a bank", Toast.LENGTH_SHORT).show();
            return true;
        }

        return false;
    }

    private class Bank {
        private String Bank_name;
        private String Bank_id;

        public Bank() {
        }

        public Bank(String Bank_name, String Bank_id) {
            this.Bank_name = Bank_name;
            this.Bank_id = Bank_id;
        }

        public String getNominal_name() {
            return Bank_name;
        }

        public void setBank_name(String Bank_name) {
            this.Bank_name = Bank_name;
        }

        public String getBank_id() {
            return Bank_id;
        }

        public void setBank_id(String nominal_id) {
            this.Bank_id = Bank_id;
        }

        @Override
        public String toString() {
            return Bank_name;
        }
    }
}

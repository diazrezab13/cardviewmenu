package com.example.cardviewmenu.pulsafragments;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.cardviewmenu.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Step2Fragment extends Fragment implements View.OnClickListener {

    private View view;
    private EditText editTextNamaIbu;
    private EditText editTextNamaAyah;
    private Button buttonNext;
    private String namaLengkap;
    private String alamat;

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
        editTextNamaIbu = (EditText) view.findViewById(R.id.edit_text_nama_ibu);
//        editTextNamaAyah = (EditText) view.findViewById(R.id.edit_text_nama_ayah);
        buttonNext = (Button) view.findViewById(R.id.button_next_fragment_step_2);
        buttonNext.setOnClickListener(this);

        Bundle bundle = getArguments();
        namaLengkap = bundle.getString("namaLengkap");
        alamat = bundle.getString("alamat");

        final ListView list = view.findViewById(R.id.list);
        ArrayList<SubjectData> arrayList = new ArrayList<SubjectData>();
        arrayList.add(new SubjectData("JAVA", "https://www.tutorialspoint.com/java/", "https://www.tutorialspoint.com/java/images/java-mini-logo.jpg"));
        arrayList.add(new SubjectData("Python", "https://www.tutorialspoint.com/python/", "https://www.tutorialspoint.com/python/images/python-mini.jpg"));
        arrayList.add(new SubjectData("Javascript", "https://www.tutorialspoint.com/javascript/", "https://www.tutorialspoint.com/javascript/images/javascript-mini-logo.jpg"));
        arrayList.add(new SubjectData("Android", "https://www.tutorialspoint.com/android/", "https://www.tutorialspoint.com/android/images/android-mini-logo.jpg"));
        LazyAdapter customAdapter = new LazyAdapter(this.getContext(), arrayList);
        list.setAdapter(customAdapter);
    }

    @Override
    public void onClick(View view) {
        if (view == buttonNext) {
            PulsaActivity.goToStepUlasan();
            String namaIbu = editTextNamaIbu.getText().toString().trim();
//            String namaAyah = editTextNamaAyah.getText().toString().trim();
            Step3Fragment step3Fragment = new Step3Fragment();
            Bundle bundle = new Bundle();
            bundle.putString("namaLengkap", namaLengkap);
            bundle.putString("alamat", alamat);
            bundle.putString("namaIbu", namaIbu.isEmpty() ? "-" : namaIbu);
//            bundle.putString("namaAyah", namaAyah.isEmpty() ? "-" : namaAyah);
            step3Fragment.setArguments(bundle);
            getFragmentManager().beginTransaction()
                    .setCustomAnimations(R.anim.slide_in_from_right, R.anim.slide_out_from_right, R.anim.slide_in_from_left, R.anim.slide_out_from_left)
                    .replace(R.id.frame_layout, step3Fragment)
                    .addToBackStack(null)
                    .commit();
        }
    }
}

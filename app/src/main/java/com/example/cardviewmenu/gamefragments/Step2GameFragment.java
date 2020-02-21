package com.example.cardviewmenu.gamefragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.fragment.app.Fragment;

import com.example.cardviewmenu.R;
import com.example.cardviewmenu.pulsafragments.Step2Fragment;

import java.util.ArrayList;

public class Step2GameFragment extends Fragment implements View.OnClickListener {

    private View view;
    private EditText editTextNamaLengkap;
    private Spinner spinnerPulsa;
    private Button button;

    public Step2GameFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_game_leaderboard, container, false);
        loadComponent();
        final ListView list = view.findViewById(R.id.list);
        ArrayList<SubjectData> arrayList = new ArrayList<SubjectData>();
        arrayList.add(new SubjectData("1", "Diovanny", "1000","https://www.tutorialspoint.com/java/images/java-mini-logo.jpg"));
        arrayList.add(new SubjectData("2", "Arum", "900","https://www.tutorialspoint.com/python/images/python-mini.jpg"));
        arrayList.add(new SubjectData("3", "Jojor", "800", "https://www.tutorialspoint.com/javascript/images/javascript-mini-logo.jpg"));
        arrayList.add(new SubjectData("4", "Taufiq", "700","https://www.tutorialspoint.com/cprogramming/images/c-mini-logo.jpg"));
        arrayList.add(new SubjectData("5", "Satrio", "600","https://www.tutorialspoint.com/cplusplus/images/cpp-mini-logo.jpg"));
        arrayList.add(new SubjectData("6", "Diaz", "500","https://www.tutorialspoint.com/android/images/android-mini-logo.jpg"));
        arrayList.add(new SubjectData("7", "Bryan", "400","https://www.tutorialspoint.com/java/images/java-mini-logo.jpg"));
        arrayList.add(new SubjectData("8", "Pramasita", "300","https://www.tutorialspoint.com/python/images/python-mini.jpg"));
        arrayList.add(new SubjectData("9", "Jennifer", "200","https://www.tutorialspoint.com/javascript/images/javascript-mini-logo.jpg"));
        arrayList.add(new SubjectData("10", "Firmansyah", "100","https://www.tutorialspoint.com/cprogramming/images/c-mini-logo.jpg"));
        LazyAdapter customAdapter = new LazyAdapter(view.getContext(), arrayList);
        list.setAdapter(customAdapter);
        return view;
    }

    private void loadComponent() {
//        buttonPodium = (Button) view.findViewById(R.id.buttonPodium);
//        buttonPodium.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
//        if (view == buttonPodium) {
//
//            Step2Fragment step2Fragment = new Step2Fragment();
//            getFragmentManager().beginTransaction()
//                    .replace(R.id.frame_layout, step2Fragment)
//                    .addToBackStack(null)
//                    .commit();
//        }
    }
}

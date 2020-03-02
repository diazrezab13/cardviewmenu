package com.example.cardviewmenu.mainfragments.profile;

import android.os.Bundle;
import android.app.ListActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;


import com.example.cardviewmenu.R;



public class ProfileFragment extends Fragment {
    private ProfileViewModel profileViewModel;
    ListView listView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        profileViewModel =
                ViewModelProviders.of(this).get(ProfileViewModel.class);
        View root = inflater.inflate(R.layout.fragment_profile, container, false);
        listView=(ListView) getView().findViewById(R.id.listViewProfile);
        String[] listProfileMenu = getResources().getStringArray(R.array.array_profile);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.fragment_profile,
                R.id.txtListProfile, listProfileMenu);
       listView.setAdapter(adapter);
        return root;
    }
    }


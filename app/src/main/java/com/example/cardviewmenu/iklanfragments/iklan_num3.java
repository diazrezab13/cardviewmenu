package com.example.cardviewmenu.iklanfragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.cardviewmenu.R;
import com.squareup.picasso.Picasso;

public class iklan_num3 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup vghome = (ViewGroup) inflater.inflate(R.layout.iklan_num3, container, false);

        ImageView imageView = (ImageView) vghome.findViewById(R.id.imgiklan3);
        Picasso.with(getActivity().getApplicationContext())
                .load("https://testdiaz.000webhostapp.com/disc_the_gade.jpeg")
                .into(imageView);
        return vghome;
    }
}

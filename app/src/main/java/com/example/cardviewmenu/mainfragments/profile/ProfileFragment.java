package com.example.cardviewmenu.mainfragments.profile;

import android.os.Bundle;
import android.app.ListActivity;
import android.provider.ContactsContract;
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
import com.example.cardviewmenu.SharedPrefManager;
import com.example.cardviewmenu.User;

public class ProfileFragment extends Fragment {

    private ProfileViewModel profileViewModel;
    private TextView txtUserProfile;

    public ProfileFragment(){
        // empty constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        profileViewModel = ViewModelProviders.of(this).get(ProfileViewModel.class);
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        User user = SharedPrefManager.getInstance(getActivity().getApplicationContext()).getUser();
        String username = String.valueOf(user.getUsername());

        txtUserProfile = (TextView) view.findViewById(R.id.txtUserProfile);
        txtUserProfile.setText(username);

        final ListView listView = (ListView) view.findViewById(R.id.listViewProfile);
        String[] listProfileMenu = getResources().getStringArray(R.array.array_profile);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, listProfileMenu);
        listView.setAdapter(adapter);

        final ListView listView2 = (ListView) view.findViewById(R.id.listViewProfile2);
        String[] listProfileMenu2 = getResources().getStringArray(R.array.array_profile_bottom);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, listProfileMenu2);
        listView2.setAdapter(adapter2);

        return view;
    }

}


package com.example.cardviewmenu.pulsafragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.cardviewmenu.MainActivity;
import com.example.cardviewmenu.R;
import com.example.cardviewmenu.SharedPrefManager;
import com.example.cardviewmenu.URLs;
import com.example.cardviewmenu.User;
import com.example.cardviewmenu.VolleySingleton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class Step3Fragment extends Fragment {

    private View view;
    private String nomor;
    private String nominal;
    private String bank;
    private String user_id;
    private Button buttonDone;
    private ImageView imagebank;
    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    List<String> expandableListTitle;
    private HashMap<String, List<String>> expandableListDetail;

    public Step3Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_step3, container, false);
        loadComponent();

        return view;
    }

    private void loadComponent() {
        User user = SharedPrefManager.getInstance(getContext()).getUser();
        Bundle bundle = getArguments();
        nomor = bundle.getString("nomor");
        nominal = bundle.getString("nominal");
        bank = bundle.getString("bank");
        imagebank = view.findViewById(R.id.list_image);

        if (bank == "MANDIRI"){
            imagebank.setImageResource(R.drawable.mandiri);
        }else if (bank == "BNI"){
            imagebank.setImageResource(R.drawable.bni);
        }else
            imagebank.setImageResource(R.drawable.bri_va);

        user_id = String.valueOf(user.getId());
        getData(bank);

        buttonDone = (Button) view.findViewById(R.id.button_done_fragment);
        buttonDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertPulsaData(nominal, user_id, nomor);
                Toast.makeText(getActivity(), "Transaksi Selesai", Toast.LENGTH_SHORT).show();
                getActivity().finish();
            }
        });
    }

    private void getData(final String bank) {
        final HashMap<String, List<String>> expandableList = new HashMap<String, List<String>>();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URLs.GET_BANK, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    //converting response to json object
                    JSONObject obj = new JSONObject(response);

                    //if no error in response
                    if (!obj.getBoolean("error")) {
                        Toast.makeText(view.getContext(), obj.getString("message"), Toast.LENGTH_SHORT).show();

                        JSONArray maindata = obj.getJSONArray("data");

                        for (int i = 0; i < maindata.length(); i++) {
                            JSONArray array = (JSONArray) maindata.getJSONArray(i);

                            for(int j = 0; j < array.length();j++){
                                JSONObject object = (JSONObject) array.get(j);
                                JSONArray object2 = object.getJSONArray("CHILD");

                                List<String> detail = new ArrayList<String>();
                                for(int k = 0; k < object2.length();k++){
                                    detail.add(object2.getString(k));
                                }

                                expandableList.put(object.getString("HEADER"), detail);
                            }
                        }

                        expandableListView = (ExpandableListView) view.findViewById(R.id.expandableListView);
                        expandableListDetail = expandableList;
                        expandableListTitle = new ArrayList<String>(expandableListDetail.keySet());
                        expandableListAdapter = new CustomExpandableListAdapter(getContext(), expandableListTitle, expandableListDetail);
                        expandableListView.setAdapter(expandableListAdapter);
                        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

                                @Override
                                public void onGroupExpand(int groupPosition) {
                                    Toast.makeText(getContext(),
                                            expandableListTitle.get(groupPosition) + " List Expanded.",
                                            Toast.LENGTH_SHORT).show();
                                }
                            });

                            expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

                                @Override
                                public void onGroupCollapse(int groupPosition) {
                                    Toast.makeText(getContext(),
                                            expandableListTitle.get(groupPosition) + " List Collapsed.",
                                            Toast.LENGTH_SHORT).show();

                                }
                            });

                            expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
                                @Override
                                public boolean onChildClick(ExpandableListView parent, View v,
                                                            int groupPosition, int childPosition, long id) {
                                    Toast.makeText(
                                            getContext(),
                                            expandableListTitle.get(groupPosition)
                                                    + " -> "
                                                    + expandableListDetail.get(
                                                    expandableListTitle.get(groupPosition)).get(
                                                    childPosition), Toast.LENGTH_SHORT
                                    ).show();
                                    return false;
                                }
                            });

                    } else {
                        Toast.makeText(getContext(), obj.getString("message"), Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("bank", bank);
                return params;
            }
        };

        VolleySingleton.getInstance(getContext()).addToRequestQueue(stringRequest);
    }

    private void insertPulsaData(final String nominal, final String user_id, final String nomor) {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URLs.INSERT_PULSA, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    //converting response to json object
                    JSONObject obj = new JSONObject(response);

                    //if no error in response
                    if (!obj.getBoolean("error")) {
                        Toast.makeText(getContext(), obj.getString("message"), Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(getContext(), obj.getString("message"), Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("user_id", user_id);
                params.put("nomor", nomor);
                params.put("nominal", nominal);
                return params;
            }
        };

        VolleySingleton.getInstance(getContext()).addToRequestQueue(stringRequest);
    }


}



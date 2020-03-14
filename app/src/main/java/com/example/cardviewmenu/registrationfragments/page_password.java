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

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.cardviewmenu.R;
import com.example.cardviewmenu.URLs;
import com.example.cardviewmenu.VolleySingleton;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class page_password extends Fragment implements View.OnClickListener {

    private EditText editPassword;
    private Button btnNext;
    private View view;
    private String nama;
    private String nomor;
    private String email;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.page_password, container, false);

        Bundle bundle = getArguments();
        nama = bundle.getString("nama");
        nomor = bundle.getString("nomor");
        email = bundle.getString("email");

        loadComponent();
        return view;
    }

    @Override
    public void onClick(View view) {
        if (view == btnNext) {
            String password = editPassword.getText().toString().trim();

            boolean InputEmpty = checkInput(password);

            if(!InputEmpty){
                insertRegistrasiData(nama,password,email,nomor);
                getActivity().finish();
            }
        }
    }

    private void loadComponent() {
        editPassword = (EditText) view.findViewById(R.id.inputPassword);
        btnNext = (Button) view.findViewById(R.id.arrow);
        btnNext.setOnClickListener(this);

    }

    private boolean checkInput(String email){

        if (email.matches("")) {
            Toast.makeText(this.getActivity(), "You did not enter a email", Toast.LENGTH_SHORT).show();
            return true;
        }

        return false;
    }

    private void insertRegistrasiData(final String username, final String password, final String email, final String nomor) {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URLs.URL_SIGN_UP, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    //converting response to json object
                    JSONObject obj = new JSONObject(response);

                    //if no error in response
                    if (!obj.getBoolean("error")) {
                        Toast.makeText(getActivity().getApplicationContext(), obj.getString("message"), Toast.LENGTH_SHORT).show();

                        Toast.makeText(getActivity(), "Registrasi Selesai", Toast.LENGTH_SHORT).show();


                    } else {
                        Toast.makeText(getActivity().getApplicationContext(), obj.getString("message"), Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getActivity().getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("username", nama);
                params.put("password", password);
                params.put("email", email);
                params.put("gender", "male");
                return params;
            }
        };

        VolleySingleton.getInstance(getContext()).addToRequestQueue(stringRequest);
    }
}

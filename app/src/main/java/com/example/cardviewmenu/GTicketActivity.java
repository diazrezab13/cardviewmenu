package com.example.cardviewmenu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GTicketActivity extends AppCompatActivity {

    TextView txtTicketRemain;
    Button btnMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gticket);
        btnMain = (Button) findViewById(R.id.buttonPlay);
        btnMain.setEnabled(false);
        getTicket();
    }
    public void onClickPlay (View v){
        validateTicket();
    }

    public void onClickBack (View v){
        Intent newIntent = new Intent(GTicketActivity.this, MainActivity.class);
        finish();
        startActivity(newIntent);
    }

    private void getTicket(){
        User user = SharedPrefManager.getInstance(getApplicationContext()).getUser();
        final String user_id = String.valueOf(user.getId());

        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar1);
        progressBar.setVisibility(View.VISIBLE);

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URLs.GET_USER_ACTIVE_TICKET, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    //converting response to json object
                    JSONObject obj = new JSONObject(response);

                    //if no error in response
                    if (!obj.getBoolean("error")) {
                        JSONArray arrayTicket = obj.getJSONArray("data");

                        JSONObject tiket = (JSONObject) arrayTicket.get(0);

                        Ticket data = new Ticket(
                                tiket.getInt("id"),
                                tiket.getInt("user_id"),
                                tiket.getBoolean("has_used")
                        );

                        txtTicketRemain = findViewById(R.id.txtGTicket);
                        txtTicketRemain.setText(arrayTicket.length() + " G-Ticket");

                        SharedPrefManager.getInstance(getApplicationContext()).userPlay(data);

                        progressBar.setVisibility(View.GONE);
                        btnMain.setEnabled(true);
                        Toast.makeText(getApplicationContext(), obj.getString("message"), Toast.LENGTH_SHORT).show();
                    } else {
                        txtTicketRemain = findViewById(R.id.txtGTicket);
                        txtTicketRemain.setText("0 G-Ticket");

                        progressBar.setVisibility(View.GONE);
                        Toast.makeText(getApplicationContext(), obj.getString("message"), Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressBar.setVisibility(View.GONE);
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("user_id", user_id);
                return params;
            }
        };

        VolleySingleton.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);
    }

    private void validateTicket(){
        User user = SharedPrefManager.getInstance(getApplicationContext()).getUser();
        final String user_id = String.valueOf(user.getId());

        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar1);
        progressBar.setVisibility(View.VISIBLE);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URLs.VALIDATE_TICKET_USAGE, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    //converting response to json object
                    JSONObject obj = new JSONObject(response);

                    //if no error in response
                    if (!obj.getBoolean("error")) {
                        progressBar.setVisibility(View.GONE);
                        Toast.makeText(getApplicationContext(), obj.getString("message"), Toast.LENGTH_SHORT).show();

                        Intent newIntent = new Intent(GTicketActivity.this, KudaPoniMenuActivity.class);
                        finish();
                        startActivity(newIntent);
                    } else {
                        progressBar.setVisibility(View.GONE);
                        Toast.makeText(getApplicationContext(), obj.getString("message"), Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressBar.setVisibility(View.GONE);
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("user_id", user_id);
                return params;
            }
        };

        VolleySingleton.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);
    }
}

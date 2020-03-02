package com.example.cardviewmenu;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.cardviewmenu.leaderboardfragment.LeaderboardActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class KudaPoniMenuActivity extends AppCompatActivity {
    Button popupAgreement;
    TextView popupClosed;
    RelativeLayout agreementLayout;
    PopupWindow popupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menukudaponi);

        popupAgreement = (Button) findViewById(R.id.buttonTerm);

        agreementLayout = (RelativeLayout) findViewById(R.id.layoutKudaPoni);
        popupAgreement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater layoutInflater = (LayoutInflater) KudaPoniMenuActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View newView = layoutInflater.inflate(R.layout.popup_termncond, null);
                popupClosed =  newView.findViewById(R.id.txtAgree);
                popupWindow = new PopupWindow(newView, RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                popupWindow.showAtLocation(agreementLayout, Gravity.CENTER, 0, 0);
                popupClosed.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popupWindow.dismiss();
                    }
                });

            }
        });
    }

    public void onClickBack2 (View v){
        Intent newIntent = new Intent(KudaPoniMenuActivity.this, GTicketActivity.class);
        finish();
        startActivity(newIntent);
    }

    public void onClickLeader (View v){
        Intent newIntent = new Intent(KudaPoniMenuActivity.this, LeaderboardActivity.class);
        finish();
        startActivity(newIntent);
    }

    public void onClickPoin (View v){
        getPoint();
    }

    private void getPoint(){
        User user = SharedPrefManager.getInstance(getApplicationContext()).getUser();
        final String user_id = String.valueOf(user.getId());

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URLs.GET_USER_POINT, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    //converting response to json object
                    JSONObject obj = new JSONObject(response);

                    //if no error in response
                    if (!obj.getBoolean("error")) {
                        Toast.makeText(getApplicationContext(), obj.getString("message"), Toast.LENGTH_SHORT).show();

                        JSONObject object = obj.getJSONObject("data");
                        Intent newIntent = new Intent(KudaPoniMenuActivity.this, GPointActivity.class);
                        newIntent.putExtra("USERNAME", object.getString("username"));
                        newIntent.putExtra("POINT", object.getString("point"));
                        finish();
                        startActivity(newIntent);

                    } else {
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

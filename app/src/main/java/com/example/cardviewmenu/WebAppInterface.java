package com.example.cardviewmenu;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class WebAppInterface {
    Context mContext;

    // Instantiate the interface and set the context
    WebAppInterface(Context c) {
        mContext = c;
    }

    // Show a toast from the web page
    @JavascriptInterface
    public void showToast(String toast) {
//        ((Activity) mContext).finish();
//        Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
        savePoint(toast);
    }

    @JavascriptInterface
    public int getAndroidVersion() {
        return android.os.Build.VERSION.SDK_INT;
    }

    @JavascriptInterface
    public void showAndroidVersion(String versionName) {
        Toast.makeText(mContext, versionName, Toast.LENGTH_SHORT).show();
    }

    private void savePoint(final String point){
        User user = SharedPrefManager.getInstance(mContext).getUser();
        final String user_id = String.valueOf(user.getId());

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URLs.GET_USER_POINT, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    //converting response to json object
                    JSONObject obj = new JSONObject(response);

                    //if no error in response
                    if (!obj.getBoolean("error")) {
                        Toast.makeText(mContext, obj.getString("message"), Toast.LENGTH_SHORT).show();

//                        JSONObject object = obj.getJSONObject("data");
//                        Intent newIntent = new Intent(KudaPoniMenuActivity.this, GPointActivity.class);
//                        newIntent.putExtra("USERNAME", object.getString("username"));
//                        newIntent.putExtra("POINT", object.getString("point"));
                        ((Activity) mContext).finish();
//                        startActivity(newIntent);

                    } else {
                        Toast.makeText(mContext, obj.getString("message"), Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(mContext, error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("user_id", user_id);
                params.put("point", user_id);
                params.put("flag", "PLUS");
                params.put("source", "Game");
                return params;
            }
        };

        VolleySingleton.getInstance(mContext).addToRequestQueue(stringRequest);
    }

}
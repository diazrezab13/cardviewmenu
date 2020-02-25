package com.example.cardviewmenu.leaderboardfragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.cardviewmenu.HomeSlider;
import com.example.cardviewmenu.KudaPoniMenuActivity;
import com.example.cardviewmenu.R;
import com.example.cardviewmenu.SharedPrefManager;
import com.example.cardviewmenu.URLs;
import com.example.cardviewmenu.User;
import com.example.cardviewmenu.VolleySingleton;
import com.example.cardviewmenu.iklanfragments.iklan_num1;
import com.example.cardviewmenu.iklanfragments.iklan_num2;
import com.example.cardviewmenu.iklanfragments.iklan_num3;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import me.relex.circleindicator.CircleIndicator;

public class LeaderboardActivity extends AppCompatActivity {
    private ViewPager pg;
    private PagerAdapter pa;
    CircleIndicator circleIndicator;
    RecyclerView recyclerView;
    LeaderboardAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);

        circleIndicator = findViewById(R.id.circleIndicator);

        List<Fragment> lFragment= new ArrayList<>();
        lFragment.add(new iklan_num1());
        lFragment.add(new iklan_num2());
        lFragment.add(new iklan_num3());

        pg = findViewById(R.id.iklanleaderboard);
        pa = new HomeSlider(getSupportFragmentManager(), lFragment);
        pg.setAdapter(pa);
        circleIndicator.setViewPager(pg);

        getLeaderboardData();


    }


    public void onClickBack3 (View v){
        Intent newIntent = new Intent(LeaderboardActivity.this, KudaPoniMenuActivity.class);
        finish();
        startActivity(newIntent);
    }

    private void getLeaderboardData() {
        User user = SharedPrefManager.getInstance(getApplicationContext()).getUser();
        final String user_id = String.valueOf(user.getId());

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URLs.GET_RANKING, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    //converting response to json object
                    JSONObject obj = new JSONObject(response);

                    //if no error in response
                    if (!obj.getBoolean("error")) {

                        final ListView list = findViewById(R.id.list);
                        JSONObject maindata = obj.getJSONObject("data");
                        JSONArray globalrankarray = maindata.getJSONArray("global_rank");
//                        JSONObject userrank = maindata.getJSONObject("current_user_rank");

                        ArrayList<Leaderboard> arrayList = new ArrayList<Leaderboard>();

                        for (int i = 0; i < globalrankarray.length(); i++) {
                            JSONObject object = (JSONObject) globalrankarray.get(i);
                            arrayList.add(new Leaderboard(object.getString("rank"), object.getString("username"), object.getString("total_point"),"https://www.tutorialspoint.com/java/images/java-mini-logo.jpg"));
                        }
                        arrayList.add(new Leaderboard("", "", "","https://www.tutorialspoint.com/java/images/java-mini-logo.jpg"));
//                        arrayList.add(new Leaderboard(userrank.getString("rank"), userrank.getString("username"), userrank.getString("total_point"),"https://www.tutorialspoint.com/java/images/java-mini-logo.jpg"));
                        LeaderboardAdapter customAdapter = new LeaderboardAdapter(getApplicationContext(), arrayList);
                        list.setAdapter(customAdapter);

                        Toast.makeText(getApplicationContext(), obj.getString("message"), Toast.LENGTH_SHORT).show();
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

    public void leftClick (View v){
        pg.arrowScroll(ViewPager.FOCUS_LEFT);
    }

    public void rightClick (View v){
        pg.arrowScroll(ViewPager.FOCUS_RIGHT);
    }
}

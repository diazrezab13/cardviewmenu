package com.example.cardviewmenu;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.List;

public class HomeSlider extends FragmentStatePagerAdapter {
    private List<Fragment> fragmentList;
    public HomeSlider(FragmentManager fm, List<Fragment> fragmentList){
        super(fm);
        this.fragmentList = fragmentList;
    }

    @Override
    public Fragment getItem (int pos){
        return fragmentList.get(pos);
    }

    @Override
    public int getCount(){
        return fragmentList.size();
    }


//    private Context context;
//    private LayoutInflater layoutInflater;
//
//
//    @Override
//    public boolean isViewFromObject(View view, Object object) {
//        return view == object;
//    }
//
//    @Override
//    public Object instantiateItem(ViewGroup container, final int position) {
//
//        final Fragment o = fragmentList.get(position);
//        LayoutInflater inflater = (LayoutInflater) act.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        View v = inflater.inflate(R.layout.activity_landing, container, false);
//
//        TextView title = (TextView) v.findViewById(R.id.txtWelcome);
//        title.setText(o.name);
//
//        ((ViewPager) container).addView(v);
//        return v;
//
//    }
//
//    @Override
//    public void destroyItem(ViewGroup container, int position, Object object) {
//
//        ViewPager vp = (ViewPager) container;
//        View view = (View) object;
//        vp.removeView(view);
//
//    }

}

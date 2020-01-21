package com.example.cardviewmenu;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

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

}

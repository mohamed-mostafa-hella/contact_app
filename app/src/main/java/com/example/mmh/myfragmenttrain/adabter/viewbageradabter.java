package com.example.mmh.myfragmenttrain.adabter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class viewbageradabter extends FragmentPagerAdapter {

    private ArrayList<Fragment> fragmentArrayList=new ArrayList<>();

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return "";
    }

    public viewbageradabter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentArrayList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentArrayList.size();
    }
    public void add(Fragment fragment){
        fragmentArrayList.add(fragment);
    }
}

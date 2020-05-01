package com.example.mmh.myfragmenttrain.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mmh.myfragmenttrain.R;
import com.example.mmh.myfragmenttrain.adabter.viewbageradabter;

public class main_call_fragment extends Fragment {

    View v;
    ViewPager viewPager;
    TabLayout tabLayout;
    com.example.mmh.myfragmenttrain.adabter.viewbageradabter viewbageradabter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.main_call_fragment,container,false);
        viewPager=v.findViewById(R.id.viewbager);
        tabLayout=v.findViewById(R.id.tablayout);
        viewbageradabter=new viewbageradabter(getFragmentManager());
        viewbageradabter.add(new call_fragment());
        viewbageradabter.add(new group_fragment());
        viewbageradabter.add(new fav_fragment());
        viewPager.setAdapter(viewbageradabter);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_call);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_group);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_fav);

        return v;
    }
}

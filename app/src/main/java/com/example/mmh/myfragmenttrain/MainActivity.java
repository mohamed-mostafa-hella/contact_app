package com.example.mmh.myfragmenttrain;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.mmh.myfragmenttrain.fragment.main_call_fragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().replace(R.id.call_fragment_contener,new main_call_fragment()).commit();
    }
}

package com.example.myapplication;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.fragments.PageFragment1;
import com.example.myapplication.fragments.PageFragment2;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    private ViewPager pager;
    private PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        List<Fragment> list = new ArrayList<>();
        list.add(new PageFragment1());
        list.add(new PageFragment2());

        pager = findViewById(R.id.vp);
        pagerAdapter = new SlidePagerAdapter(getSupportFragmentManager(), list);

        pager.setAdapter(pagerAdapter);
    }
    public void onClickSignIn(View view){
        Intent intent = new Intent(this, Sign_In.class);
        startActivity(intent);
    }

    public void onClickSignUp(View view){
        Intent intent = new Intent(this, Sign_Up.class);
        startActivity(intent);
    }

}
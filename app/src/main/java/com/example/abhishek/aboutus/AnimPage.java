package com.example.abhishek.aboutus;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class AnimPage extends AppCompatActivity {

    ViewPager viewPager;
    AnimFrag_1 a= new AnimFrag_1();
    AnimFrag_2 b = new AnimFrag_2();
    AnimFrag_3 c = new AnimFrag_3();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        final FragmentAdapter fragmentAdapter = new FragmentAdapter(getSupportFragmentManager());
        viewPager.setAdapter(fragmentAdapter);
        viewPager.setOffscreenPageLimit(3);
        viewPager.setPageTransformer(true, new DepthPageTransformer());

    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}

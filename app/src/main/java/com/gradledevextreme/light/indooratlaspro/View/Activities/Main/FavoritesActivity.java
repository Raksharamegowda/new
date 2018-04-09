package com.gradledevextreme.light.indooratlaspro.View.Activities.Main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Window;
import android.view.WindowManager;

import com.gradledevextreme.light.indooratlaspro.View.Adapters.CustomPagerAdapter;
import com.gradledevextreme.light.indooratlaspro.R;

/**
 * Activity showing favorite locations stored in database
 * within viewpager fragments
 */

public class FavoritesActivity extends FragmentActivity {

    CustomPagerAdapter mCustomPagerAdapter;
    ViewPager mPager;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        //to remove status bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.favourites);


        mCustomPagerAdapter = new CustomPagerAdapter(getSupportFragmentManager(), this);

        mPager = findViewById(R.id.mPager);
        mPager.setAdapter(mCustomPagerAdapter);
        TabLayout tabLayout =findViewById(R.id.mSlidingTabs);
        tabLayout.setupWithViewPager(mPager);
    }
}

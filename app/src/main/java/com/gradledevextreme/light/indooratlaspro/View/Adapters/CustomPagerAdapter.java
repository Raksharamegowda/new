package com.gradledevextreme.light.indooratlaspro.View.Adapters;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import com.gradledevextreme.light.indooratlaspro.Service.Database.DatabaseHandler;
import com.gradledevextreme.light.indooratlaspro.Model.Position;
import com.gradledevextreme.light.indooratlaspro.View.Fragment.CommonViewPagerFragment;
import com.gradledevextreme.light.indooratlaspro.View.Activities.Main.AllLocationActivity;
import com.gradledevextreme.light.indooratlaspro.View.Activities.Main.FavoritesActivity;

import java.util.List;



public class CustomPagerAdapter extends FragmentPagerAdapter {

    private Context mContext;
    private int mCount;
    private DatabaseHandler db;
    private List<Position> mPosition;

    public CustomPagerAdapter(FragmentManager fragmentManager, FavoritesActivity favourites) {
        super(fragmentManager);
        this.mContext = favourites;
        db = new DatabaseHandler(mContext);
        mPosition = db.getFav();
        mCount = db.getFavCount();
    }

    public CustomPagerAdapter(FragmentManager fragmentManager, AllLocationActivity allLocation) {
        super(fragmentManager);
        this.mContext = allLocation;
        db = new DatabaseHandler(mContext);
        mPosition = db.getAllpos();
        mCount = db.getcount();
    }


    @Override
    public Fragment getItem(int position) {


        Fragment fragment = new CommonViewPagerFragment();

        Bundle args = new Bundle();
        args.putString("name", mPosition.get(position).getname());
        args.putString("lat", String.valueOf(mPosition.get(position).getlat()));
        args.putString("lon", String.valueOf(mPosition.get(position).getlog()));

        fragment.setArguments(args);

        return fragment;

    }

    @Override
    public int getCount() {

        return mCount;

    }
}

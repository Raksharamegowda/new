package com.gradledevextreme.light.indooratlaspro.View.Activities.Wayfinding;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.maps.model.LatLng;
import com.gradledevextreme.light.indooratlaspro.View.Activities.DialogActivities.DialogActivity;

/*
Wayfinding Activity inheriting Base Wayfinding Activity
and used to add location by clicking on Map
 */
public class WayfindingOverlayAddLocActivity extends WayfindingOverlayBaseActivity {

    public static Double mAddlocationLat;
    public static Double mAddlocationLon;

    @Override
    public void onMapClick(LatLng point) {
        super.onMapClick(point);

        //Passing it to fav activity
        mAddlocationLat = point.latitude;
        mAddlocationLon = point.longitude;


        //Intent to DialogActivity
        Intent i = new Intent(WayfindingOverlayAddLocActivity.this, DialogActivity.class);
        startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}

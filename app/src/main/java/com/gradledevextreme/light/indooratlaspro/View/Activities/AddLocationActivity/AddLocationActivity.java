package com.gradledevextreme.light.indooratlaspro.View.Activities.AddLocationActivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.gradledevextreme.light.indooratlaspro.Util.Constants;
import com.gradledevextreme.light.indooratlaspro.View.Activities.DialogActivities.DialogActivity;
import com.gradledevextreme.light.indooratlaspro.R;
import com.gradledevextreme.light.indooratlaspro.View.Activities.Wayfinding.WayfindingOverlayAddLocActivity;

/**
 * Addlocation activity that have addmap location and addcurrent location
 */
public class AddLocationActivity extends AppCompatActivity {

    private LinearLayout usingMapLocation, usingCurrentLocation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //to remove status bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_location);

        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);


        //Declaration
        usingMapLocation = findViewById(R.id.usingMapLocation);
        usingCurrentLocation = findViewById(R.id.usingCurrentLocation);


        usingCurrentLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Constants.mDialog = true;
                Intent i = new Intent(AddLocationActivity.this, DialogActivity.class);
                startActivity(i);

            }
        });

        usingMapLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Constants.mDialog = false;
                Intent i = new Intent(AddLocationActivity.this, WayfindingOverlayAddLocActivity.class);
                startActivity(i);
            }
        });

    }
}

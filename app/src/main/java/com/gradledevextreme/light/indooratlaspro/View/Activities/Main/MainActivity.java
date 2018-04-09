package com.gradledevextreme.light.indooratlaspro.View.Activities.Main;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.gradledevextreme.light.indooratlaspro.View.Activities.AddLocationActivity.AddLocationActivity;
import com.gradledevextreme.light.indooratlaspro.R;
import com.indooratlas.android.sdk.IALocation;
import com.indooratlas.android.sdk.IALocationListener;
import com.indooratlas.android.sdk.IALocationManager;
import com.indooratlas.android.sdk.IALocationRequest;

/*
MainActivity displaying buttons for alllocation,
favoritelocation and addlocation
 */
public class MainActivity extends AppCompatActivity {
    public static double lat;
    public static double lng;
    IALocationManager mIALocationManager;
    private LinearLayout mImageViewNavigation, mWayFindingNav, mAddLocationNav;
    SharedPreferences mSettings;
    SharedPreferences.Editor mEditor;
    public static final String PREFS_NAME = "MyPrefsFile";
    private boolean mToast = true;


    IALocationListener iaLocationListener = new IALocationListener() {
        @Override
        public void onLocationChanged(IALocation iaLocation) {
            lat = iaLocation.getLatitude();
            lng = iaLocation.getLongitude();
            if (mToast) {
                Toast.makeText(MainActivity.this, "Started", Toast.LENGTH_SHORT).show();
                mToast = false;
            }
        }

        @Override
        public void onStatusChanged(String s, int i, Bundle bundle) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //to remove status bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Declaration
        mImageViewNavigation = findViewById(R.id.imageViewNav);
        mWayFindingNav = findViewById(R.id.wayFindingNav);
        mAddLocationNav = findViewById(R.id.addlocations);
        mIALocationManager = mIALocationManager.create(this);
        mIALocationManager.requestLocationUpdates(IALocationRequest.create(), iaLocationListener);

        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);


        // to add shared preferences variable
        mSettings = getSharedPreferences(MainActivity.PREFS_NAME, 0);
        mEditor = mSettings.edit();
        mEditor.putBoolean("hasLoggedIn", true);
        mEditor.commit();


        mImageViewNavigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), AllLocationActivity.class);

                startActivity(i);

            }
        });

        mWayFindingNav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), FavoritesActivity.class);
                startActivity(i);
            }
        });

        mAddLocationNav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, AddLocationActivity.class);
                startActivity(i);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        mIALocationManager.requestLocationUpdates(IALocationRequest.create(), iaLocationListener);

    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mIALocationManager.removeLocationUpdates(iaLocationListener);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finishAffinity();
    }
}

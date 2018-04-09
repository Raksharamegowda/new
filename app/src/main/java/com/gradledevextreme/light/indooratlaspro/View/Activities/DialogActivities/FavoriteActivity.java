package com.gradledevextreme.light.indooratlaspro.View.Activities.DialogActivities;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.gradledevextreme.light.indooratlaspro.Service.Database.DatabaseHandler;
import com.gradledevextreme.light.indooratlaspro.Model.Position;
import com.gradledevextreme.light.indooratlaspro.Util.Constants;
import com.gradledevextreme.light.indooratlaspro.View.Activities.Main.MainActivity;
import com.gradledevextreme.light.indooratlaspro.R;
import com.gradledevextreme.light.indooratlaspro.View.Activities.Wayfinding.WayfindingOverlayAddLocActivity;

/**
 * Activity showing favorite dialog box to add current and map location to favorites in database
 */

public class FavoriteActivity extends Activity {

    private Button btnYes, btnNo;
    private String value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        final DatabaseHandler db = new DatabaseHandler(this);
        db.getWritableDatabase();
        super.onCreate(savedInstanceState);

        value = getIntent().getStringExtra("value");

        setContentView(R.layout.favorite);

        btnYes = findViewById(R.id.btnYes);
        btnNo = findViewById(R.id.btnNo);

        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (Constants.mDialog) {
                    db.addloc(new Position(DialogActivity.name, MainActivity.lat, true, MainActivity.lng));
                    Log.d("laT", "" + MainActivity.lat);
                    Log.d("laTg", "" + MainActivity.lng);
                    Log.d("Reading: ", "Reading all contacts..");
                    db.getAllpos();
                    FavoriteActivity.this.finish();
                }else{
                    db.addloc(new Position(DialogActivity.name, WayfindingOverlayAddLocActivity.mAddlocationLat, true, WayfindingOverlayAddLocActivity.mAddlocationLon));
                    Log.d("Lat ", "" + MainActivity.lat);
                    Log.d("Latg ", "" + MainActivity.lng);
                    db.getAllpos();
                    FavoriteActivity.this.finish();
                }
            }

        });

        btnNo.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (Constants.mDialog) {
                    db.addloc(new Position(DialogActivity.name, MainActivity.lat, false, MainActivity.lng));
                    db.getAllpos();
                    FavoriteActivity.this.finish();
                }else{
                    db.addloc(new Position(DialogActivity.name, WayfindingOverlayAddLocActivity.mAddlocationLat, false, WayfindingOverlayAddLocActivity.mAddlocationLon));
                    db.getAllpos();
                    FavoriteActivity.this.finish();
                }
            }
        });

    }
}

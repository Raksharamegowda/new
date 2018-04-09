package com.gradledevextreme.light.indooratlaspro.View.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.gradledevextreme.light.indooratlaspro.R;
import com.gradledevextreme.light.indooratlaspro.View.Activities.Wayfinding.WayfindingOverlayShowRouteActivity;

/**
 * Created by kchauhan on 05-03-2018.
 */

public class CommonViewPagerFragment extends Fragment {


    private String lat;
    private String lon;
    private Button name;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout resource that'll be returned
        View rootView = inflater.inflate(R.layout.fragment_demo, container, false);

        name = rootView.findViewById(R.id.name);

        // Get the arguments that was supplied when
        // the fragment was instantiated in the
        // CustomPagerAdapter

        Bundle args = getArguments();


        if (args.getString("name") == null) {
            name.setText("No Location Added Yet.....");
        }
        //((TextView) rootView.findViewById(R.id.text1)).setText(args.getString("name"));
        name.setText(args.getString("name"));

        lat = args.getString("lat");
        lon = args.getString("lon");

        name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), WayfindingOverlayShowRouteActivity.class);
                i.putExtra("lat", lat.toString());
                Log.d("Lati", lat.toString());
                i.putExtra("lon", lon.toString());
                Log.d("Latg", lon.toString());
                startActivity(i);
            }
        });


        return rootView;
    }


}

package com.gradledevextreme.light.indooratlaspro.View.Activities.Wayfinding;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;
import com.indooratlas.android.sdk.resources.IAFloorPlan;
import com.indooratlas.android.wayfinding.IARoutingLeg;
/*
Wayfinding Activity inheriting Base Wayfinding Activity
and used to show route to user and to perform
navigation
 */

public class WayfindingOverlayShowRouteActivity extends WayfindingOverlayBaseActivity {

    private String mCustomViewPagerLat;
    private String mCustomViewPagerLon;
    private int mValueRounded = 5;
    private int mValuePath = 5;
    private double mTemp = 562143;
    private double mTempPath = 562143;
    private static int timer = 21;
    String dir;

    @Override
    public void onMapClick(LatLng point) {
        super.onMapClick(point);
    }

    @Override
    public void setupGroundOverlay(IAFloorPlan floorPlan, Bitmap bitmap) {
        super.setupGroundOverlay(floorPlan, bitmap);


        //calling onMap click to show route
        onMapClick(new LatLng(Double.parseDouble(mCustomViewPagerLat), Double.parseDouble(mCustomViewPagerLon)));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //getting lat lon from demo fragment
        mCustomViewPagerLat = getIntent().getStringExtra("lat");
        mCustomViewPagerLon = getIntent().getStringExtra("lon");


    }

    @Override
    public void visualizeRoute(IARoutingLeg[] legs) {String dire;
        super.visualizeRoute(legs);

        //Calling getDirections
        if (legs[0].getLength() < 1.5) {
            getDirections(legs[1], legs[2]);
        } else {
            getDirections(legs[0], legs[1]);
        }


    }

    public void getDirections(final IARoutingLeg leg0, final IARoutingLeg leg1) {


        //logic for direction message

        if (leg0.getDirection() < 2.7 && leg0.getDirection() > 2.3) {
            mValueRounded = 0;
            //west
        } else if (leg0.getDirection() > -0.7 && leg0.getDirection() < 0) {
            mValueRounded = 1;
            //east

        } else if (leg0.getDirection() > 0.7 && leg0.getDirection() < 1.2) {
            mValueRounded = 2;
            //north
        } else if (leg0.getDirection() > -2.2 && leg0.getDirection() < -1.9) {
            mValueRounded = 3;
            //south
        }

        if (mTemp != mValueRounded) {
            if (leg0.getDirection() < 2.7 && leg0.getDirection() > 2.3) {
                //west
                if (mTemp == 562143) {
                    Toast.makeText(getApplicationContext(), "go straight  ", Toast.LENGTH_SHORT).show();

                } else if (mTemp == 3) {
                    Toast.makeText(getApplicationContext(), "go right  ", Toast.LENGTH_SHORT).show();
                } else if (mTemp == 2) {
                    Toast.makeText(getApplicationContext(), "go left  ", Toast.LENGTH_SHORT).show();
                } else if (mTemp == 1) {
                    Toast.makeText(getApplicationContext(), "go back  ", Toast.LENGTH_SHORT).show();
                }

            } else if (leg0.getDirection() > -0.7 && leg0.getDirection() < 0) {
                //east
                if (mTemp == 562143) {
                    Toast.makeText(getApplicationContext(), "go straight  ", Toast.LENGTH_SHORT).show();
                } else if (mTemp == 3) {
                    Toast.makeText(getApplicationContext(), "go left  ", Toast.LENGTH_SHORT).show();
                } else if (mTemp == 2) {
                    Toast.makeText(getApplicationContext(), "go right  ", Toast.LENGTH_SHORT).show();
                } else if (mTemp == 0) {
                    Toast.makeText(getApplicationContext(), "go back  ", Toast.LENGTH_SHORT).show();
                }


            } else if (leg0.getDirection() > 0.7 && leg0.getDirection() < 1.2) {
                //north
                if (mTemp == 562143) {
                    Toast.makeText(getApplicationContext(), "go straight  ", Toast.LENGTH_SHORT).show();
                } else if (mTemp == 3) {
                    Toast.makeText(getApplicationContext(), "go back  ", Toast.LENGTH_SHORT).show();
                } else if (mTemp == 1) {
                    Toast.makeText(getApplicationContext(), "go left  ", Toast.LENGTH_SHORT).show();
                } else if (mTemp == 0) {
                    Toast.makeText(getApplicationContext(), "go right  ", Toast.LENGTH_SHORT).show();
                }

            } else if (leg0.getDirection() > -2.2 && leg0.getDirection() < -1.9) {
                //south
                if (mTemp == 562143) {
                    Toast.makeText(getApplicationContext(), "go straight  ", Toast.LENGTH_SHORT).show();

                } else if (mTemp == 0) {

                    Toast.makeText(getApplicationContext(), "go left  ", Toast.LENGTH_SHORT).show();
                } else if (mTemp == 2) {
                    Toast.makeText(getApplicationContext(), "go back  ", Toast.LENGTH_SHORT).show();
                } else if (mTemp == 1) {
                    Toast.makeText(getApplicationContext(), "go right  ", Toast.LENGTH_SHORT).show();
                }

            }
        }
        mTemp = mValueRounded;
        Log.v("go", "next");


        //optimisation

        //Timer for running it after every 5 seconds

        if (timer % 20 == 0) {
            if (leg1.getDirection() < 2.7 && leg1.getDirection() > 2.3) {
                mValuePath = 0;
                //west
            } else if (leg1.getDirection() > -0.7 && leg1.getDirection() < 0) {
                mValuePath = 1;
                //east

            } else if (leg1.getDirection() > 0.7 && leg1.getDirection() < 1.2) {
                mValuePath = 2;
                //north
            } else if (leg1.getDirection() > -2.2 && leg1.getDirection() < -1.9) {
                mValuePath = 3;
                //south
            }


            if (mValueRounded != mValuePath) {

                double mLengthRoundOff = Math.round(leg0.getLength() * 10.0) / 10.0;

                if (mTemp == 0) {
                    if (mValuePath == 3) {
                        Toast.makeText(getApplicationContext(), "move straight uptoa" + mLengthRoundOff + " and go left ", Toast.LENGTH_SHORT).show();
                    } else if (mValuePath == 2) {
                        Toast.makeText(getApplicationContext(), "move straight uptoa" + mLengthRoundOff + "and go right  ", Toast.LENGTH_SHORT).show();
                    } else if (mValuePath == 1) {
                        Toast.makeText(getApplicationContext(), "move straight uptoa" + mLengthRoundOff + "and go back  ", Toast.LENGTH_SHORT).show();
                    }


                } else if (mTemp == 1) {

                    if (mValuePath == 3) {
                        Toast.makeText(getApplicationContext(), "move straight uptob" + mLengthRoundOff + "and go right  ", Toast.LENGTH_SHORT).show();
                    } else if (mValuePath == 2) {
                        Toast.makeText(getApplicationContext(), "move straight uptob" + mLengthRoundOff + "and go left  ", Toast.LENGTH_SHORT).show();
                    } else if (mValuePath == 0) {
                        Toast.makeText(getApplicationContext(), "move straight uptob" + mLengthRoundOff + "and go back  ", Toast.LENGTH_SHORT).show();
                    }


                } else if (mTemp == 2) {

                    if (mValuePath == 3) {
                        Toast.makeText(getApplicationContext(), "move straight uptoc" + mLengthRoundOff + "and go back  ", Toast.LENGTH_SHORT).show();
                    } else if (mValuePath == 1) {
                        Toast.makeText(getApplicationContext(), "move straight uptoc" + mLengthRoundOff + "and go right  ", Toast.LENGTH_SHORT).show();
                    } else if (mValuePath == 0) {
                        Toast.makeText(getApplicationContext(), "move straight uptoc" + mLengthRoundOff + "and go left  ", Toast.LENGTH_SHORT).show();
                    }

                } else if (mTemp == 3) {

                    if (mValuePath == 0) {

                        Toast.makeText(getApplicationContext(), "move straight uptod" + mLengthRoundOff + "and go right  ", Toast.LENGTH_SHORT).show();
                    } else if (mValuePath == 2) {
                        Toast.makeText(getApplicationContext(), "move straight uptod" + mLengthRoundOff + "and go back  ", Toast.LENGTH_SHORT).show();
                    } else if (mValuePath == 1) {
                        Toast.makeText(getApplicationContext(), "move straight uptod" + mLengthRoundOff + "and go left  ", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        }

        timer++;
    }


}




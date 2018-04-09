package com.gradledevextreme.light.indooratlaspro.Model;

import android.util.Log;

/**
 Position data type to get and set data
 */
public class Position {
    private double _lat, _log;
    private String _name;
    private boolean fav;

    public Position() {
    }

    public Position(String name, double _lat, boolean fav, double _lng) {
        this._name = name;
        this._lat = _lat;
        this._log = _lng;
        this.fav = fav;

    }

    public void setname(String name) {
        this._name = name;
    }

    public void setlat(double _lat) {
        this._lat = _lat;
    }

    public void setlog(double _log) {
        this._log = _log;
    }

    public String getname() {
        return _name;
    }

    public Double getlat() {

        return _log;
    }

    public Double getlog() {

        return _lat;
    }

    public boolean getFav() {
        return fav;
    }
}

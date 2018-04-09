package com.gradledevextreme.light.indooratlaspro.Service.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.gradledevextreme.light.indooratlaspro.Model.Position;

import java.util.ArrayList;
import java.util.List;

/**
 * Database Handler,handles data related to location ie lat and long
 */

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "LocationManager";
    private static final String TABLE_LOC = "Location";
    private static final String KEY_NAME = "name";
    private static final String KEY_lat = "lat";
    private static final String KEY_Log = "log";
    private static final String KEY_FAVORITE = "favorite";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

        //3rd argument to be passed is CursorFactory instance
    }

    public DatabaseHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public List<Position> getFav() {
        List<Position> positionList = new ArrayList<>();
        // Select All Query

        String[] col = {KEY_NAME, KEY_lat, KEY_FAVORITE, KEY_Log};
        String whereclause = KEY_FAVORITE + "=?";
        String[] whereArgs = {"1"};
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.query(TABLE_LOC, col, whereclause, whereArgs, null, null, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Position p = new Position();
                p.setname(cursor.getString(0));
                p.setlat(cursor.getDouble(1));
                p.setlog(cursor.getDouble(3));

                Log.v("NAME:", " " + cursor.getString(0) + " , " + Double.toString(cursor.getDouble(1)) + " , " + Double.toString(cursor.getDouble(3)) + " , " + cursor.getString(2));

                // Adding contact to list
                positionList.add(p);
            } while (cursor.moveToNext());
        }

        // return contact list
        return positionList;
    }

    public int getFavCount() {
        String[] col = {KEY_NAME, KEY_lat, KEY_FAVORITE, KEY_Log};
        String whereclause = KEY_FAVORITE + "=?";
        String[] whereArgs = {"1"};

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_LOC, col, whereclause, whereArgs, null, null, null);

        int count = cursor.getCount();
        cursor.close();
        return count;
    }

    public int getcount() {

        String countQuery = "SELECT  * FROM " + TABLE_LOC;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        return count;

    }
    public void addloc(Position p) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, p.getname());
        values.put(KEY_lat, p.getlat());
        values.put(KEY_Log, p.getlog());
        values.put(KEY_FAVORITE, p.getFav());

        Context context = null;
        db.insert(TABLE_LOC, null, values);

        //Toast.makeText(context,"data inserted",Toast.LENGTH_LONG).show();
        db.close();
    }

    public List<Position> getAllpos() {
        List<Position> positionList = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_LOC;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Position p = new Position();
                p.setname(cursor.getString(0));
                p.setlat(cursor.getDouble(1));
                p.setlog(cursor.getDouble(3));

                Log.v("NAME:", " " + cursor.getString(0) + " , " + Double.toString(cursor.getDouble(1)) + " , " + Double.toString(cursor.getDouble(3)) + " , " + cursor.getString(2));

                // Adding contact to list
                positionList.add(p);
            } while (cursor.moveToNext());
        }

        // return contact list
        return positionList;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_LOC_TABLE = "CREATE TABLE " + TABLE_LOC + "("
                + KEY_NAME + " TEXT," + KEY_lat + " REAL,"
                + KEY_FAVORITE + " TEXT," + KEY_Log + " REAL" + " )";
        db.execSQL(CREATE_LOC_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LOC);

        // Create tables again
        onCreate(db);

    }


}

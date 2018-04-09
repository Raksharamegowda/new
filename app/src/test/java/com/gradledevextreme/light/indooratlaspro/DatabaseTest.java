package com.gradledevextreme.light.indooratlaspro;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.gradledevextreme.light.indooratlaspro.Model.Position;
import com.gradledevextreme.light.indooratlaspro.Service.Database.DatabaseHandler;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


@RunWith(RobolectricTestRunner.class)

public class DatabaseTest {
    private DatabaseHandler mDataSource;

    @Before
    public  void setup() {
        mDataSource= new DatabaseHandler(RuntimeEnvironment.application);
        mDataSource.addloc(new Position("kushal", 1.09877, false, 1.98766));
        mDataSource.addloc(new Position("priyanka", 1.998716, true, 1.987515443));
        mDataSource.addloc(new Position("nivi", 1.919876, true, 1.982755443));

    }
    @After
    public void finish() {

        mDataSource.close();
    }

    @Test
    public void testPreConditions() {

        assertNotNull(mDataSource);
    }

    @Test
    public void getCountTest() {


        assertEquals(3, mDataSource.getcount());


    }

    @Test
    public void getFavCountTest() {



        assertEquals(2, mDataSource.getFavCount());
    }

    @Test
    public void getAllValuesTest() {


        List<Position> list = mDataSource.getAllpos();
        assertEquals(3, list.size());


        assertEquals("kushal", list.get(0).getname());
        assertEquals("priyanka", list.get(1).getname());
        assertEquals("nivi", list.get(2).getname());

    }

    @Test
    public void getFavValuesTest() {


        List<Position> list = mDataSource.getFav();
        assertEquals(2, list.size());


        assertEquals("priyanka", list.get(0).getname());
        assertEquals("nivi", list.get(1).getname());

    }


}

package com.gradledevextreme.light.indooratlaspro;

import android.util.Log;

import com.gradledevextreme.light.indooratlaspro.Model.Position;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Spy;

import static org.junit.Assert.assertEquals;

public class PositionClassTest {

    @Spy
    private Position pos=new Position("kushal",1.2222,true,1.23231);



    @Test
    public void Testget_name()
    {
        assertEquals("kushal",pos.getname());
    }@Test
    public void Testget_lat()
    {
        assertEquals("1.2222" , pos.getlog().toString());
    }

    @Test
    public void Testget_log()
    {
        assertEquals("1.23231",pos.getlat().toString());
    }


    @Test

    public void Test_getFav()
    {
        assertEquals(true,pos.getFav());
    }
    @Test
    public void Test_setname()
    {
        pos.setname("abhay");

        assertEquals("abhay",pos.getname());
    }

    @Test
    public void Test_setLog()
    {
        pos.setlog(1.23231);

        assertEquals("1.23231",pos.getlat().toString());
    }
@Test
    public void Test_setLat()
    {
        pos.setlat(1.22222);

        assertEquals("1.22222",pos.getlog().toString());
    }
}

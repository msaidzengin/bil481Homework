package com.mycompany.app;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import java.util.ArrayList;
import java.util.Arrays;


public class AppTest extends TestCase {
    public AppTest( String testName ) {
        super( testName );
    }
    public static Test suite() {
        return new TestSuite( AppTest.class );
    }
    public void testApp() {
        assertTrue( true );
    }
    public void testFirstSet() {
      ArrayList<Integer> array = new ArrayList<>(Arrays.asList(1, 1, 1, 1));
      ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList(2, 2, 2, 2, 2, 2));
      String s1 = "said";
      String s2 = "zengin";
      assertEquals(App.encode(array, array2, s1, s2), "tbje |gpikp");
    }
    public void testSecondSet() {
        ArrayList<Integer> array = new ArrayList<>(Arrays.asList(5, 5, 5));
        ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList(5, 5, 5));
        String s1 = "bil";
        String s2 = "481";
        assertEquals(App.encode(array, array2, s1, s2), "gnq 9=6");
      }
    public void testOnlyName() {
      ArrayList<Integer> array = new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1, 1));
      ArrayList<Integer> array2 = new ArrayList<>();
      String s1 = "deneme";
      String s2 = "";
      assertEquals(App.encode(array, array2, s1, s2), "efofnf ");
    }
    public void testEmptySetNull() {
      ArrayList<Integer> array = new ArrayList<>();
      ArrayList<Integer> array2 = new ArrayList<>();
      String s1 = "";
      String s2 = "";
      assertEquals(App.encode(array, array2, s1, s2), " ");
    }
    public void testNull() {
      assertEquals(App.encode(null, null, null, null), "");
    }
}
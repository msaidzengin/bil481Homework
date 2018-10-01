package com.mycompany.app;

import java.util.ArrayList;
import java.util.Arrays;

public class App 
{
    public static void main( String[] args )
    {
        //System.out.println( "Hello World!" );
    }

    public static boolean search(ArrayList<Integer> array, int e) {
        System.out.println("inside search");
        if (array == null) return false;
  
        for (int elt : array) {
          if (elt == e) return true;
        }
        return false;
      }

}

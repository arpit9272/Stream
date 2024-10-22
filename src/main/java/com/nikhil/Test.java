package com.nikhil;

import java.util.Comparator;

public class Test {
    int x = 10;

    public void m2() {
        int y = 20;
        MyInterface i = x->{
//            y=999;
            x=890;
            return x*x;
        };
    }

    public static void main(String[] args) {

        MyInterface intDef = (x) -> x * x;


        int[] p = {1,2,3};
        int[] a = {1,2,3};
        if (a==p) {
//            return tr;
        }
    }
}


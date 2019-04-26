package com.grzegorz_malarski.trainings_notebook.exceptions;

public class TestClass {


    public static void main(String[] args) {


        System.out.println(checkReturnedVal(true));

    }

    static boolean checkReturnedVal(boolean val) {

        if(val == true) {
            return true;
        }
        return false;
    }
}

package com.grzegorz_malarski.trainings_notebook.model;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class TrainingsCalendar {

    private static List<Month> months = new ArrayList<>();

    private static final Month[] MONTHS = Month.values();

    public static void main(String[] args) {
        System.out.println();

        for (int i = 0; i <= 11; i++) {
            System.out.println(MONTHS[i]);
        }


    }
}

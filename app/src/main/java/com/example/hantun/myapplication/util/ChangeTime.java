package com.example.hantun.myapplication.util;

public class ChangeTime {
    private static String duration;
    public static String MinToHour(int t){
        int hours = t / 60; //since both are ints, you get an int
        int minutes = t % 60;
        duration = hours+"h "+minutes+"min";
        return duration;
    }
}

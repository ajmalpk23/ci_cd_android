package com.peapi.workmanger_demo;

public class location {
    public double lati;
    public double longi;
    public String date;

    @Override
    public String toString() {
        return "location{" +
                "lati=" + lati +
                ", longi=" + longi +
                ", date='" + date + '\'' +
                ", hits=" + hits +
                '}';
    }

    public long hits;
}

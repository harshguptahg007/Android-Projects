package com.example.android.quakereport;

/**
 * Created by Harsh Gupta on 03-11-2017.
 */

public class Earthquake {

    //Declaring the global variables
    private double mMagnitude;
    private String mLocation;
    private long mTimeInMilliseconds;
    private String mUrl;

    public Earthquake(double magnitude, String location, long timeInMilliseconds,String url)
    {
        mMagnitude=magnitude;
        mLocation=location;
        mTimeInMilliseconds=timeInMilliseconds;
        mUrl=url;
    }

    public double getMagnitude()
    {
        return mMagnitude;
    }
    public String getLocation()
    {
        return mLocation;
    }
    public long getTimeInMilliseconds()
    {
        return mTimeInMilliseconds;
    }
    public String getUrl(){return mUrl;}
}

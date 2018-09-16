package com.example.android.sunshine.sync;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import com.example.android.sunshine.data.WeatherContract;
import com.firebase.jobdispatcher.Constraint;
import com.firebase.jobdispatcher.Driver;
import com.firebase.jobdispatcher.FirebaseJobDispatcher;
import com.firebase.jobdispatcher.GooglePlayDriver;
import com.firebase.jobdispatcher.Job;
import com.firebase.jobdispatcher.Lifetime;
import com.firebase.jobdispatcher.Trigger;

import java.util.concurrent.TimeUnit;

public class SunshineSyncUtils {

    private static final int SYNC_INTERVAL_HOURS = 3;
    private static final int SYNC_INTERVAL_SECONDS = (int) TimeUnit.HOURS.toSeconds(SYNC_INTERVAL_HOURS);
    private static final int SYNC_FLEXTIME_SECONDS = SYNC_INTERVAL_SECONDS/3;

    private static boolean sInitialized;

    private static final String SUNSHINE_SYNC_TAG = "sunshine-sync";

    public static void startImmediateSync(Context context){
        Intent myIntent = new Intent(context,SunshineSyncIntentService.class);
        context.startService(myIntent);
    }

    synchronized public static void initialize(final Context context){
        if (sInitialized)
            return;

        sInitialized = true;

        scheduleFirebaseJobDispatcherSync(context);

        new AsyncTask<Void,Void,Void>(){

            @Override
            protected Void doInBackground(Void... voids) {

                Uri forecastQueryUri = WeatherContract.WeatherEntry.CONTENT_URI;

                String []projectionColumns = {WeatherContract.WeatherEntry._ID};
                String selectionStatement = WeatherContract.WeatherEntry
                        .getSqlSelectForTodayOnwards();

                Cursor cursor = context.getContentResolver().query(
                        forecastQueryUri,
                        projectionColumns,
                        selectionStatement,
                        null,
                        null);

                if (cursor == null || cursor.getCount() == 0){
                    startImmediateSync(context);
                }

                cursor.close();
                return null;
            }
        }.execute();
    }

    static void scheduleFirebaseJobDispatcherSync(Context context){

        Driver driver = new GooglePlayDriver(context);
        FirebaseJobDispatcher dispatcher = new FirebaseJobDispatcher(driver);
        Job syncSunshineJob = dispatcher.newJobBuilder()
                //the job service that will be called
                .setService(SunshineFirebaseJobService.class)
                //uniquely identify the job
                .setTag(SUNSHINE_SYNC_TAG)
                //set constraints that need to be specified for the job to run
                .setConstraints(Constraint.ON_ANY_NETWORK)
                //set the period of execution of the job i.e. lifetime
                .setLifetime(Lifetime.FOREVER)
                //one job at a time
                .setRecurring(true)
                //start between 0 and 15 minutes
                .setTrigger(Trigger.executionWindow(
                        SYNC_INTERVAL_SECONDS,
                        SYNC_INTERVAL_SECONDS + SYNC_FLEXTIME_SECONDS))
                //overwrite an existing job with the same tag if present
                .setReplaceCurrent(true)
                .build();

        dispatcher.schedule(syncSunshineJob);
        sInitialized = true;

    }

}

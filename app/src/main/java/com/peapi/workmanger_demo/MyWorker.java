package com.peapi.workmanger_demo;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.Worker;
import androidx.work.WorkerParameters;



import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class MyWorker extends Worker {

    private static final String DEFAULT_START_TIME = "08:00";
    private static final String DEFAULT_END_TIME = "19:00";

    private static final String TAG = "MyWorker";

    /**
     * The desired interval for location updates. Inexact. Updates may be more or less frequent.
     */
    private static final long UPDATE_INTERVAL_IN_MILLISECONDS = 10000;

    /**
     * The fastest rate for active location updates. Updates will never be more frequent
     * than this value.
     */
    private static final long FASTEST_UPDATE_INTERVAL_IN_MILLISECONDS =
            UPDATE_INTERVAL_IN_MILLISECONDS / 2;
    /**
     * The current location.
     */
    private Location mLocation;

    /**
     * Provides access to the Fused Location Provider API.
     */

Context mContext;
    public MyWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
        mContext = context;
    }

    @NonNull
    @Override
    public Result doWork() {
        Log.d(TAG, "doWork: Done");
        Log.d(TAG, "1111111111111111111111111111111");
        Log.d(TAG, "doWork: Done");

        Log.d(TAG, "onStartJob: STARTING JOB..");
        OneTimeWorkRequest mywork = new OneTimeWorkRequest.Builder(MyWorker.class)
                .setInitialDelay(10000, TimeUnit.MILLISECONDS)
                .build();
        WorkManager.getInstance(mContext).enqueue(mywork);
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(mContext, "Location Worker Started : " , Toast.LENGTH_SHORT).show();

            }
        });


//        DateFormat dateFormat = new SimpleDateFormat("HH:mm", Locale.getDefault());
//
//        Calendar c = Calendar.getInstance();
//        Date date = c.getTime();
//        String formattedDate = dateFormat.format(date);
//
//        try {
//            Date currentDate = dateFormat.parse(formattedDate);
//            Date startDate = dateFormat.parse(DEFAULT_START_TIME);
//            Date endDate = dateFormat.parse(DEFAULT_END_TIME);
//
//            if (currentDate.after(startDate) && currentDate.before(endDate)) {
//                mFusedLocationClient = LocationServices.getFusedLocationProviderClient(mContext);
//                mLocationCallback = new LocationCallback() {
//                    @Override
//                    public void onLocationResult(LocationResult locationResult) {
//                        super.onLocationResult(locationResult);
//                    }
//                };
//
//                LocationRequest mLocationRequest = new LocationRequest();
//                mLocationRequest.setInterval(UPDATE_INTERVAL_IN_MILLISECONDS);
//                mLocationRequest.setFastestInterval(FASTEST_UPDATE_INTERVAL_IN_MILLISECONDS);
//                mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
//
//                try {
//                    mFusedLocationClient
//                            .getLastLocation()
//                            .addOnCompleteListener(new OnCompleteListener<Location>() {
//                                @Override
//                                public void onComplete(@NonNull Task<Location> task) {
//                                    if (task.isSuccessful() && task.getResult() != null) {
//                                        mLocation = task.getResult();
//                                        Log.d(TAG, "Location : " + mLocation);
//
//                                        // Create the NotificationChannel, but only on API 26+ because
//                                        // the NotificationChannel class is new and not in the support library
//                                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//                                            CharSequence name = mContext.getString(R.string.app_name);
//                                            String description = mContext.getString(R.string.app_name);
//                                            int importance = NotificationManager.IMPORTANCE_DEFAULT;
//                                            NotificationChannel channel = new NotificationChannel(mContext.getString(R.string.app_name), name, importance);
//                                            channel.setDescription(description);
//                                            // Register the channel with the system; you can't change the importance
//                                            // or other notification behaviors after this
//                                            NotificationManager notificationManager = mContext.getSystemService(NotificationManager.class);
//                                            notificationManager.createNotificationChannel(channel);
//                                        }
//
//                                        NotificationCompat.Builder builder = new NotificationCompat.Builder(mContext, mContext.getString(R.string.app_name))
//                                                .setSmallIcon(android.R.drawable.ic_menu_mylocation)
//                                                .setContentTitle("New Location Update")
//                                                .setContentText("You are at " + getCompleteAddressString(mLocation.getLatitude(), mLocation.getLongitude()))
//                                                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
//                                                .setStyle(new NotificationCompat.BigTextStyle().bigText("You are at " + getCompleteAddressString(mLocation.getLatitude(), mLocation.getLongitude())));
//
//                                        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(mContext);
//
//                                        // notificationId is a unique int for each notification that you must define
//                                        notificationManager.notify(1001, builder.build());
//
//                                        mFusedLocationClient.removeLocationUpdates(mLocationCallback);
//                                    } else {
//                                        Log.w(TAG, "Failed to get location.");
//                                    }
//                                }
//                            });
//                } catch (SecurityException unlikely) {
//                    Log.e(TAG, "Lost location permission." + unlikely);
//                }
//
//                try {
//                    mFusedLocationClient.requestLocationUpdates(mLocationRequest, null);
//                } catch (SecurityException unlikely) {
//                    //Utils.setRequestingLocationUpdates(this, false);
//                    Log.e(TAG, "Lost location permission. Could not request updates. " + unlikely);
//                }
//            } else {
//                Log.d(TAG, "Time up to get location. Your time is : " + DEFAULT_START_TIME + " to " + DEFAULT_END_TIME);
//            }
//        } catch (ParseException ignored) {
//
//        }

        return Result.success();
    }


}
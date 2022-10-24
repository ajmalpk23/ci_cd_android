package com.peapi.workmanger_demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        PeriodicWorkRequest periodicWork = new PeriodicWorkRequest.Builder(MyWorker.class, 2, TimeUnit.SECONDS)
//                .addTag("TAG")
//                .build();
//        WorkManager.getInstance().enqueueUniquePeriodicWork("TAG",ExistingPeriodicWorkPolicy.REPLACE, periodicWork);
//        WorkManager.getInstance().getWorkInfosByTagLiveData("TAG").observe(this, new Observer<List<WorkInfo>>() {
//            @Override
//            public void onChanged(List<WorkInfo> workInfos) {
//                for(WorkInfo w :workInfos){
//                    Log.e("dfdas","dfadsfds      "+w.getState());
//                    Log.e("dfdas","dfadsfds      "+w.getProgress());
//                }
//
//            }
//        });
////        WorkManager.getInstance().enqueueUniquePeriodicWork("Location", ExistingPeriodicWorkPolicy.REPLACE, periodicWork);
//        Toast.makeText(MainActivity.this, "Location Worker Started : " + periodicWork.getId(), Toast.LENGTH_SHORT).show();

        OneTimeWorkRequest mywork = new OneTimeWorkRequest.Builder(MyWorker.class)
                .setInitialDelay(10000, TimeUnit.MILLISECONDS)
                .build();
        WorkManager.getInstance(this).enqueue(mywork);



        reference = FirebaseDatabase.getInstance().getReference();
        reference.child("location").setValue("ajmal");

    }
}
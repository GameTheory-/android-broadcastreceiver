package com.gt.broadcastreceiver;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.JobIntentService;

public class BootUpService extends JobIntentService {

    // You can assign any number to your job id
    final static int job_id = 95;

    public static void enqueueWork(Context context, Intent intent) {
        enqueueWork(context, BootUpService.class, job_id, intent);
    }

    @Override
    protected void onHandleWork(@NonNull Intent intent) {
        // Any code you need to run on boot up can be placed here.
        // This is just a sample Toast message to show our BroadcastReceiver works.
        // We'll be using a Handler to run our Toast since it needs to run on the UI thread. Otherwise you don't need it.
        Handler handler = new Handler(Looper.getMainLooper());
        handler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getApplicationContext(), "Our BroadcastReceiver works! Fantastic!", Toast.LENGTH_LONG).show();
            }
        });
    }

}

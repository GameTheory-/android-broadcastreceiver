package com.gt.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;

public class BootUpReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // Runs when bootup has completed.
        if (Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())) {
            // Our WorkManager will now run our task in a background thread.
            WorkRequest uploadWorkRequest = new OneTimeWorkRequest.Builder(BootUpWork.class).build();
            WorkManager.getInstance(context).enqueue(uploadWorkRequest);
        }
    }

}

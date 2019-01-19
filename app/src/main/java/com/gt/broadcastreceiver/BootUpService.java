package com.gt.broadcastreceiver;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class BootUpService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // Any code you need to run on boot up can be placed here.
        // This is just a sample Toast message to show our BroadcastReceiver works.
        Toast.makeText(getApplicationContext(), "Our BroadcastReceiver works! Fantastic!", Toast.LENGTH_LONG).show();

        // Stops the Service after it's done.
        stopSelf();
        // Do not restart the Service till the next reboot.
        return START_NOT_STICKY;
    }

}

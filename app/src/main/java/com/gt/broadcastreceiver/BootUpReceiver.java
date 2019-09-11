package com.gt.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BootUpReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // Start our BootUpService class once boot up has completed
        if (Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())) {
            BootUpService.enqueueWork(context, new Intent());
        }
    }

}

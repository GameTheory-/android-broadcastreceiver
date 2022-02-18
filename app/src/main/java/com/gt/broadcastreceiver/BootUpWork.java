package com.gt.broadcastreceiver;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class BootUpWork extends Worker {

    public BootUpWork(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        // Any code/task you need to run on bootup can be placed here and will run on a background thread.
        // This is just a sample notification message to show our BroadcastReceiver and
        // WorkManager are working properly.
        String channelID = "channel_0";
        NotificationManager notificationManager = (NotificationManager)getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), channelID);
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel channel = new NotificationChannel(channelID,"BroadcastReceiver", NotificationManager.IMPORTANCE_DEFAULT);
            channel.enableLights(true);
            channel.setShowBadge(true);
            channel.setLockscreenVisibility(Notification.VISIBILITY_PUBLIC);
            notificationManager.createNotificationChannel(channel);
        }
        builder.setSmallIcon(android.R.drawable.stat_notify_more)
                .setContentTitle("Run Tasks on Bootup")
                .setContentText("BroadcastReceiver & WorkManager")
                .setStyle(new NotificationCompat.BigTextStyle().bigText(
                        "Our BroadcastReceiver and WorkManager are working properly " +
                                "to run code/tasks on bootup."
                ))
                .setDefaults(NotificationCompat.DEFAULT_SOUND | NotificationCompat.DEFAULT_LIGHTS)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
                .setAutoCancel(true);
        notificationManager.notify(0, builder.build());

        return Result.success();
    }
}

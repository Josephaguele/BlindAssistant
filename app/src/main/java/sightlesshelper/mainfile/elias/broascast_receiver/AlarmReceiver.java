package xyz.redbooks.umme.broascast_receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import xyz.redbooks.umme.service.ImageCaptureService;


public class AlarmReceiver extends BroadcastReceiver {
    public static final int REQUEST_CODE=1000;

    // This is the method invoked by Alarm Manager at specific intervals as per user configurations.
    // This method launches ImageCaptureActivity Screen.
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("Upload", "OnReceive=");
        Intent imageCapSerIntent = new Intent(context, ImageCaptureService.class);
        context.startService(imageCapSerIntent);

    }
}

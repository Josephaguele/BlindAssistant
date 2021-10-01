package xyz.redbooks.umme.Activity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import br.com.bloder.magic.view.MagicButton;
import xyz.redbooks.umme.R;
import xyz.redbooks.umme.broascast_receiver.AlarmReceiver;
import xyz.redbooks.umme.preferences.ConfigPreferences;
import xyz.redbooks.umme.service.ImageCaptureService;


public class ImageCaptureActivity extends AppCompatActivity {

    public static float selectedIntervalMultiplier = 0.0f;
    private Button video;

    // This is the first method in the activity that will be invoked.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_capture);


        initViewsClicks();
    }

    // This method binds start, stop and configuration buttons with their listeners.

    private void initViewsClicks() {
        final Button startServiceButton = (Button) findViewById(R.id.startButton);
        Button stopServiceButton = (Button) findViewById(R.id.stopButton);
        MagicButton configButton = (MagicButton) findViewById(R.id.configButton);

        startServiceButton.setOnClickListener(startServiceButtonClickListener);
        stopServiceButton.setOnClickListener(stopServiceButtonClickListener);
        configButton.setMagicButtonClickListener(configClickListener);


    }


    // This method finds interval multiplication factor based on user configuration settings.


    public void calculateInterval(){
        int index= ConfigPreferences.getInstance(this).getIntervalIndex();
        selectedIntervalMultiplier= ConfigActivity.intervalFactorList[index];
    }
    // This method configures AlarmManager which runs on periodic intervals and invokes Alarmreceiver broadcast class.


    public void scheduleAlarm() {
        ImageCaptureService.counter =0;
        calculateInterval();

        Intent intent = new Intent(getApplicationContext(), AlarmReceiver.class);
        final PendingIntent pIntent = PendingIntent.getBroadcast(this, AlarmReceiver.REQUEST_CODE, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        long firstMillis = System.currentTimeMillis(); // alarm is set right away
        AlarmManager alarm = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);

        int timeInterval =(int)(selectedIntervalMultiplier*60*1000);
        alarm.setRepeating(AlarmManager.RTC_WAKEUP, firstMillis,timeInterval , pIntent);
    }


    // This method is to cancel the Alarm when user clicks on stop service button


    public void cancelAlarm() {
        Intent intent = new Intent(getApplicationContext(), AlarmReceiver.class);
        final PendingIntent pIntent = PendingIntent.getBroadcast(this, AlarmReceiver.REQUEST_CODE, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarm = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
        alarm.cancel(pIntent);
    }



    private View.OnClickListener startServiceButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(ImageCaptureActivity.this, "Start secret camera", Toast.LENGTH_SHORT).show();
            scheduleAlarm();
        }
    };

    private View.OnClickListener stopServiceButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(ImageCaptureActivity.this, "Background camera stoped", Toast.LENGTH_SHORT).show();
            cancelAlarm();
        }
    };
    private View.OnClickListener configClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            launchConfigActivity();
        }
    };

    // This launches the configuration screen that contains interval, size and flash settings.
    private void launchConfigActivity(){
        Intent intent = new Intent(ImageCaptureActivity.this,ConfigActivity.class);
        startActivity(intent);
    }




}

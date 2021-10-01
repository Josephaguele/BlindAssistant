package xyz.redbooks.umme.Activity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.SensorManager;
import android.location.Location;
import android.location.LocationManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Vibrator;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.squareup.seismic.ShakeDetector;

import java.util.List;

import xyz.redbooks.umme.R;
import xyz.redbooks.umme.broascast_receiver.AlarmReceiver;
import xyz.redbooks.umme.core.MyService;
import xyz.redbooks.umme.database.AppDatabase;
import xyz.redbooks.umme.preferences.ConfigPreferences;
import xyz.redbooks.umme.service.ImageCaptureService;

import static java.lang.Thread.sleep;

public class HomeActivity extends AppCompatActivity implements ShakeDetector.Listener{

    FragmentManager fm;;
    Fragment fragment;
    FragmentTransaction fragmentTransaction;

    private ActionBarDrawerToggle drawerToggle;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolbar;
    FloatingActionButton floatingActionButton;
   // MediaPlayer player;
   int i = 0;
    Vibrator v;
    public static float selectedIntervalMultiplier = 0.0f;
    public final static int REQUEST_CODE = 10101;
    boolean flag = false;

    boolean flag2 = false;
    MediaPlayer mediaPlayer;
   AppDatabase db ;
   String msg;
   // ImageCaptureActivity obj;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        setUpToolBar();
        mediaPlayer = MediaPlayer.create(this, R.raw.siren);

        drawerLayout = findViewById(R.id.drawer);
       // mediaPlayer=MediaPlayer.create(this, R.raw.siren);
         db = AppDatabase.getAppDatabase(HomeActivity.this);
        // obj= new ImageCaptureActivity();


        navigationView = findViewById(R.id.nav_view);
        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        ShakeDetector sd = new ShakeDetector(this);
        sd.start(sensorManager);

        // add the tip of the day fragment
        fm = getSupportFragmentManager();

        fragment = fm.findFragmentById(R.id.fragment_container);

        if(fragment == null) {
//            fragment = new TipOfTheDayFragment();
            fragment = new ContactsConfigFragment();
            fm.beginTransaction().add(R.id.fragment_container, fragment).commit();
        }


        //set click listener on nav menu items
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                //Checking if the item is in checked state or not, if not make it in checked state
                if(item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);

                //Closing drawer on item click
                drawerLayout.closeDrawers();

                //Check to see which item was being clicked and perform appropriate action
                switch (item.getItemId()){


                    case R.id.location:
                        Toast.makeText(HomeActivity.this, "Location", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(HomeActivity.this,RealtimeLocationTrack.class));
                        return true;
                        
                        
                    case R.id.camera:
                        Toast.makeText(HomeActivity.this, "Camera", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(HomeActivity.this,ImageCaptureActivity.class));
                        //return true;
                        return true;
                    case R.id.video:
                        Toast.makeText(HomeActivity.this, "Video", Toast.LENGTH_SHORT).show();
                        //startActivity(new Intent(HomeActivity.this,ImageCaptureActivity.class));
                        startActivity(new Intent(HomeActivity.this,CameraRecorderActivity.class));
                        return true;
                    case R.id.reminder:
                        Toast.makeText(HomeActivity.this, "Reminder", Toast.LENGTH_SHORT).show();
                        //startActivity(new Intent(HomeActivity.this,LocationReminder.class));
                        startActivity(new Intent(HomeActivity.this,MainActivity2.class));
                        return true;
                        

                    case R.id.police:
                        Toast.makeText(HomeActivity.this, "Bd police ", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(HomeActivity.this,BdPoliceStationActivity.class));
                        return true;
                      //  case.R.id.calling:
                    case R.id.calling:
                        caling999();
                        return true;
                    case R.id.search:
                        startActivity(new Intent(HomeActivity.this,SearchNearbyPlaceActivity.class));
                        return true;
                    case R.id.direction:
                        Toast.makeText(HomeActivity.this, "Direction", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(HomeActivity.this,MapDirectionActivity.class));
                        return true;
                    case R.id.complain:
                        Toast.makeText(HomeActivity.this, "Resistence of women haresment", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(HomeActivity.this,WomenAndChildComplain.class));
                        return true;
                    case R.id.consume:
                        Toast.makeText(HomeActivity.this, "Consumer rights", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(HomeActivity.this,VoktaOdikarActivity.class));
                        return true;

                    default:
                        return true;
                }
            }
        });

        drawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.drawer_open, R.string.drawer_close){

            @Override
            public void onDrawerClosed(View drawerView) {
                // Code here will be triggered once the drawer closes as we don't want anything to happen so we leave this blank
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                // Code here will be triggered once the drawer open as we don't want anything to happen so we leave this blank

                super.onDrawerOpened(drawerView);
            }
        };

        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();


        // start service to starting a broadcast receiver
        Intent service = new Intent(getApplicationContext(), MyService.class);
        getApplicationContext().startService(service);

    }

    private void setUpToolBar() {
        toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public void onBackPressed() {
        if (isNavDrawerOpen()) {
            closeNavDrawer();
        } else {
            super.onBackPressed();
        }
    }

    protected boolean isNavDrawerOpen() {
        return drawerLayout != null && drawerLayout.isDrawerOpen(GravityCompat.START);
    }

    protected void closeNavDrawer() {
        if (drawerLayout != null) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }


    public void caling999(){
        String number = "999";
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + number));
        if (ActivityCompat.checkSelfPermission(HomeActivity.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        startActivity(intent);
    }

    @Override
    public void hearShake() {

        i++;
        //  v.vibrate(pattern,500);
        v.vibrate(500);
        if(i==2){
            Toast.makeText(this, "Shaking 3 times", Toast.LENGTH_SHORT).show();

            //execute next code.
           // sendCurentLocation();
            //sendCurentLocation();
           mediaPlayer.start();
            //sendCurentLocation();
          //  callingTrustedPeople();
           // obj.scheduleAlarm();

            try {
                //sleep(4000);
                //callingTrustedPeople();
                sleep(2000);
                sendCurentLocation();
                Toast.makeText(this, "Location sending.........", Toast.LENGTH_SHORT).show();
                sleep(2000);
                Toast.makeText(this, "Image capture start.............", Toast.LENGTH_SHORT).show();
                scheduleAlarm();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }


    public void sendCurentLocation(){


        //location passing method
        Location location = getLocation();
        String longi, lati;
        if(location != null){

            longi = Double.toString(location.getLongitude());
            lati = Double.toString(location.getLatitude());
        } else {
            lati = "\'Not Available\'";
            longi = "\'Not Available\'";
        }
        //message option
        AppDatabase db = AppDatabase.getAppDatabase(getApplicationContext());

        List<String> mobNumber = db.contactDao().getAllContactsNumber();
        SmsManager smsManager = SmsManager.getDefault();

        String gmapLink = "http://maps.google.com/maps?q=" + lati + ","+ longi;
        msg = "I am here at " + gmapLink + ". I need your help! Get to me Soon.";

        for(String number : mobNumber) {
            smsManager.sendTextMessage(number,null, msg, null, null);
            Log.d("MSG", "sent message to " + number);
        }




    }

    public void callingTrustedPeople(){
        AppDatabase db = AppDatabase.getAppDatabase(getApplicationContext());

        List<String> mobNumber = db.contactDao().getAllContactsNumber();


        String number = mobNumber.get(0);
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + number));
        if (ActivityCompat.checkSelfPermission(HomeActivity.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        startActivity(intent);

    }




    public Location getLocation(){
        boolean gps_enabled = false;
        boolean network_enabled = false;

        LocationManager lm = (LocationManager) getApplicationContext()
                .getSystemService(Context.LOCATION_SERVICE);

        if(lm != null) {
            gps_enabled = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
            network_enabled = lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        }

        Location net_loc = null, gps_loc = null, finalLoc = null;

        if (gps_enabled)
            gps_loc = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        if (network_enabled)
            net_loc = lm.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

        if (gps_loc != null && net_loc != null) {

            //smaller the number more accurate result will
            if (gps_loc.getAccuracy() > net_loc.getAccuracy())
                finalLoc = net_loc;
            else
                finalLoc = gps_loc;

            // I used this just to get an idea (if both avail, its upto you which you want to take as I've taken location with more accuracy)

        } else {

            if (gps_loc != null) {
                finalLoc = gps_loc;
            } else if (net_loc != null) {
                finalLoc = net_loc;
            }
        }
        return finalLoc;


    }




    // This method finds interval multiplication factor based on user configuration settings.
    private void calculateInterval() {
        int index = ConfigPreferences.getInstance(this).getIntervalIndex();
        selectedIntervalMultiplier = ConfigActivity.intervalFactorList[index];
    }


    // This method configures AlarmManager which runs on periodic intervals and invokes Alarmreceiver broadcast class.
    public void scheduleAlarm() {
        ImageCaptureService.counter = 0;
        calculateInterval();

        Intent intent = new Intent(getApplicationContext(), AlarmReceiver.class);
        final PendingIntent pIntent = PendingIntent.getBroadcast(this, AlarmReceiver.REQUEST_CODE, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        long firstMillis = System.currentTimeMillis(); // alarm is set right away
        AlarmManager alarm = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);

        int timeInterval = (int) (selectedIntervalMultiplier * 60 * 1000);
        alarm.setRepeating(AlarmManager.RTC_WAKEUP, firstMillis, timeInterval, pIntent);


    }

    // This method is to cancel the Alarm when user clicks on stop service button
    public void cancelAlarm() {
        Intent intent = new Intent(getApplicationContext(), AlarmReceiver.class);
        final PendingIntent pIntent = PendingIntent.getBroadcast(this, AlarmReceiver.REQUEST_CODE, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarm = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
        alarm.cancel(pIntent);
    }





    // This launches the configuration screen that contains interval, size and flash settings.
    private void launchConfigActivity() {
        Intent intent = new Intent(HomeActivity.this, ConfigActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if(event.getKeyCode()==KeyEvent.KEYCODE_VOLUME_UP){
            Toast.makeText(this, "Start data passing", Toast.LENGTH_SHORT).show();

            //.............//

            callingTrustedPeople();
            scheduleAlarm();
            sendCurentLocation();

            //....................//



        }


        else if(event.getKeyCode()==KeyEvent.KEYCODE_VOLUME_DOWN){
            Toast.makeText(this, "Start data passing ", Toast.LENGTH_SHORT).show();
            callingTrustedPeople();
            scheduleAlarm();
            sendCurentLocation();

        }

        else if(event.getKeyCode()==KeyEvent.KEYCODE_VOLUME_MUTE){
            Toast.makeText(this, "Volume mute", Toast.LENGTH_SHORT).show();
        }


        return super.onKeyDown(keyCode, event);
    }
}

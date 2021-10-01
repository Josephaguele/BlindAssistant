package xyz.redbooks.umme.Activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.speech.tts.TextToSpeech;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.Toast;

import xyz.redbooks.umme.R;
import xyz.redbooks.umme.adapter.CustomGridAdapter;
import xyz.redbooks.umme.service.GPSTrackerService;


public class SearchNearbyPlaceActivity extends AppCompatActivity {

    GridView grid;
    Button searchBtn;
    EditText searchEditTxt;
    LinearLayout ln;

    //TTS object
    private TextToSpeech engine;


    String[] web = {
            "Hospitals",
            "Police Station",
            "Fire Service",
            "Pharmacy",
            "School",
            "College",
            "University",
            "Bank",
            "ATM Both",
            "Resturant",
            "Hotel",
            "Shopping Mall",
            "Gas Station"
            // "Search"


    } ;
    int[] imageId = {
            R.drawable.hospital1,
            R.drawable.policestation1,
            R.drawable.fire2,
            R.drawable.pharmacy1,
            R.drawable.school2,
            R.drawable.college1,
            R.drawable.university1,
            R.drawable.bank2,
            R.drawable.atm2,
            R.drawable.resturant1,
            R.drawable.hotel,
            R.drawable.shopping,
            R.drawable.gas2
            // R.drawable.search


    };



    double lat=0.0,lng=0.0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_nearby_place);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final GPSTrackerService gps = new GPSTrackerService(this);
        final LocationManager manager = (LocationManager) getSystemService( Context.LOCATION_SERVICE );

        searchBtn = (Button)findViewById(R.id.Searchbutton);
        searchEditTxt = (EditText)findViewById(R.id.SearcheditText);

        //------------------------------- custom font add ---------------------------------------
        //  Typeface typeface= Typeface.createFromAsset(getAssets(), "fonts/FallingSkyBlkObl.otf");
        // searchEditTxt.setTypeface(typeface);
        //--------------------------------- end of custom font ------------------------------------
        //---------- Custom GridView Implementation -------------


        //----------------------- TTS implementation -------------------


        //----------------------end of tts -----------------------------

        CustomGridAdapter adapter = new CustomGridAdapter(SearchNearbyPlaceActivity.this, web, imageId);

        grid=(GridView)findViewById(R.id.grid);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(SearchNearbyPlaceActivity.this, "You Clicked at " + web[+position], Toast.LENGTH_SHORT).show();
                speakWords(web[+position]);

                //------------Hospital blocks -------------------
                if(web[+position]=="Hospitals"){


                    lat = gps.getLatitude();
                    lng = gps.getLongitude();
                    String lat1 = Double.toString(lat);
                    String lng1 = Double.toString(lng);

                    if(lat1==""&&lng1==""){

                        //String str = "pls check connection";
                        //Toast.makeText(getBaseContext(), str, Toast.LENGTH_LONG).show();
                        showSettingsAlert();
                    }

                    else {

                        String geoURI = String.format("geo:%f,%f?q=hospital", lat, lng);
                        Uri geo = Uri.parse(geoURI);
                        Intent geoMap = new Intent(Intent.ACTION_VIEW, geo);
                        startActivity(geoMap);
                    }


                }
                //----------- end of hospital block ----------------

                //------------ police station blocks -------------------
                else if(web[+position]=="PoliceStation"){


                    lat = gps.getLatitude();
                    lng = gps.getLongitude();

                    String lat1 = Double.toString(lat);
                    String lng1 = Double.toString(lng);

                    if(lat1==""&&lng1==""){
                        String str = "pls check connection";
                        Toast.makeText(getBaseContext(), str, Toast.LENGTH_LONG).show();
                    }

                    else {

                        String geoURI = String.format("geo:%f,%f?q=police station", lat, lng);
                        Uri geo = Uri.parse(geoURI);
                        Intent geoMap = new Intent(Intent.ACTION_VIEW, geo);
                        startActivity(geoMap);
                    }


                }
                //----------- end of police station block ----------------

                //------------ fire sevice blocks -------------------
                else if(web[+position]=="FireService"){


                    lat = gps.getLatitude();
                    lng = gps.getLongitude();

                    String lat1 = Double.toString(lat);
                    String lng1 = Double.toString(lng);

                    if(lat1== ""&&lng1==""){
                        String str = "pls check connection";
                        Toast.makeText(getBaseContext(), str, Toast.LENGTH_LONG).show();
                    }

                    else {

                        String geoURI = String.format("geo:%f,%f?q=Fire Service", lat, lng);
                        Uri geo = Uri.parse(geoURI);
                        Intent geoMap = new Intent(Intent.ACTION_VIEW, geo);
                        startActivity(geoMap);
                    }


                }
                //----------- end of FireService block ----------------

                //------------ gas service blocks -------------------
                else if(web[+position]=="Gas Station"){


                    lat = gps.getLatitude();
                    lng = gps.getLongitude();

                    String lat1 = Double.toString(lat);
                    String lng1 = Double.toString(lng);

                    if(lat1==""&&lng1==""){
                        String str = "pls check connection";
                        Toast.makeText(getBaseContext(), str, Toast.LENGTH_LONG).show();
                    }

                    else {

                        String geoURI = String.format("geo:%f,%f?q=Gas Station", lat, lng);
                        Uri geo = Uri.parse(geoURI);
                        Intent geoMap = new Intent(Intent.ACTION_VIEW, geo);
                        startActivity(geoMap);
                    }


                }
                //----------- end of Gas Station block ----------------

                //------------ shopping mall blocks -------------------
                else if(web[+position]=="Shopping Mall"){


                    lat = gps.getLatitude();
                    lng = gps.getLongitude();

                    String lat1 = Double.toString(lat);
                    String lng1 = Double.toString(lng);

                    if(lat1==""&&lng1==""){
                        String str = "pls check connection";
                        Toast.makeText(getBaseContext(), str, Toast.LENGTH_LONG).show();
                    }

                    else {

                        String geoURI = String.format("geo:%f,%f?q=Shopping Mall", lat, lng);
                        Uri geo = Uri.parse(geoURI);
                        Intent geoMap = new Intent(Intent.ACTION_VIEW, geo);
                        startActivity(geoMap);
                    }


                }
                //----------- end of shopping mall block ---------------

                //------------ pharmacy blocks -------------------
                else if(web[+position]=="Pharmacy"){


                    lat = gps.getLatitude();
                    lng = gps.getLongitude();

                    String lat1 = Double.toString(lat);
                    String lng1 = Double.toString(lng);

                    if(lat1==""&&lng1==""){
                        String str = "pls check connection";
                        Toast.makeText(getBaseContext(), str, Toast.LENGTH_LONG).show();
                    }

                    else {

                        String geoURI = String.format("geo:%f,%f?q=Pharmacy", lat, lng);
                        Uri geo = Uri.parse(geoURI);
                        Intent geoMap = new Intent(Intent.ACTION_VIEW, geo);
                        startActivity(geoMap);
                    }


                }
                //----------- end of pharmacy block ----------------



                //------------ School blocks -------------------
                else if(web[+position]=="School"){


                    lat = gps.getLatitude();
                    lng = gps.getLongitude();

                    String lat1 = Double.toString(lat);
                    String lng1 = Double.toString(lng);

                    if(lat1==""&&lng1==""){
                        String str = "pls check connection";
                        Toast.makeText(getBaseContext(), str, Toast.LENGTH_LONG).show();
                    }

                    else {

                        String geoURI = String.format("geo:%f,%f?q=School", lat, lng);
                        Uri geo = Uri.parse(geoURI);
                        Intent geoMap = new Intent(Intent.ACTION_VIEW, geo);
                        startActivity(geoMap);
                    }


                }
                //----------- end of School block ----------------


                //------------ College blocks -------------------
                else if(web[+position]=="College"){


                    lat = gps.getLatitude();
                    lng = gps.getLongitude();

                    String lat1 = Double.toString(lat);
                    String lng1 = Double.toString(lng);

                    if(lat1==""&&lng1==""){
                        String str = "pls check connection";
                        Toast.makeText(getBaseContext(), str, Toast.LENGTH_LONG).show();
                    }

                    else {

                        String geoURI = String.format("geo:%f,%f?q=College", lat, lng);
                        Uri geo = Uri.parse(geoURI);
                        Intent geoMap = new Intent(Intent.ACTION_VIEW, geo);
                        startActivity(geoMap);
                    }


                }
                //----------- end of College block ----------------


                //------------ University blocks -------------------
                else if(web[+position]=="University"){


                    lat = gps.getLatitude();
                    lng = gps.getLongitude();

                    String lat1 = Double.toString(lat);
                    String lng1 = Double.toString(lng);

                    if(lat1==""&&lng1==""){
                        String str = "pls check connection";
                        Toast.makeText(getBaseContext(), str, Toast.LENGTH_LONG).show();
                    }

                    else {

                        String geoURI = String.format("geo:%f,%f?q=University", lat, lng);
                        Uri geo = Uri.parse(geoURI);
                        Intent geoMap = new Intent(Intent.ACTION_VIEW, geo);
                        startActivity(geoMap);
                    }


                }
                //----------- end of University block ----------------

                //------------ Bank blocks -------------------
                else if(web[+position]=="Bank"){


                    lat = gps.getLatitude();
                    lng = gps.getLongitude();

                    String lat1 = Double.toString(lat);
                    String lng1 = Double.toString(lng);

                    if(lat1==""&&lng1==""){
                        String str = "pls check connection";
                        Toast.makeText(getBaseContext(), str, Toast.LENGTH_LONG).show();
                    }

                    else {

                        String geoURI = String.format("geo:%f,%f?q=Bank", lat, lng);
                        Uri geo = Uri.parse(geoURI);
                        Intent geoMap = new Intent(Intent.ACTION_VIEW, geo);
                        startActivity(geoMap);
                    }


                }
                //----------- end of Bank block ----------------

                //------------ ATM Both blocks -------------------
                else if(web[+position]=="ATM Both"){


                    lat = gps.getLatitude();
                    lng = gps.getLongitude();

                    String lat1 = Double.toString(lat);
                    String lng1 = Double.toString(lng);

                    if(lat1==""&&lng1==""){
                        String str = "pls check connection";
                        Toast.makeText(getBaseContext(), str, Toast.LENGTH_LONG).show();
                    }

                    else {

                        String geoURI = String.format("geo:%f,%f?q=ATM Both", lat, lng);
                        Uri geo = Uri.parse(geoURI);
                        Intent geoMap = new Intent(Intent.ACTION_VIEW, geo);
                        startActivity(geoMap);
                    }


                }
                //----------- end of ATM Both block ----------------

                //------------ Resturant blocks -------------------
                else if(web[+position]=="Resturant"){


                    lat = gps.getLatitude();
                    lng = gps.getLongitude();

                    String lat1 = Double.toString(lat);
                    String lng1 = Double.toString(lng);

                    if(lat1==""&&lng1==""){
                        String str = "pls check connection";
                        Toast.makeText(getBaseContext(), str, Toast.LENGTH_LONG).show();
                    }

                    else {

                        String geoURI = String.format("geo:%f,%f?q=Resturant", lat, lng);
                        Uri geo = Uri.parse(geoURI);
                        Intent geoMap = new Intent(Intent.ACTION_VIEW, geo);
                        startActivity(geoMap);
                    }


                }
                //----------- end of Resturant Both block ----------------

                //------------ Hotel Both blocks -------------------
                else if(web[+position]=="Hotel"){


                    lat = gps.getLatitude();
                    lng = gps.getLongitude();

                    String lat1 = Double.toString(lat);
                    String lng1 = Double.toString(lng);

                    if(lat1==""&&lng1==""){
                        String str = "pls check connection";
                        Toast.makeText(getBaseContext(), str, Toast.LENGTH_LONG).show();
                    }

                    else {

                        String geoURI = String.format("geo:%f,%f?q=Hotel", lat, lng);
                        Uri geo = Uri.parse(geoURI);
                        Intent geoMap = new Intent(Intent.ACTION_VIEW, geo);
                        startActivity(geoMap);
                    }


                }
              /*  //----------- Search block ----------------

                else if(web[+position]=="Search"){
                    Toast.makeText(MainActivity.this, "You Clicked at " + web[+position], Toast.LENGTH_SHORT).show();
                    Intent intent;
                    intent = new Intent(MainActivity.this,SearchActivity2.class);
                   startActivity(intent);

                }
                //----------- end of Search block ---------------- */



            }
        });

        searchEditTxt.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                searchEditTxt.setText(null);

            }

        });
        //----------------- search button work -----------------

        searchBtn.getBackground().setColorFilter(0xFFFF0000, PorterDuff.Mode.MULTIPLY);

        searchBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                double lat, lng;

                String textValues = searchEditTxt.getText().toString();
                // Toast.makeText(getBaseContext(), textValues, Toast.LENGTH_LONG).show();

                if (textValues.isEmpty() || textValues.equals("Search Other Places")) {

                    Snackbar.make(v, "Please Enter a Place Name or Your Own Address", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();

                } else {
                    lat = gps.getLatitude();
                    lng = gps.getLongitude();

                    //String la1 = Double.toString(lat);
                    //String ln1 = Double.toString(lng);

                    if (!manager.isProviderEnabled( LocationManager.GPS_PROVIDER )) {
                        //String str = "pls check connection";
                        //Toast.makeText(getBaseContext(), textValues, Toast.LENGTH_LONG).show();
                        showSettingsAlert();
                    } else {

                        String geoURI = String.format("geo:%f,%f?q=" + textValues, lat, lng);
                        Uri geo = Uri.parse(geoURI);
                        Intent geoMap = new Intent(Intent.ACTION_VIEW, geo);
                        startActivity(geoMap);
                    }
                }
            }

        });
        //---------------- ens of search button work -----------


    }


    //-------------------- all tts methods ---------------

    private void speakWords(String speech) {

        //speak straight away
        //  myTTS.speak(speech, TextToSpeech.QUEUE_FLUSH, null);
    }
    //--------------------end of tts methods ---------------

    //----------- Alert method ---------

    public void showSettingsAlert() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(
                SearchNearbyPlaceActivity.this);
        alertDialog.setTitle("SETTINGS");
        alertDialog.setMessage("Enable Location Provider! Go to settings menu?");
        alertDialog.setPositiveButton("Settings",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(
                                Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                        SearchNearbyPlaceActivity.this.startActivity(intent);
                    }
                });
        alertDialog.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        alertDialog.show();
    }
    //---------- end ---------------




}

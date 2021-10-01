package xyz.redbooks.umme.Activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;



import java.util.ArrayList;
import java.util.Arrays;

import xyz.redbooks.umme.R;

public class BdPoliceStationActivity extends AppCompatActivity {
    String[] items;

    ArrayList<String> listItems;

    ArrayAdapter<String> adapter;

    ListView listView;
    //SearchView searchView;
    //SearchView searchView;

    SearchView searchView;
    EditText inputSearch;
    boolean flag = false;

    boolean flag2 = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bd_police_station);
        listView=(ListView)findViewById(R.id.listview);
        //searchView=(SearchView) findViewById(R.id.search_id);
        inputSearch = (EditText) findViewById(R.id.inputSearch);

        initList();

    }

    public void initList(){

        items=new String[]{"Khilkhet Police Station\n01769-691792","Airport Police Station\n01713-373162",
                "Dhaka Metropolitan Police Headquarters\n02-8614300","Cantonment Police Station\n02-8829179",
                "Banani Police Station\n01769-058053","Dakshinkhan Police Station\n02-8931777",
                "New Market Police Statio\n02-8631942","Sutrapur Police Station\n02-7116233","Farmgate Police Box\n02-9119925",
                "Badda Police Station\n01713-373173",
                "Khilgaon Police Station\n02-7219090","Ramna Model Police Station\n01713-373125","Kafrul Police Station\n02-9871771","Pallabi Police Station\n01713-373190",

                "Chawk Bazar Police Station\n02-7313966","Jatrabari Thana\n01713-373146","Dhanmondi Model Thana\n02-8631941",

                "Dhaka Railway Police Station\n01952-233695","Rupnagor Police Station\n01713-373190",
                "Abdullahpur Police Barrack\n01794-449949","Darussalam Police Station\n08032-333","Uttara East Police Station\n01199-883740",

                "Tejgaon Police Station\n01713-373181","Dhanmondi 27 Police Box\n01713-373126","RAB 3\n01777-710300","Motijheel Police Station\n02-9571000",

                "RAB 3 Head Quarter\n02-7174685","Bangladesh Police Head Quarters\n02-9558363","Mohammadpur Police Station\n01713-373182","Shajahanpur Police Station\n02-9360535",


                "Rapid Action Battalion Office\n02-8159860","Mugdapara Police Station\n01769-058061","Shah Ali Police Station\n01191-005500",

                "CID Headquarters\n02-9331043","Kalabagan Thana\n01713-398339","Paltan Model Thana\n02-9360802","Lalbagh Police Station\n01618-048956","Bangshal Police Station\n02-9565700",
                "Rapid Action Battalion 3\n01777-710399","Tongi Police Station\n02-9801116","Rampura Police Station\n01817-602050","Shabujbagh Police Station\n01713-373153",
                "Wari Thana\n02-9553377","Mohammadpur RAB Office\n02-8159860","Turag Police Station\n02-8982111",""};
        listItems=new ArrayList<>(Arrays.asList(items));

        adapter=new ArrayAdapter<String>(this,
                R.layout.sample_view, R.id.txtitem, listItems);

        listView.setAdapter(adapter);


        inputSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


                BdPoliceStationActivity.this.adapter.getFilter().filter(charSequence);

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        //search view action
        /*
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                adapter.getFilter().filter(newText);
                return false;
            }
        });
        */


        //list view with item selected action




        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0){

                    callActionPosition1();
                }

                else if(i==1){
                    //Toast.makeText(AllPoliceNumber.this, "Position1", Toast.LENGTH_SHORT).show();
                    callActionOneTwo();
                }

                else if(i==2){
                    //Toast.makeText(AllPoliceNumber.this, "Position2", Toast.LENGTH_SHORT).show();
                    callActionPosition2();
                }
                else if(i==3){
                    //Toast.makeText(AllPoliceNumber.this, "Position3", Toast.LENGTH_SHORT).show();
                    callActionPosition3();
                }
                else if(i==4){
                    //Toast.makeText(AllPoliceNumber.this, "Position4", Toast.LENGTH_SHORT).show();
                    callActionPosition4();
                }
                else if(i==5){
                    //Toast.makeText(AllPoliceNumber.this, "Position5", Toast.LENGTH_SHORT).show();
                    callActionPosition5();
                }
                else if(i==6){
                    //Toast.makeText(AllPoliceNumber.this, "Position6", Toast.LENGTH_SHORT).show();
                    callActionPosition6();
                }
                else if(i==7){

                    callActionPosition7();
                }


                if(i==8){
                    //Toast.makeText(AllPoliceNumber.this, "position8", Toast.LENGTH_SHORT).show();
                    callActionPosition8();
                }

                else if(i==9){
                    //Toast.makeText(AllPoliceNumber.this, "Position9", Toast.LENGTH_SHORT).show();
                    callActionPosition9();
                }

                else if(i==10){
                    //Toast.makeText(AllPoliceNumber.this, "Position10", Toast.LENGTH_SHORT).show();
                    callActionPosition10();
                }
                else if(i==11){
                    //Toast.makeText(AllPoliceNumber.this, "Position11", Toast.LENGTH_SHORT).show();
                    callActionPosition11();
                }
                else if(i==12){
                    //Toast.makeText(AllPoliceNumber.this, "Position12", Toast.LENGTH_SHORT).show();
                    callActionPosition12();
                }
                else if(i==13){
                    //Toast.makeText(AllPoliceNumber.this, "Position13", Toast.LENGTH_SHORT).show();
                    callActionPosition13();
                }
                else if(i==14){
                    //Toast.makeText(AllPoliceNumber.this, "Position14", Toast.LENGTH_SHORT).show();
                    callActionPosition14();
                }
                else if(i==15){
                    //Toast.makeText(AllPoliceNumber.this, "Position15", Toast.LENGTH_SHORT).show();
                    callActionPosition15();
                }


                else if(i==16){
                    //Toast.makeText(AllPoliceNumber.this, "Position16", Toast.LENGTH_SHORT).show();
                    callActionPosition16();
                }

                else if(i==17){
                    //Toast.makeText(AllPoliceNumber.this, "Position17", Toast.LENGTH_SHORT).show();
                    callActionPosition17();
                }
                else if(i==18){
                    //Toast.makeText(AllPoliceNumber.this, "Position18", Toast.LENGTH_SHORT).show();
                    callActionPosition18();
                }
                else if(i==19){
                    //Toast.makeText(AllPoliceNumber.this, "Position19", Toast.LENGTH_SHORT).show();
                    callActionPosition19();
                }
                else if(i==20){
                    //Toast.makeText(AllPoliceNumber.this, "Position20", Toast.LENGTH_SHORT).show();
                    callActionPosition20();
                }
                else if(i==21){
                    //Toast.makeText(AllPoliceNumber.this, "Position21", Toast.LENGTH_SHORT).show();
                    callActionPosition21();
                }
                else if(i==22){
                    //Toast.makeText(AllPoliceNumber.this, "Position22", Toast.LENGTH_SHORT).show();
                    callActionPosition22();
                }


                if(i==23){
                    //Toast.makeText(AllPoliceNumber.this, "position23", Toast.LENGTH_SHORT).show();
                    callActionPosition23();
                }

                else if(i==24){
                    //Toast.makeText(AllPoliceNumber.this, "Position24", Toast.LENGTH_SHORT).show();
                    callActionPosition24();
                }

                else if(i==25){
                    //Toast.makeText(AllPoliceNumber.this, "Position25", Toast.LENGTH_SHORT).show();

                    callActionPosition25();
                }
                else if(i==26){
                    //Toast.makeText(AllPoliceNumber.this, "Position26", Toast.LENGTH_SHORT).show();
                    callActionPosition26();
                }
                else if(i==27){
                    //Toast.makeText(AllPoliceNumber.this, "Position27", Toast.LENGTH_SHORT).show();
                    callActionPosition27();
                }
                else if(i==28){
                    //Toast.makeText(AllPoliceNumber.this, "Position28", Toast.LENGTH_SHORT).show();
                    callActionPosition28();
                }
                else if(i==29){
                    //Toast.makeText(AllPoliceNumber.this, "Position29", Toast.LENGTH_SHORT).show();
                    callActionPosition29();
                }
                else if(i==30){
                    //Toast.makeText(AllPoliceNumber.this, "Position30", Toast.LENGTH_SHORT).show();
                    callActionPosition30();
                }

                else if(i==31){
                    //Toast.makeText(AllPoliceNumber.this, "Position31", Toast.LENGTH_SHORT).show();
                    callActionPosition31();
                }

                else if(i==32){
                    //Toast.makeText(AllPoliceNumber.this, "Position32", Toast.LENGTH_SHORT).show();
                    callActionPosition32();
                }
                else if(i==33){
                    //Toast.makeText(AllPoliceNumber.this, "Position33", Toast.LENGTH_SHORT).show();
                    callActionPosition33();
                }
                else if(i==34){

                    callActionPosition34();

                }
                else if(i==35){
                    //Toast.makeText(AllPoliceNumber.this, "Position35", Toast.LENGTH_SHORT).show();
                    callActionPosition35();
                }
                else if(i==36){
                    //Toast.makeText(AllPoliceNumber.this, "Position36", Toast.LENGTH_SHORT).show();
                    callActionPosition36();
                }
                else if(i==37){
                    //Toast.makeText(AllPoliceNumber.this, "Position37", Toast.LENGTH_SHORT).show();
                    callActionPosition37();
                }


                if(i==38){
                    //Toast.makeText(AllPoliceNumber.this, "position38", Toast.LENGTH_SHORT).show();
                    callActionPosition38();
                }

                else if(i==39){
                    //Toast.makeText(AllPoliceNumber.this, "Position39", Toast.LENGTH_SHORT).show();
                    callActionPosition39();
                }

                else if(i==40){
                    //Toast.makeText(AllPoliceNumber.this, "Position40", Toast.LENGTH_SHORT).show();
                    callActionPosition40();
                }
                else if(i==41){
                    //Toast.makeText(AllPoliceNumber.this, "Position41", Toast.LENGTH_SHORT).show();
                    callActionPosition41();
                }
                else if(i==42){
                    //Toast.makeText(AllPoliceNumber.this, "Position42", Toast.LENGTH_SHORT).show();
                    callActionPosition42();
                }
                else if(i==43){
                    //Toast.makeText(AllPoliceNumber.this, "Position43", Toast.LENGTH_SHORT).show();
                    callActionPosition43();
                }
                else if(i==44){
                    //Toast.makeText(AllPoliceNumber.this, "Position44", Toast.LENGTH_SHORT).show();
                    callActionPosition44();
                }
                else if(i==45){
                    //Toast.makeText(AllPoliceNumber.this, "Position45", Toast.LENGTH_SHORT).show();
                    callActionPosition45();
                }









            }
        });

    }

    private void callActionPosition1() {




    }


    private void callActionOneTwo() {




    }

    private void callActionPosition3(){



        //do action here
        //do action here
        Toast.makeText(this, "canotonment police", Toast.LENGTH_SHORT).show();

        String number = "028829179";
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + number));
        if (ActivityCompat.checkSelfPermission(BdPoliceStationActivity.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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

    private void callActionPosition2() {

        //4no index



        //do action here

    }

    private void callActionPosition4(){





        //do action here

        //do action here
        Toast.makeText(this, "Banani police station", Toast.LENGTH_SHORT).show();

        String number = "01769058053";
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + number));
        if (ActivityCompat.checkSelfPermission(BdPoliceStationActivity.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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

    private void callActionPosition8(){




        //do action here
        //do action here
        Toast.makeText(this, "Framgate police box", Toast.LENGTH_SHORT).show();

        String number = "029119925";
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + number));
        if (ActivityCompat.checkSelfPermission(BdPoliceStationActivity.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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
    private void callActionPosition7(){





        //do action here

        //do action here
        Toast.makeText(this, "Sutrapur police station", Toast.LENGTH_SHORT).show();

        String number = "027116233";
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + number));
        if (ActivityCompat.checkSelfPermission(BdPoliceStationActivity.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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
    private void callActionPosition6(){



        //do action here
        //do action here
        Toast.makeText(this, "New market police station", Toast.LENGTH_SHORT).show();

        String number = "028631942";
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + number));
        if (ActivityCompat.checkSelfPermission(BdPoliceStationActivity.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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

    private void callActionPosition5(){

        //do action here
        Toast.makeText(this, "Dakshikkan police station", Toast.LENGTH_SHORT).show();

        String number = "028931777";
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + number));
        if (ActivityCompat.checkSelfPermission(BdPoliceStationActivity.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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







    private void callActionPosition9() {

        //do action here
        Toast.makeText(this, "Badda ps", Toast.LENGTH_SHORT).show();

        String number = "01713373173";
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + number));
        if (ActivityCompat.checkSelfPermission(BdPoliceStationActivity.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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

    private void callActionPosition10() {


        //do action here
        Toast.makeText(this, "Khilgan po", Toast.LENGTH_SHORT).show();
        String number = "027219090";
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + number));
        if (ActivityCompat.checkSelfPermission(BdPoliceStationActivity.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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

    private void callActionPosition11() {


        //do action here
        Toast.makeText(this, "Ramna model", Toast.LENGTH_SHORT).show();
        String number = "01713373125";
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + number));
        if (ActivityCompat.checkSelfPermission(BdPoliceStationActivity.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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

    private void callActionPosition12() {


        //do action here
        Toast.makeText(this, "Kafrul ps", Toast.LENGTH_SHORT).show();


        String number = "029871771";
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + number));
        if (ActivityCompat.checkSelfPermission(BdPoliceStationActivity.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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


    private void callActionPosition14(){




        //do action here
        Toast.makeText(this, "Chawkbajar police station", Toast.LENGTH_SHORT).show();

        String number = "027313966";
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + number));
        if (ActivityCompat.checkSelfPermission(BdPoliceStationActivity.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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

    private void callActionPosition13() {


        Toast.makeText(this, "Pallabi police station", Toast.LENGTH_SHORT).show();

        //do action here
        String number = "01713373190";
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + number));
        if (ActivityCompat.checkSelfPermission(BdPoliceStationActivity.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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

    private void callActionPosition15() {

        Toast.makeText(this, "Jatrabari thana", Toast.LENGTH_SHORT).show();
        //do action here
        String number = "01713373146";
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + number));
        if (ActivityCompat.checkSelfPermission(BdPoliceStationActivity.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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

    private void callActionPosition16() {


        //do action here
        Toast.makeText(this, "Dhanmondi model thana", Toast.LENGTH_SHORT).show();
        String number = "028631941";
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + number));
        if (ActivityCompat.checkSelfPermission(BdPoliceStationActivity.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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

    private void callActionPosition17() {



        //do action here
        Toast.makeText(this, "Dhaka railway police stattion", Toast.LENGTH_SHORT).show();
        String number = "01952233695";
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + number));
        if (ActivityCompat.checkSelfPermission(BdPoliceStationActivity.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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

    private void callActionPosition18() {



        //do action here
        Toast.makeText(this, "Rupnagar police ", Toast.LENGTH_SHORT).show();
        String number = "01713373190";
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + number));
        if (ActivityCompat.checkSelfPermission(BdPoliceStationActivity.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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

    private void callActionPosition19() {



        //do action here
        Toast.makeText(this, "Abdullapur police brack", Toast.LENGTH_SHORT).show();

        String number = "01794449949";
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + number));
        if (ActivityCompat.checkSelfPermission(BdPoliceStationActivity.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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

    private void callActionPosition20() {




        //do action here
        Toast.makeText(this, "Darussalam police station", Toast.LENGTH_SHORT).show();

        String number = "08032333";
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + number));
        if (ActivityCompat.checkSelfPermission(BdPoliceStationActivity.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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

    private void callActionPosition21() {

        Toast.makeText(this, "Uttara east PO", Toast.LENGTH_SHORT).show();

        //do action here
        String number = "01199883740";
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + number));
        if (ActivityCompat.checkSelfPermission(BdPoliceStationActivity.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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

    private void callActionPosition22() {



        //do action here
        Toast.makeText(this, "Tejganj police stattion", Toast.LENGTH_SHORT).show();
        String number = "01713373181";
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + number));
        if (ActivityCompat.checkSelfPermission(BdPoliceStationActivity.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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

    private void callActionPosition23() {




        //do action here
        Toast.makeText(this, "Dhanmondi 27 police box", Toast.LENGTH_SHORT).show();

        String number = "01713373126";
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + number));
        if (ActivityCompat.checkSelfPermission(BdPoliceStationActivity.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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

    private void callActionPosition24() {


        //do action here
        Toast.makeText(this, "RAB3", Toast.LENGTH_SHORT).show();
        String number = "01777710300";
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + number));
        if (ActivityCompat.checkSelfPermission(BdPoliceStationActivity.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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

    private void callActionPosition25() {

        //do action here
        Toast.makeText(this, "Motojhil police station", Toast.LENGTH_SHORT).show();
        String number = "029571000";
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + number));
        if (ActivityCompat.checkSelfPermission(BdPoliceStationActivity.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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

    private void callActionPosition26() {


        //do action here
        Toast.makeText(this, "RAB3 headquater", Toast.LENGTH_SHORT).show();

        String number = "027174685";
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + number));
        if (ActivityCompat.checkSelfPermission(BdPoliceStationActivity.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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

    private void callActionPosition27() {

        //do action here
        Toast.makeText(this, "BD police headquater", Toast.LENGTH_SHORT).show();
        String number = "029558363";
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + number));
        if (ActivityCompat.checkSelfPermission(BdPoliceStationActivity.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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

    private void callActionPosition28() {



        //do action here
        Toast.makeText(this, "Mohammadpur police station", Toast.LENGTH_SHORT).show();
        String number = "01713373182";
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + number));
        if (ActivityCompat.checkSelfPermission(BdPoliceStationActivity.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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

    private void callActionPosition29() {



        //do action here
        Toast.makeText(this, "Shahjanpur police station", Toast.LENGTH_SHORT).show();
        String number = "029360535";
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + number));
        if (ActivityCompat.checkSelfPermission(BdPoliceStationActivity.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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

    private void callActionPosition30() {


        //do action here
        Toast.makeText(this, "RAB office", Toast.LENGTH_SHORT).show();
        String number = "028159860";
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + number));
        if (ActivityCompat.checkSelfPermission(BdPoliceStationActivity.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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

    private void callActionPosition31() {



        //do action here
        Toast.makeText(this, "Mughdara police sttation", Toast.LENGTH_SHORT).show();

        String number = "01769058061";
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + number));
        if (ActivityCompat.checkSelfPermission(BdPoliceStationActivity.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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




    private void callActionPosition32() {



        //do action here
        Toast.makeText(this, "Shahh ali police station", Toast.LENGTH_SHORT).show();


        String number = "01191005500";
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + number));
        if (ActivityCompat.checkSelfPermission(BdPoliceStationActivity.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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

    private void callActionPosition33() {


        //do action here
        Toast.makeText(this, "CID head quaters", Toast.LENGTH_SHORT).show();
        String number = "029331043";
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + number));
        if (ActivityCompat.checkSelfPermission(BdPoliceStationActivity.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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

    private void callActionPosition34() {


        Toast.makeText(this, "Kalabagan police station", Toast.LENGTH_SHORT).show();

        //do action here
        String number = "01713398339";
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + number));
        if (ActivityCompat.checkSelfPermission(BdPoliceStationActivity.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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

    private void callActionPosition35() {

        Toast.makeText(this, "Paltan model thana", Toast.LENGTH_SHORT).show();
        //do action here
        String number = "029360802";
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + number));
        if (ActivityCompat.checkSelfPermission(BdPoliceStationActivity.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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

    private void callActionPosition36() {

        Toast.makeText(this, "Lalbag police station", Toast.LENGTH_SHORT).show();
        //do action here
        String number = "01618048956";
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + number));
        if (ActivityCompat.checkSelfPermission(BdPoliceStationActivity.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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

    private void callActionPosition37() {

        Toast.makeText(this, "Bongshal police station", Toast.LENGTH_SHORT).show();

        //do action here
        String number = "029565700";
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + number));
        if (ActivityCompat.checkSelfPermission(BdPoliceStationActivity.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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



    private void callActionPosition38() {

        //do action
        Toast.makeText(this, "Rapid action b3", Toast.LENGTH_SHORT).show();
        String number = "01777710399";
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + number));
        if (ActivityCompat.checkSelfPermission(BdPoliceStationActivity.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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

    private void callActionPosition39() {

        Toast.makeText(this, "Tongi police station", Toast.LENGTH_SHORT).show();

        //do action here
        String number = "029801116";
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + number));
        if (ActivityCompat.checkSelfPermission(BdPoliceStationActivity.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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

    private void callActionPosition40() {

        //do action here
        Toast.makeText(this, "Rampura ps", Toast.LENGTH_SHORT).show();
        String number = "011817602050";
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + number));
        if (ActivityCompat.checkSelfPermission(BdPoliceStationActivity.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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

    private void callActionPosition41() {


        //do action here
        Toast.makeText(this, "Subahangbag police station", Toast.LENGTH_SHORT).show();
        String number = "01713373153";
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + number));
        if (ActivityCompat.checkSelfPermission(BdPoliceStationActivity.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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

    private void callActionPosition42() {


        //do action
        Toast.makeText(this, "Wari thana", Toast.LENGTH_SHORT).show();

        String number = "029553377";
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + number));
        if (ActivityCompat.checkSelfPermission(BdPoliceStationActivity.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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

    private void callActionPosition43() {



        //do action here

        Toast.makeText(this, "Mohammadppur rab office", Toast.LENGTH_SHORT).show();
        String number = "028159860";
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + number));
        if (ActivityCompat.checkSelfPermission(BdPoliceStationActivity.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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

    private void callActionPosition44() {



        //do action here
        Toast.makeText(this, "Turag police station", Toast.LENGTH_SHORT).show();

        String number = "028982111";
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + number));
        if (ActivityCompat.checkSelfPermission(BdPoliceStationActivity.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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

    private void callActionPosition45() {


        //do action here
    }

    //sensor event action



    @Override
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_VOLUME_DOWN) {
            Log.d("Test", "Long press!");
            Toast.makeText(getApplicationContext(), "Long KEYCODE_VOLUME_DOWN", Toast.LENGTH_LONG).show();
            flag = false;
            flag2 = true;
            return true;
        }
        if (keyCode == KeyEvent.KEYCODE_CAMERA){
            Toast.makeText(getApplicationContext(), "Long KEYCODE_CAMERA", Toast.LENGTH_LONG).show();
        }
        return super.onKeyLongPress(keyCode, event);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_VOLUME_DOWN) {
            Toast.makeText(getApplicationContext(), "KEYCODE_VOLUME_DOWN", Toast.LENGTH_LONG).show();
            event.startTracking();
            if (flag2 == true) {
                flag = false;
            } else {

                flag = true;
                flag2 = false;
            }
            return true;
        }
        if (keyCode == KeyEvent.KEYCODE_CAMERA){
            Toast.makeText(getApplicationContext(), "KEYCODE_CAMERA", Toast.LENGTH_LONG).show();
        }
        if(keyCode == KeyEvent.KEYCODE_HEADSETHOOK)
        {
            Toast.makeText(getApplicationContext(), "KEYCODE_HEADSETHOOK", Toast.LENGTH_SHORT).show();
        }
        if(keyCode == KeyEvent.KEYCODE_ENDCALL)
        {
            Toast.makeText(getApplicationContext(), "KEYCODE_ENDCALL", Toast.LENGTH_SHORT).show();
        }
        if(keyCode == KeyEvent.KEYCODE_BACK)
        {
            Toast.makeText(getApplicationContext(), "KEYCODE_BACK", Toast.LENGTH_SHORT).show();

        }
        if(keyCode == KeyEvent.KEYCODE_AVR_INPUT)
        {
            Toast.makeText(getApplicationContext(), "KEYCODE_AVR_INPUT", Toast.LENGTH_SHORT).show();
        }
        if(keyCode == KeyEvent.KEYCODE_AVR_POWER)
        {
            Toast.makeText(getApplicationContext(), "KEYCODE_AVR_POWER", Toast.LENGTH_SHORT).show();
        }
        if(keyCode == KeyEvent.KEYCODE_BREAK)
        {
            Toast.makeText(getApplicationContext(), "KEYCODE_BREAK", Toast.LENGTH_SHORT).show();
        }
        if(keyCode == KeyEvent.KEYCODE_BRIGHTNESS_DOWN)
        {
            Toast.makeText(getApplicationContext(), "KEYCODE_BRIGHTNESS_DOWN", Toast.LENGTH_SHORT).show();
        }
        if(keyCode == KeyEvent.KEYCODE_BRIGHTNESS_UP)
        {
            Toast.makeText(getApplicationContext(), "KEYCODE_BRIGHTNESS_UP", Toast.LENGTH_SHORT).show();
        }
        if(keyCode == KeyEvent.KEYCODE_BUTTON_THUMBL)
        {
            Toast.makeText(getApplicationContext(), "KEYCODE_BUTTON_THUMBL", Toast.LENGTH_SHORT).show();
        }
        if(keyCode == KeyEvent.KEYCODE_BUTTON_THUMBR)
        {
            Toast.makeText(getApplicationContext(), "KEYCODE_BUTTON_THUMBR", Toast.LENGTH_SHORT).show();
        }
        if(keyCode == KeyEvent.KEYCODE_BUTTON_START)
        {
            Toast.makeText(getApplicationContext(), "KEYCODE_BUTTON_START", Toast.LENGTH_SHORT).show();
        }
        if(keyCode == KeyEvent.KEYCODE_ENDCALL)
        {
            Toast.makeText(getApplicationContext(), "KEYCODE_ENDCALL", Toast.LENGTH_SHORT).show();
        }
        if(keyCode == KeyEvent.KEYCODE_BUTTON_L1)
        {
            Toast.makeText(getApplicationContext(), "KEYCODE_BUTTON_L1", Toast.LENGTH_SHORT).show();
        }
        if(keyCode == KeyEvent.KEYCODE_BUTTON_L2)
        {
            Toast.makeText(getApplicationContext(), "KEYCODE_BUTTON_L2", Toast.LENGTH_SHORT).show();
        }
        if(keyCode == KeyEvent.KEYCODE_BUTTON_R1)
        {
            Toast.makeText(getApplicationContext(), "KEYCODE_BUTTON_R1", Toast.LENGTH_SHORT).show();
        }
        if(keyCode == KeyEvent.KEYCODE_BUTTON_R2)
        {
            Toast.makeText(getApplicationContext(), "KEYCODE_BUTTON_R2", Toast.LENGTH_SHORT).show();
        }
        if(keyCode == KeyEvent.KEYCODE_CALL)
        {
            Toast.makeText(getApplicationContext(), "KEYCODE_CALL", Toast.LENGTH_SHORT).show();
        }
        if(keyCode == KeyEvent.KEYCODE_HOME)
        {
            Toast.makeText(getApplicationContext(), "KEYCODE_HOME", Toast.LENGTH_SHORT).show();
        }
        if(keyCode == KeyEvent.KEYCODE_POWER)
        {
            Toast.makeText(getApplicationContext(), "KEYCODE_POWER", Toast.LENGTH_SHORT).show();
            alertMethodForCall();
        }
        if(keyCode == KeyEvent.KEYCODE_SOFT_RIGHT)
        {
            Toast.makeText(getApplicationContext(), "KEYCODE_SOFT_RIGHT", Toast.LENGTH_SHORT).show();
        }
        if(keyCode == KeyEvent.KEYCODE_SOFT_LEFT)
        {
            Toast.makeText(getApplicationContext(), "KEYCODE_SOFT_LEFT", Toast.LENGTH_SHORT).show();
        }
        if(keyCode == KeyEvent.KEYCODE_MENU)
        {
            Toast.makeText(getApplicationContext(), "KEYCODE_MENU", Toast.LENGTH_SHORT).show();
        }
        if(keyCode == KeyEvent.KEYCODE_MEDIA_PREVIOUS)
        {
            Toast.makeText(getApplicationContext(), "KEYCODE_MEDIA_PREVIOUS", Toast.LENGTH_SHORT).show();
        }
        if(keyCode == KeyEvent.KEYCODE_MEDIA_NEXT)
        {
            Toast.makeText(getApplicationContext(), "KEYCODE_MEDIA_NEXT", Toast.LENGTH_SHORT).show();
        }
        if(keyCode == KeyEvent.KEYCODE_MEDIA_PLAY)
        {
            Toast.makeText(getApplicationContext(), "KEYCODE_MEDIA_PLAY", Toast.LENGTH_SHORT).show();
        }
        if(keyCode == KeyEvent.KEYCODE_MEDIA_PAUSE)
        {
            Toast.makeText(getApplicationContext(), "KEYCODE_MEDIA_PAUSE", Toast.LENGTH_SHORT).show();
        }
        if(keyCode == KeyEvent.KEYCODE_MEDIA_PLAY_PAUSE)
        {
            Toast.makeText(getApplicationContext(), "KEYCODE_MEDIA_PLAY_PAUSE", Toast.LENGTH_SHORT).show();
        }
        if(keyCode == KeyEvent.KEYCODE_MEDIA_STOP)
        {
            Toast.makeText(getApplicationContext(), "KEYCODE_MEDIA_STOP", Toast.LENGTH_SHORT).show();
        }
        if(keyCode == KeyEvent.KEYCODE_POUND)
        {
            Toast.makeText(getApplicationContext(), "KEYCODE_POUND", Toast.LENGTH_SHORT).show();
        }
        if(keyCode == KeyEvent.KEYCODE_SETTINGS)
        {
            Toast.makeText(getApplicationContext(), "KEYCODE_SETTINGS", Toast.LENGTH_SHORT).show();
        }
        if(keyCode == KeyEvent.KEYCODE_SEARCH)
        {
            Toast.makeText(getApplicationContext(), "KEYCODE_SEARCH", Toast.LENGTH_SHORT).show();
        }
        if(keyCode == KeyEvent.KEYCODE_SLEEP)
        {
            Toast.makeText(getApplicationContext(), "KEYCODE_SLEEP", Toast.LENGTH_SHORT).show();
        }
        if(keyCode == KeyEvent.KEYCODE_STAR)
        {
            Toast.makeText(getApplicationContext(), "KEYCODE_STAR", Toast.LENGTH_SHORT).show();
        }
        if(keyCode == KeyEvent.	KEYCODE_TAB)
        {
            Toast.makeText(getApplicationContext(), "KEYCODE_TAB", Toast.LENGTH_SHORT).show();
        }

        if(keyCode== KeyEvent.KEYCODE_VOLUME_UP){
            alertMethodForCall();
        }
        if(keyCode == KeyEvent.KEYCODE_VOLUME_MUTE)

        {
            Toast.makeText(getApplicationContext(), "KEYCODE_VOLUME_MUTE", Toast.LENGTH_SHORT).show();

        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_VOLUME_UP) {
            Toast.makeText(getApplicationContext(), "KEYCODE_VOLUME_UP", Toast.LENGTH_LONG).show();
            event.startTracking();
            if (flag) {
                Log.d("Test", "Short");
            }
            flag = true;
            flag2 = false;
            return true;
        }
        return super.onKeyUp(keyCode, event);
    }




    public void alertMethodForCall() {
        //
        AlertDialog.Builder MyBuild = new AlertDialog.Builder(BdPoliceStationActivity.this);
        MyBuild.setTitle("Do you want to call 999?");
        MyBuild.setMessage("Are you confirm?");
        //MyBuild.setIcon(R.drawable.graduate);
        MyBuild.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Toast.makeText(getApplicationContext(), "Ohh Lol", Toast.LENGTH_SHORT).show();
                String number = "999";
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + number));
                if (ActivityCompat.checkSelfPermission(BdPoliceStationActivity.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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
        });

        //Click listner for Negative button

        MyBuild.setNegativeButton("No ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "Finally done", Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog obj = MyBuild.create();
        obj.show();


    }

}

package com.nslabs.ns;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

/**
 * Created by sandhyamurali on 11/03/16.
 */
public class reminder extends Activity  {
    //TextView textview1;
    TimePicker timepicker1;
    Button button1;
    CheckBox cb, cb1, cb2, cb3, cb4, cb5, cb6;
     boolean validationError = false;
    boolean checked=false;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
   // private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reminder);

        cb = (CheckBox) findViewById(R.id.cb);
        cb1 = (CheckBox) findViewById(R.id.cb1);
        cb2 = (CheckBox) findViewById(R.id.cb2);
        cb3 = (CheckBox) findViewById(R.id.cb3);
        cb4 = (CheckBox) findViewById(R.id.cb4);
        cb5 = (CheckBox) findViewById(R.id.cb5);
        cb6 = (CheckBox) findViewById(R.id.cb6);

        //textview1=(TextView)findViewById(R.id.textView1);
        timepicker1 = (TimePicker) findViewById(R.id.timePicker1);
        //Uncomment the below line of code for 24 hour view
        timepicker1.setIs24HourView(true);
        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i("Print","You have clicked the Save button");
                //int hour=timepicker1.getHour();
               // int minutes=timepicker1.getMinute();
               // Log.i("Print","minutes is " +minutes);
                //Log.i("Print","minutes is " +hour);


            }
        });

        cb.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (((CheckBox) v).isChecked())
                    Log.i("Print", "You have clicked the one cbbutton");
                    // DisplayToast("CheckBox is checked");
                else
                    Log.i("Print","You have clicked the one cbbutton");
                // DisplayToast("CheckBox is unchecked");
            }
        });

        cb1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (((CheckBox) v).isChecked())
                    Log.i("Print", "You have clicked the one cbbutton");
                    // DisplayToast("CheckBox is checked");
                else
                    Log.i("Print","You have clicked the one cbbutton");
                // DisplayToast("CheckBox is unchecked");
            }
        });

        cb2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (((CheckBox) v).isChecked())
                    Log.i("Print", "You have clicked the one cbbutton");
                    // DisplayToast("CheckBox is checked");
                else
                    Log.i("Print","You have clicked the one cbbutton");
                // DisplayToast("CheckBox is unchecked");
            }
        });

        cb3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (((CheckBox) v).isChecked())
                    Log.i("Print", "You have clicked the one cbbutton");
                    // DisplayToast("CheckBox is checked");
                else
                    Log.i("Print","You have clicked the one cbbutton");
                // DisplayToast("CheckBox is unchecked");
            }
        });

        cb4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (((CheckBox) v).isChecked())
                    Log.i("Print", "You have clicked the one cbbutton");
                    // DisplayToast("CheckBox is checked");
                else
                    Log.i("Print","You have clicked the one cbbutton");
                // DisplayToast("CheckBox is unchecked");
            }
        });

        cb5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (((CheckBox) v).isChecked())
                    Log.i("Print", "You have clicked the one cbbutton");
                    // DisplayToast("CheckBox is checked");
                else
                    Log.i("Print","You have clicked the one cbbutton");
                // DisplayToast("CheckBox is unchecked");
            }
        });

        cb6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (((CheckBox) v).isChecked())
                    Log.i("Print", "You have clicked the one cbbutton");
                    // DisplayToast("CheckBox is checked");
                else
                    Log.i("Print","You have clicked the one cbbutton");
                // DisplayToast("CheckBox is unchecked");
            }
        });













        // cb.setOnClickListener(this);



        // textview1.setText(getCurrentTime());

        // This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        //client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }


    public String getCurrentTime() {
        String currentTime = "Current Time: " + timepicker1.getCurrentHour() + ":" + timepicker1.getCurrentMinute();
        return currentTime;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }



}

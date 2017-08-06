package com.nslabs.ns;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.parse.Parse;
import com.parse.ParseUser;


/**
 * Created by chait on 1/15/2016.
 */
public class Dispatch extends AppCompatActivity {
    final String MYPREFS ="mySharedPreferences";
    SharedPreferences mySharedPreferences ;
    @Override
    public void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        mySharedPreferences =getSharedPreferences(MYPREFS,MODE_PRIVATE);
        //Parse.initialize(this, "OGGJcPSGVQP7qKy5SWCy8sgOzxYTNF47vffbtkqq", "G8Q5TC4wCHIhQLhrr42cStco2kWOrql5nL0Tyhxu");
        // Check if there is current user info
        if (ParseUser.getCurrentUser() == null) {


            // Start an intent for the logged in activity
            startActivity(new Intent(this, login.class));
        }



        else
        {
            startActivity(new Intent(this,NavActivity.class));
        }
    }
}

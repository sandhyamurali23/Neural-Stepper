package com.nslabs.ns;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;

import com.parse.Parse;
import com.parse.ParseUser;

/**
 * Created by chait on 12/31/2015.
 */
public class ParseLogin extends android.app.Application {
@Override

    public void onCreate() {
super.onCreate();
        Parse.initialize(this, "OGGJcPSGVQP7qKy5SWCy8sgOzxYTNF47vffbtkqq", "G8Q5TC4wCHIhQLhrr42cStco2kWOrql5nL0Tyhxu");
    ParseUser.enableRevocableSessionInBackground();
    }
}


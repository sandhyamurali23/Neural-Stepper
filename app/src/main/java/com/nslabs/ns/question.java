package com.nslabs.ns;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

/**
 * Created by sandhyamurali on 16/03/16.
 */
public class question extends AppCompatActivity implements View.OnClickListener{

    final String MYPREFScount ="mySharedPreferences";
    final String MYPREFScount1 ="mySharedPreferences";
    final String MYPREFSanswer ="mySharedPreferences";


    //final String MYPREFS5="mysharedPreferences";
    SharedPreferences mySharedPreferences ;

    String percentage;
    int p;
    float percentage1,count1;
    TextView tvPercentage;
    Toolbar toolbar;
    Button bGetStarted;
    RadioButton r1,r2,r3,r4;
    int count;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question);

        mySharedPreferences= PreferenceManager.getDefaultSharedPreferences(this);
        Log.i("shared", "shared pref value is " + mySharedPreferences);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        android.support.v7.app.ActionBar ActionBar=getSupportActionBar();
        ActionBar.setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(R.drawable.close);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(question.this);
                alertDialog.setCancelable(false);
                // Setting Dialog Title
                alertDialog.setTitle("Confirm Delete...");

                // Setting Dialog Message
                alertDialog.setMessage("Are you sure you want to quit?");
                //waitTimer.cancel();
                //waitTimer = null;
                // Setting Icon to Dialog
                //alertDialog.setIcon(R.drawable.delete);

                // Setting Positive "Yes" Button
                alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {


                        Intent myIntent = new Intent(question.this, NavActivity.class);
                        // myIntent.putExtra("HighScore", .getText().toString());
                        startActivity(myIntent);

                        // Write your code here to invoke YES event

                        // Toast.makeText(getApplicationContext(), "You clicked on YES", Toast.LENGTH_SHORT).show();
                    }
                });

                // Setting Negative "NO" Button
                alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        // Write your code here to invoke NO event
                        // Toast.makeText(getApplicationContext(), "You clicked on NO", Toast.LENGTH_SHORT).show();

                        dialog.cancel();
                    }
                });

                // Showing Alert Message
                alertDialog.show();


                //What to do on back clicked
            }
        });


        mySharedPreferences =getSharedPreferences(MYPREFScount, MODE_PRIVATE);
        percentage1 = mySharedPreferences.getFloat("total", 0);
        p=Math.round(percentage1);
        percentage=Integer.toString(p);
        // putScores();
        Log.i("Display Maximum Scores", "The maximum score from prev  is " + percentage);

        tvPercentage = (TextView) findViewById(R.id.tvPercentage);
        tvPercentage.setText(percentage +"% Complete");

        bGetStarted = (Button) findViewById(R.id.bGetStarted);
        bGetStarted.setOnClickListener(this);




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_menu, menu);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("      Questionnaire");
        actionBar.show();


        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                // User chose the "Settings" item, show the app settings UI...
                return true;

            case R.id.action_favorite:
                // User chose the "Favorite" action, mark the current item
                // as a favorite...
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.bGetStarted:




                    //Log.i("if", " Inside if");

                    //Intent myIntent1 = new Intent(question.this, question1.class);
                    // myIntent.putExtra("HighScore", .getText().toString());
                   // startActivity(myIntent1);
               // }

               // else
               // {

                    Intent myIntent = new Intent(question.this, question1.class);
                    // myIntent.putExtra("HighScore", .getText().toString());
                    startActivity(myIntent);



                //}





                //startActivity(new Intent(this, TwoFinger.class));
                break;
        }

    }



}

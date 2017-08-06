package com.nslabs.ns;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.os.CountDownTimer;


import java.util.concurrent.TimeUnit;

public class TwoFinger extends AppCompatActivity implements View.OnClickListener {
    Button bButton1, bButton2;
    EditText Taps;
    TextView timer,Score;
    int count=0,max,count1;
    Toolbar toolbar;
    CountDownTimer waitTimer;
    String max1;
    final String MYPREFS ="mySharedPreferences";
    SharedPreferences mySharedPreferences ;
    final String MYPREFS1 ="mySharedPreferences";
    //SharedPreferences shared;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_two_finger);
        mySharedPreferences= PreferenceManager.getDefaultSharedPreferences(this);
        Log.i("shared","shared pref value is " +mySharedPreferences);
        //shared=getSharedPreferences("MYPREFS ", Context.MODE_PRIVATE);
        //max1=mySharedPreferences.getString("scores", "0");
        Intent myIntent = getIntent();
        max1=myIntent.getStringExtra("HighScore");

       Log.i("Display Scores", "The score is " + max1);

        //getActionBar().setTitle("Two Finger Tapping");
        //getActionBar().setIcon(R.drawable.my_icon);





        bButton1 = (Button) findViewById(R.id.bButton1);
        Taps=(EditText)findViewById(R.id.Taps);
        timer=(TextView)findViewById(R.id.timer);
        Score=(TextView)findViewById(R.id.Score);
        toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        android.support.v7.app.ActionBar ActionBar=getSupportActionBar();
        ActionBar.setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(R.drawable.close);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(TwoFinger.this);
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

                        // Write your code here to invoke YES event

                        Intent intent = new Intent(TwoFinger.this, tests.class);
                        startActivity(intent);
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



    bButton1.setOnClickListener(this);
        bButton2 = (Button) findViewById(R.id.bButton2);
        bButton2.setOnClickListener(this);

        waitTimer =new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {
                long millis = millisUntilFinished;
                String hms = String.format("%02d",
                        TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
                System.out.println(hms);
                timer.setText(hms);


            }

            public void onFinish() {
                timer.setText("done!");
               // bButton1.setEnabled(false);
                //bButton2.setEnabled(false);
                count1=Integer.parseInt(Taps.getText().toString());
                putScores1();
                Log.i("Display Taps", "The taps is " + count1);
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(TwoFinger.this);
                alertDialog.setCancelable(false);

                // Setting Dialog Title
                alertDialog.setTitle("Confirm Delete...");

                // Setting Dialog Message
                alertDialog.setMessage("You have scored"+count1+ "points.Do you want to restart?");

                // Setting Icon to Dialog
                //alertDialog.setIcon(R.drawable.delete);

                // Setting Positive "Yes" Button
                alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int which) {

                        // Write your code here to invoke YES event
                        dialog.cancel();
                        waitTimer.start();
                        count=0;
                        Taps.setText(Integer.toString(count));

                        // Toast.makeText(getApplicationContext(), "You clicked on YES", Toast.LENGTH_SHORT).show();
                    }
                });

                // Setting Negative "NO" Butt on
                alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        // Write your code here to invoke NO event
                        Log.i("Display Scores","The max score in sting format is " +max1);

                        max=Integer.parseInt(max1);
                        Log.i("Display Scores","The max score in integer format is " +max);

                        if (count1 > max) {
                            max=count1;


                            //Score.setText(Integer.toString(max));
                            //OldScores=displayScores();
                            max1=Integer.toString(max);
                            putScores();
                            // SharedPreferences.Editor edit = mySharedPreferences.edit();
                            // Commits the changes.
                            //edit.putString("scores",max1);

                            //edit.commit();

                            Log.i("Display Maximum Scores","The maximum score is " +max1);

                            Intent intent = new Intent(TwoFinger.this,tests.class);
                             //intent.putExtra("taps", count);

                            startActivity(intent);
                        }
                        else
                        {
                            //Score.setText(Integer.toString(max));
                            //max1=displayScores();
                            // String max1=Integer.toString(OldScores);
                            //  max1=mySharedPreferences.getString("scores", "0");
                            Log.i("Display Maximum Scores"," Else The maximum score is " +max1);
                            Intent intent = new Intent(TwoFinger.this,tests.class);
                            //intent.putExtra("score", max1);


                            startActivity(intent);
                        }








                        // Toast.makeText(getApplicationContext(), "You clicked on NO", Toast.LENGTH_SHORT).show();
                       // dialog.cancel();
                    }
                });

                // Showing Alert Message
                alertDialog.show();
                // User chose the "Favorite" action, mark the current item
                // as a favorite...
                //bButton1.setEnabled(false);
                // bButton2.setEnabled(false);



                // max1=mySharedPreferences.getString("scores", "0");

            }
        }.start();











    }


    @Override
    public void onBackPressed() {
        // do nothing.
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_menu, menu);
        android.support.v7.app.ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("   Two finger Tapping");
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
            case R.id.bButton1:
                count++;
                Taps.setText(Integer.toString(count));
                //Taps.setBackgroundColor(Color.CYAN);
                break;
            case R.id.bButton2:
                count++;
                Taps.setText(Integer.toString(count));
                //Taps.setBackgroundColor(Color.CYAN);
                break;
        }
    }

    protected String displayScores()
    {
        int mode = TwoFinger.MODE_PRIVATE;
        mySharedPreferences = getSharedPreferences("MYPREFS", mode);
        // To retrieve the saved values.
        String oldscores= mySharedPreferences.getString("scores","0" );
        return  oldscores;

    }

    protected  void putScores() {
        int mode = TwoFinger.MODE_PRIVATE;
        mySharedPreferences = getSharedPreferences(MYPREFS, mode);
        SharedPreferences.Editor edit = mySharedPreferences.edit();
        // Commits the changes.
        edit.remove("scores");
        edit.putString("scores",max1);

        edit.commit();
        //Log.d("mtag","scores");
    }

    protected  void putScores1() {
        int mode = TwoFinger.MODE_PRIVATE;
        mySharedPreferences = getSharedPreferences(MYPREFS1, mode);
        SharedPreferences.Editor edit = mySharedPreferences.edit();
        // Commits the changes.
        edit.remove("test");
        edit.putString("test",Taps.getText().toString());

        edit.commit();
        //Log.d("mtag","scores");
    }





}

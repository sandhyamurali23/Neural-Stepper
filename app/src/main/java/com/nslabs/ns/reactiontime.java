package com.nslabs.ns;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class reactiontime extends AppCompatActivity {
   // TextView hTextView;
    CountDownTimer waitTimer,waitTimer1;
    int[] images = new int[]{R.drawable.ball, R.drawable.check1, R.drawable.wrong};
    int n,tap=0,flag=0;
    ImageView mImageView;
    RelativeLayout rlayout;
    Toolbar toolbar;
    String hms;
    double hms1;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reactiontime);
        mImageView = (ImageView) findViewById(R.id.myImageView);
        toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        android.support.v7.app.ActionBar ActionBar=getSupportActionBar();
        ActionBar.setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(R.drawable.close);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(reactiontime.this);
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

                        Intent intent = new Intent(reactiontime.this, test3.class);
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


       // Random r1 = new Random();
       // n = r1.nextInt(3);
        //mImageView.setImageResource(images[n]);
        //mImageView.setImageResource(images[n]);

        rlayout = (RelativeLayout) findViewById(R.id.mainlayout);



       // Random r = new Random();
       // i = r.nextInt(8001 - 1000) + 1000;
        //flag++;
        //Log.i("initial time ", "time is " + i);
        //waitTimer = new MyCountDownTimer(800, 1000);
       // waitTimer.start();


        waitTimer =new CountDownTimer(800, 100) {

            public void onTick(long millisUntilFinished) {
                long millis = millisUntilFinished;
                hms = String.format("%02d",
                        TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
                System.out.println(hms);


                mImageView.setImageResource(images[0]);






                rlayout.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {

                        switch (v.getId()) {

                            case R.id.mainlayout:
                                tap++;
                                flag=1;
                                Log.i("taps", "taps is " + tap);
                                waitTimer.cancel();
                                hms1=Float.parseFloat(hms);
                                hms1=0.8-hms1;
                                Log.i("timer", "time is " + hms1);
                               // rlayout.setEnabled(false);


                                waitTimer1 = new CountDownTimer(3000, 1000) {

                                    public void onTick(long millisUntilFinished) {
                                        long millis = millisUntilFinished;
                                        hms = String.format("%02d",
                                                TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
                                        System.out.println(hms);
                                        mImageView.setVisibility(View.VISIBLE);
                                        rlayout.setEnabled(false);
                                        mImageView.setImageResource(images[1]);


                                    }

                                    public void onFinish() {




                                        waitTimer1 = new CountDownTimer(8000, 1000) {

                                            public void onTick(long millisUntilFinished) {
                                                long millis = millisUntilFinished;
                                                hms = String.format("%02d",
                                                        TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
                                                System.out.println(hms);
                                                mImageView.setVisibility(View.INVISIBLE);
                                                rlayout.setEnabled(false);
                                                //mImageView.setImageResource(images[2]);


                                            }

                                            public void onFinish() {

                                                rlayout.setEnabled(true);
                                                mImageView.setImageResource(images[0]);
                                                mImageView.setVisibility(View.VISIBLE);
                                                waitTimer.start();


                                                //waitTimer.start();
                                            }

                                        }.start();


                                        //rlayout.setEnabled(true);
                                      //  mImageView.setVisibility(View.INVISIBLE);
                                       // waitTimer.start();
                                        //flag=0;
                                        //waitTimer.start();
                                    }

                                }.start();


                               // mImageView.setImageResource(images[1]);
                               // mImageView.setVisibility(View.INVISIBLE);
                                //Random r1 = new Random();
                                //n = r1.nextInt(3);
                                //mImageView.setImageResource(images[n]);

                                break;



                        }


                    }

                });




                // timer.setText(hms);


            }

            public void onFinish() {



                if(tap==5)

                {


                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(reactiontime.this);
                    alertDialog.setCancelable(false);
                    // Setting Dialog Title
                    alertDialog.setTitle("Confirm Delete...");

                    // Setting Dialog Message
                    alertDialog.setMessage("You have completed the task.Do you want to restart?");
                    //waitTimer.cancel();
                    //waitTimer = null;
                    // Setting Icon to Dialog
                    //alertDialog.setIcon(R.drawable.delete);

                    // Setting Positive "Yes" Button
                    alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();

                            tap = 0;
                            //Random r1 = new Random();
                           // n = r1.nextInt(3);
                            waitTimer.start();


                            // Write your code here to invoke YES event

                            // Intent intent = new Intent(audio.this, tests.class);
                            //startActivity(intent);
                            // Toast.makeText(getApplicationContext(), "You clicked on YES", Toast.LENGTH_SHORT).show();
                        }
                    });

                    // Setting Negative "NO" Button
                    alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            // Write your code here to invoke NO event
                            // Toast.makeText(getApplicationContext(), "You clicked on NO", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(reactiontime.this, test3.class);
                            startActivity(intent);

                            //dialog.cancel();
                        }
                    });

                    // Showing Alert Message
                    alertDialog.show();


                }



                    //Random r1 = new Random();
               // n = r1.nextInt(3);

            if(flag==0) {


                waitTimer1 = new CountDownTimer(3000, 1000) {

                    public void onTick(long millisUntilFinished) {
                        long millis = millisUntilFinished;
                        hms = String.format("%02d",
                                TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
                        System.out.println(hms);
                        mImageView.setVisibility(View.VISIBLE);
                        rlayout.setEnabled(false);
                        mImageView.setImageResource(images[2]);


                    }

                    public void onFinish() {


                        waitTimer1 = new CountDownTimer(8000, 1000) {

                            public void onTick(long millisUntilFinished) {
                                long millis = millisUntilFinished;
                                hms = String.format("%02d",
                                        TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
                                System.out.println(hms);
                                mImageView.setVisibility(View.INVISIBLE);
                                rlayout.setEnabled(false);
                                //mImageView.setImageResource(images[2]);


                            }

                            public void onFinish() {

                                rlayout.setEnabled(true);
                                mImageView.setImageResource(images[0]);
                                mImageView.setVisibility(View.VISIBLE);
                                waitTimer.start();


                                //waitTimer.start();
                            }

                        }.start();


                        //rlayout.setEnabled(true);
                        //mImageView.setVisibility(View.VISIBLE);

                       // waitTimer.start();
                    }

                }.start();

            }

                else
            {
                rlayout.setEnabled(true);
                flag=0;
                mImageView.setVisibility(View.VISIBLE);
                waitTimer.start();
            }





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
        actionBar.setTitle("Reaction Time");
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

                // Showing Alert Message
                //alertDialog.show();
                // User chose the "Favorite" action, mark the current item
                // as a favorite...
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }


    }




        }


                // Toast.makeText(getApplicationContext(), "You clicked on NO", Toast.LENGTH_SHORT).show();
                // dialog.cancel();










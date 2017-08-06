package com.nslabs.ns;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by sandhyamurali on 27/03/16.
 */
public class cognitive extends AppCompatActivity {
    Toolbar toolbar;
    final String MYPREFScurrent ="mySharedPreferences";
    final String MYPREFSscore ="mySharedPreferences";
    String max1;
    //final String MYPREFS ="mySharedPreferences";

    SharedPreferences mySharedPreferences ;
    String[] question1=new String[]{"37-22","28x5"," 21x16","1x2","23","8","10-5","12"};
    String[] question2=new String[]{"18-15","26x30"," 18x10","2x3","33","7","7-4","13"};
    String[] answer=new String[]{"37-22","26x30","21x16","2x3","33","8","10-5","13"};
    int[] images = new int[]{ R.drawable.check1, R.drawable.wrong};
    CountDownTimer waitTimer;
    TextView time,score,q1,q2;
    ImageView imgview;
    String a,Total;
   int i=0;
    int count=0;
    int total2,total1,max;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.cognitive);

        toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mySharedPreferences= PreferenceManager.getDefaultSharedPreferences(this);
        Log.i("shared","shared pref value is " +mySharedPreferences);
        //shared=getSharedPreferences("MYPREFS ", Context.MODE_PRIVATE);
        //max1=mySharedPreferences.getString("scores", "0");
        Intent myIntent = getIntent();
        max1=myIntent.getStringExtra("HighScore1");

        Log.i("Display Scores", "The score is " + max1);
        max=Integer.parseInt(max1);



        android.support.v7.app.ActionBar ActionBar=getSupportActionBar();
        ActionBar.setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(R.drawable.close);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(cognitive.this);
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

                        Intent intent = new Intent(cognitive.this, test4.class);
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

        time=(TextView)findViewById(R.id.time);
        score=(TextView)findViewById(R.id.score);
        imgview=(ImageView)findViewById(R.id.imgview);
        q1=(TextView)findViewById(R.id.q1);
        q2=(TextView)findViewById(R.id.q2);




        waitTimer =new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {
                long millis = millisUntilFinished;
                String hms = String.format("%02d",
                        TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
                System.out.println(hms);
                time.setText(hms);
                q1.setText(question1[i]);
                q2.setText(question2[i]);
                a=answer[i];

                imgview.setVisibility(View.INVISIBLE);




                q1.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {

                        switch (v.getId()) {
                            case R.id.q1:

                                if(q1.getText().toString()==a)

                                {
                                    Log.i("if", " inside correct answer if");
                                    imgview.setVisibility(View.VISIBLE);

                                    imgview.setImageResource(images[0]);
                                    count++;
                                    i++;
                                    score.setText(Integer.toString(count));

                                    if ((i >= question1.length) && (i >= question2.length) && (i >= answer.length)) {
                                        i = 0;
                                        q1.setText(question1[i]);
                                        q2.setText(question2[i]);
                                        a = answer[i];


                                    } else {

                                        q1.setText(question1[i]);
                                        q2.setText(question2[i]);
                                        a = answer[i];


                                    }
                                }
                                    else

                                    {
                                        imgview.setVisibility(View.VISIBLE);

                                        imgview.setImageResource(images[1]);
                                        count++;
                                        i++;
                                        score.setText(Integer.toString(count));


                                        if ((i >= question1.length) && (i >= question2.length) && (i >= answer.length)) {
                                            i = 0;
                                            q1.setText(question1[i]);
                                            q2.setText(question2[i]);
                                            a = answer[i];


                                        } else {

                                            q1.setText(question1[i]);
                                            q2.setText(question2[i]);
                                            a = answer[i];


                                        }

                                    }







                                break;
                        }
                    }
                    // q1.setText(question1[i]);


                });

                q2.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {

                        switch (v.getId()) {

                            case R.id.q2:


                                if(q2.getText().toString()==a)

                                {
                                    Log.i("if", " inside correct answer if");
                                    imgview.setVisibility(View.VISIBLE);

                                    imgview.setImageResource(images[0]);
                                    count++;
                                    i++;
                                    score.setText(Integer.toString(count));

                                    if ((i >= question1.length) && (i >= question2.length) && (i >= answer.length)) {
                                        i = 0;
                                        q1.setText(question1[i]);
                                        q2.setText(question2[i]);
                                        a = answer[i];


                                    } else {

                                        q1.setText(question1[i]);
                                        q2.setText(question2[i]);
                                        a = answer[i];


                                    }
                                }
                                else

                                {
                                    imgview.setVisibility(View.VISIBLE);

                                    imgview.setImageResource(images[1]);
                                    count++;
                                    i++;
                                    score.setText(Integer.toString(count));


                                    if ((i >= question1.length) && (i >= question2.length) && (i >= answer.length)) {
                                        i = 0;
                                        q1.setText(question1[i]);
                                        q2.setText(question2[i]);
                                        a = answer[i];


                                    } else {

                                        q1.setText(question1[i]);
                                        q2.setText(question2[i]);
                                        a = answer[i];


                                    }

                                }







                                break;



                        }
                    }
                    // q1.setText(question1[i]);


                });

            }

            public void onFinish() {
                time.setText("done!");
                String total=score.getText().toString();
                Log.i("total"," count is " +total);
                total1=Integer.parseInt(total);
                 total2=total1*10;
                 Total=Integer.toString(total2);

                mySharedPreferences = getSharedPreferences(MYPREFScurrent, MODE_PRIVATE);
                SharedPreferences.Editor edit = mySharedPreferences.edit();
                // Commits the changes.
                edit.remove("current");
                edit.putString("current", Total);
                edit.commit();



                AlertDialog.Builder alertDialog = new AlertDialog.Builder(cognitive.this);
                alertDialog.setCancelable(false);

                // Setting Dialog Title
                alertDialog.setTitle("Confirm Delete...");

                // Setting Dialog Message
                alertDialog.setMessage("You have scored"+total2+ "points.Do you want to restart?");

                alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        // Write your code here to invoke YES event
                        dialog.cancel();
                        waitTimer.start();
                        count = 0;
                        score.setText(Integer.toString(count));

                        // Toast.makeText(getApplicationContext(), "You clicked on YES", Toast.LENGTH_SHORT).show();
                    }
                });

                alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {




                        //total=Integer.parseInt(score.getText().toString());
                //total1=total*10;



           if(total2>max)
               {
                  //int mode = cognitive.MODE_PRIVATE;
                 mySharedPreferences = getSharedPreferences(MYPREFSscore, MODE_PRIVATE);
                  SharedPreferences.Editor edit = mySharedPreferences.edit();
                    // Commits the changes.
                  edit.remove("total1");
                  edit.putString("total1", Total);
                edit.commit();

                   Intent intent = new Intent(cognitive.this,test4.class);

                    //intent.putExtra("taps", count);

                    startActivity(intent);


            }

                else
                {

                    Intent intent = new Intent(cognitive.this,test4.class);

                    //intent.putExtra("taps", count);

                    startActivity(intent);
                }
                    }
                });

                // Showing Alert Message
                alertDialog.show();



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
        actionBar.setTitle("      Cognitive Skills");
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








}

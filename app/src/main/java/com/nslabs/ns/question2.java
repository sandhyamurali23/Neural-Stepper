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
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by sandhyamurali on 22/03/16.
 */
public class question2 extends AppCompatActivity implements View.OnClickListener{

    Toolbar toolbar;
    TextView tvq1;
    // RadioButton r1,r2,r3,r4;
    String[] question = new String[]{"Identify the shadow of a hen", " Identify shadow of a bull", "Identify shadow of a cat", "Identify shadow of a squirrel", "Identify shadow of a dog"};
    int[] answer1 = new int[]{R.drawable.giraffe, R.drawable.cow, R.drawable.cat, R.drawable.hen,R.drawable.rat, R.drawable.dog, R.drawable.bull, R.drawable.cow,R.drawable.cat, R.drawable.dog, R.drawable.horse, R.drawable.cow,R.drawable.horse, R.drawable.cow, R.drawable.rabbit, R.drawable.squirrel,R.drawable.horse,R.drawable.cat,R.drawable.dog,R.drawable.hen};
    //int[] answer2 = new int[]{R.drawable.giraffe, R.drawable.pig, R.drawable.cat, R.drawable.hen};
    //int[] answer3 = new int[]{R.drawable.giraffe, R.drawable.pig, R.drawable.cat, R.drawable.hen};
    //int[] answer4 = new int[]{R.drawable.giraffe, R.drawable.pig, R.drawable.cat, R.drawable.hen};
    int i=0,j=0;
    ImageButton ib1,ib2,ib3,ib4;
    SharedPreferences mySharedPreferences ;
    final String MYPREFScount1 ="mySharedPreferences";
    final String MYPREFScount ="mySharedPreferences";

    int count1;
    float count,total;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question2);

        mySharedPreferences= PreferenceManager.getDefaultSharedPreferences(this);
        Log.i("shared", "shared pref value is " + mySharedPreferences);

        mySharedPreferences =getSharedPreferences(MYPREFScount1, MODE_PRIVATE);
        count = mySharedPreferences.getFloat("count", 0);
        //count1=Math.round(count);






        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tvq1=(TextView)findViewById(R.id.tvq1);
        ib1=(ImageButton)findViewById(R.id.ib1);
        ib2=(ImageButton)findViewById(R.id.ib2);
        ib3=(ImageButton)findViewById(R.id.ib3);
        ib4=(ImageButton)findViewById(R.id.ib4);


        tvq1.setText(question[i]);
        ib1.setImageResource(answer1[j]);
        j++;
        ib2.setImageResource(answer1[j]);
        j++;
        ib3.setImageResource(answer1[j]);
        j++;
        ib4.setImageResource(answer1[j]);



        android.support.v7.app.ActionBar ActionBar=getSupportActionBar();
        ActionBar.setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(question2.this);
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

                        total = (count / 10) * 100;
                        int mode = question1.MODE_PRIVATE;
                        mySharedPreferences = getSharedPreferences(MYPREFScount, mode);
                        SharedPreferences.Editor edit = mySharedPreferences.edit();
                        // Commits the changes.
                        edit.remove("total");
                        edit.putFloat("total", total);
                        edit.commit();

                        // mySharedPreferences = getSharedPreferences(MYPREFScount1, mode);
                        //SharedPreferences.Editor edit1 = mySharedPreferences.edit();
                        // Commits the changes.
                        //edit1.remove("count");
                        //edit.putFloat("count", count);
                        //edit.commit();


                        //Log.d("mtag","scores");


                        // Write your code here to invoke YES event

                        Intent intent = new Intent(question2.this, question.class);
                        startActivity(intent);




                    }


                });

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

        ib1.setOnClickListener(this);
        ib2.setOnClickListener(this);
        ib3.setOnClickListener(this);
        ib4.setOnClickListener(this);









    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.question, menu);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("      Question " + (i+1)+" Out of 5");

        //actionBar.show();


        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                // User chose the "Settings" item, show the app settings UI...
                return true;

            case R.id.action_favorite:
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
            case R.id.ib1:

                count++;
                i++;

                //j=0;
               // android.support.v7.app.ActionBar actionBar = getSupportActionBar();
               // actionBar.setTitle("      Question " +(i+1)+" out of 5");
                //actionBar.show();

                if (i >= question.length) {

                    //radioGroup.setEnabled(false);
                    android.support.v7.app.ActionBar actionBar1 = getSupportActionBar();
                    actionBar1.setTitle("      Question " + i + " out of 5");
                    actionBar1.show();
                    //Toast.makeText(question1.this, " Test Completed", Toast.LENGTH_SHORT).show();

                    //total=(count/5)*100;
                    int mode1 = question3.MODE_PRIVATE;
                    // mySharedPreferences = getSharedPreferences(MYPREFScount, mode1);
                    //SharedPreferences.Editor edit1 = mySharedPreferences.edit();
                    // Commits the changes.
                    //edit1.remove("total");
                    //edit1.putFloat("total", total);

                    mySharedPreferences = getSharedPreferences(MYPREFScount1, mode1);
                    SharedPreferences.Editor edit1 = mySharedPreferences.edit();
                    // Commits the changes.
                    edit1.remove("count");
                    edit1.putFloat("count", count);
                    edit1.commit();


                    edit1.commit();

                    Intent intent = new Intent(question2.this, question3.class);
                    startActivity(intent);


                }

                else {

                    android.support.v7.app.ActionBar actionBar = getSupportActionBar();
                    actionBar.setTitle("      Question " +(i+1)+" out of 5");
                    actionBar.show();


                    //Random r1 = new Random();
                    //n = r1.nextInt(3);
                    tvq1.setText(question[i]);
                    j++;
                    Log.i("j"," value of j is"+j);
                    ib1.setImageResource(answer1[j]);
                    j++;
                    ib2.setImageResource(answer1[j]);
                    j++;
                    ib3.setImageResource(answer1[j]);
                    j++;
                    ib4.setImageResource(answer1[j]);


                }


                    break;
            case R.id.ib2:
                count++;
                i++;
                //j=0;
               // android.support.v7.app.ActionBar actionBar = getSupportActionBar();
                //actionBar.setTitle("      Question " +(i+1)+" out of 5");
                //actionBar.show();

                if (i >= question.length) {

                    //radioGroup.setEnabled(false);
                    android.support.v7.app.ActionBar actionBar1 = getSupportActionBar();
                    actionBar1.setTitle("      Question " + i + " out of 5");
                    actionBar1.show();
                    //Toast.makeText(question1.this, " Test Completed", Toast.LENGTH_SHORT).show();

                    //total=(count/5)*100;
                    int mode1 = question3.MODE_PRIVATE;
                    // mySharedPreferences = getSharedPreferences(MYPREFScount, mode1);
                    //SharedPreferences.Editor edit1 = mySharedPreferences.edit();
                    // Commits the changes.
                    //edit1.remove("total");
                    //edit1.putFloat("total", total);

                    mySharedPreferences = getSharedPreferences(MYPREFScount1, mode1);
                    SharedPreferences.Editor edit1 = mySharedPreferences.edit();
                    // Commits the changes.
                    edit1.remove("count");
                    edit1.putFloat("count", count);
                    edit1.commit();


                    edit1.commit();

                    Intent intent = new Intent(question2.this, question3.class);
                    startActivity(intent);
                }

                else {

                    android.support.v7.app.ActionBar actionBar = getSupportActionBar();
                    actionBar.setTitle("      Question " +(i+1)+" out of 5");
                    actionBar.show();


                    //Random r1 = new Random();
                    //n = r1.nextInt(3);
                    tvq1.setText(question[i]);

                    j++;
                    Log.i("j", " value of j is" + j);
                    ib1.setImageResource(answer1[j]);
                    j++;
                    ib2.setImageResource(answer1[j]);
                    j++;
                    ib3.setImageResource(answer1[j]);
                    j++;
                    ib4.setImageResource(answer1[j]);


                }





                break;
            case R.id.ib3:
                count++;
                i++;
               // j=0;
                //android.support.v7.app.ActionBar actionBar1 = getSupportActionBar();
                //actionBar1.setTitle("      Question " +(i+1)+" out of 5");
                //actionBar1.show();

                if (i >= question.length) {

                    //radioGroup.setEnabled(false);
                    android.support.v7.app.ActionBar actionBar1 = getSupportActionBar();
                    actionBar1.setTitle("      Question " + i + " out of 5");
                    actionBar1.show();
                    //Toast.makeText(question1.this, " Test Completed", Toast.LENGTH_SHORT).show();

                    //total=(count/5)*100;
                    int mode1 = question3.MODE_PRIVATE;
                    // mySharedPreferences = getSharedPreferences(MYPREFScount, mode1);
                    //SharedPreferences.Editor edit1 = mySharedPreferences.edit();
                    // Commits the changes.
                    //edit1.remove("total");
                    //edit1.putFloat("total", total);

                    mySharedPreferences = getSharedPreferences(MYPREFScount1, mode1);
                    SharedPreferences.Editor edit1 = mySharedPreferences.edit();
                    // Commits the changes.
                    edit1.remove("count");
                    edit1.putFloat("count", count);
                    edit1.commit();


                    edit1.commit();

                    Intent intent = new Intent(question2.this, question3.class);
                    startActivity(intent);

                }

                else {

                    android.support.v7.app.ActionBar actionBar = getSupportActionBar();
                    actionBar.setTitle("      Question " +(i+1)+" out of 5");
                    actionBar.show();


                    //Random r1 = new Random();
                    //n = r1.nextInt(3);
                    tvq1.setText(question[i]);

                    j++;
                    Log.i("j", " value of j is" + j);
                    ib1.setImageResource(answer1[j]);
                    j++;
                    ib2.setImageResource(answer1[j]);
                    j++;
                    ib3.setImageResource(answer1[j]);
                    j++;
                    ib4.setImageResource(answer1[j]);


                }


                break;
            case R.id.ib4:
                count++;
                i++;
                //j=0;
                //android.support.v7.app.ActionBar actionBar = getSupportActionBar();
                //actionBar2.setTitle("      Question " +(i+1)+" out of 5");
                //actionBar2.show();

                if (i >= question.length) {

                    //radioGroup.setEnabled(false);
                    android.support.v7.app.ActionBar actionBar1 = getSupportActionBar();
                    actionBar1.setTitle("      Question " + i + " out of 5");
                    actionBar1.show();
                    //Toast.makeText(question1.this, " Test Completed", Toast.LENGTH_SHORT).show();

                    //total=(count/5)*100;
                    int mode1 = question3.MODE_PRIVATE;
                    // mySharedPreferences = getSharedPreferences(MYPREFScount, mode1);
                    //SharedPreferences.Editor edit1 = mySharedPreferences.edit();
                    // Commits the changes.
                    //edit1.remove("total");
                    //edit1.putFloat("total", total);

                    mySharedPreferences = getSharedPreferences(MYPREFScount1, mode1);
                    SharedPreferences.Editor edit1 = mySharedPreferences.edit();
                    // Commits the changes.
                    edit1.remove("count");
                    edit1.putFloat("count", count);
                    edit1.commit();


                    edit1.commit();

                    Intent intent = new Intent(question2.this, question3.class);
                    startActivity(intent);
                }

                else {
                    android.support.v7.app.ActionBar actionBar = getSupportActionBar();
                    actionBar.setTitle("      Question " +(i+1)+" out of 5");
                    actionBar.show();


                    //Random r1 = new Random();
                    //n = r1.nextInt(3);
                    tvq1.setText(question[i]);

                    j++;
                    Log.i("j", " value of j is" + j);
                    ib1.setImageResource(answer1[j]);
                    j++;
                    ib2.setImageResource(answer1[j]);
                    j++;
                    ib3.setImageResource(answer1[j]);
                    j++;
                    ib4.setImageResource(answer1[j]);


                }


        }

        }
    }
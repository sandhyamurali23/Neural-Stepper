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
 * Created by sandhyamurali on 23/03/16.
 */
public class question3 extends AppCompatActivity implements View.OnClickListener{

    Toolbar toolbar;
    // RadioButton r1,r2,r3,r4;
    String[] images = new String[]{"During the past 2 weeks,how difficult was getting out of bed"," During the past 2 weeks,how difficult was moving around at home","During the past 2 weeks,how difficult was moving about outdoors","During the past 2 weeks,how difficult was standing for exercise or any other activity", "During the past 2 weeks,how difficult was getting in and out of a motor vehicle"};
    int n,i=0,count2;
    float count=0,total,count1;
    TextView tvq1;
    final String MYPREFScount ="mySharedPreferences";
    final String MYPREFScount1 ="mySharedPreferences";
    SharedPreferences mySharedPreferences ;
    ImageButton ib1,ib2,ib3,ib4,ib5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question3);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mySharedPreferences =getSharedPreferences(MYPREFScount1, MODE_PRIVATE);
        count = mySharedPreferences.getFloat("count", 0);


        tvq1 = (TextView) findViewById(R.id.tvq1);
        ib1=(ImageButton)findViewById(R.id.ib1);
        ib2=(ImageButton)findViewById(R.id.ib2);
        ib3=(ImageButton)findViewById(R.id.ib3);
        ib4=(ImageButton)findViewById(R.id.ib4);
        ib5=(ImageButton)findViewById(R.id.ib5);



        mySharedPreferences= PreferenceManager.getDefaultSharedPreferences(this);
        Log.i("shared", "shared pref value is " + mySharedPreferences);

        android.support.v7.app.ActionBar ActionBar=getSupportActionBar();
        ActionBar.setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(question3.this);
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

                        total = (count / 15) * 100;
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

                        Intent intent = new Intent(question3.this, question.class);
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

        tvq1.setText(images[i]);
        ib1.setOnClickListener(this);
        ib2.setOnClickListener(this);
        ib3.setOnClickListener(this);
        ib4.setOnClickListener(this);
        ib5.setOnClickListener(this);




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

            case R.id.ib1:count++;
                i++;

                //j=0;
                // android.support.v7.app.ActionBar actionBar = getSupportActionBar();
                // actionBar.setTitle("      Question " +(i+1)+" out of 5");
                //actionBar.show();

                if (i >= images.length) {

                    //radioGroup.setEnabled(false);
                    ib1.setVisibility(View.GONE);
                    ib2.setVisibility(View.GONE);
                    ib3.setVisibility(View.GONE);
                    ib4.setVisibility(View.GONE);
                    ib5.setVisibility(View.GONE);
                    tvq1.setText("Test Completed");
                    android.support.v7.app.ActionBar actionBar = getSupportActionBar();
                    actionBar.setTitle("      Question " + i + " out of 5");
                    actionBar.show();
                    Toast.makeText(question3.this, " Test Completed", Toast.LENGTH_SHORT).show();

                    total = (count / 15) * 100;
                    int mode = question1.MODE_PRIVATE;
                    mySharedPreferences = getSharedPreferences(MYPREFScount, mode);
                    SharedPreferences.Editor edit = mySharedPreferences.edit();
                    // Commits the changes.
                    edit.remove("total");
                    edit.putFloat("total", total);
                    edit.commit();

                    Intent intent = new Intent(question3.this, question.class);
                    startActivity(intent);
                }

                else {

                    android.support.v7.app.ActionBar actionBar = getSupportActionBar();
                    actionBar.setTitle("      Question " +(i+1)+" out of 5");
                    actionBar.show();


                    //Random r1 = new Random();
                    //n = r1.nextInt(3);
                    tvq1.setText(images[i]);}
                break;
            case R.id.ib2:

                count++;
                i++;

                //j=0;
                // android.support.v7.app.ActionBar actionBar = getSupportActionBar();
                // actionBar.setTitle("      Question " +(i+1)+" out of 5");
                //actionBar.show();

                if (i >= images.length) {

                    //radioGroup.setEnabled(false);
                    ib1.setVisibility(View.GONE);
                    ib2.setVisibility(View.GONE);
                    ib3.setVisibility(View.GONE);
                    ib4.setVisibility(View.GONE);
                    ib5.setVisibility(View.GONE);
                    tvq1.setText("Test Completed");
                    android.support.v7.app.ActionBar actionBar = getSupportActionBar();
                    actionBar.setTitle("      Question " + i + " out of 5");
                    actionBar.show();
                    Toast.makeText(question3.this, " Test Completed", Toast.LENGTH_SHORT).show();

                    total = (count / 15) * 100;
                    int mode = question1.MODE_PRIVATE;
                    mySharedPreferences = getSharedPreferences(MYPREFScount, mode);
                    SharedPreferences.Editor edit = mySharedPreferences.edit();
                    // Commits the changes.
                    edit.remove("total");
                    edit.putFloat("total", total);
                    edit.commit();

                    Intent intent = new Intent(question3.this, question.class);
                    startActivity(intent);
                }

                else {

                    android.support.v7.app.ActionBar actionBar = getSupportActionBar();
                    actionBar.setTitle("      Question " +(i+1)+" out of 5");
                    actionBar.show();


                    //Random r1 = new Random();
                    //n = r1.nextInt(3);
                    tvq1.setText(images[i]);}




                break;
            case R.id.ib3:

                i++;
                count++;

                //j=0;
                // android.support.v7.app.ActionBar actionBar = getSupportActionBar();
                // actionBar.setTitle("      Question " +(i+1)+" out of 5");
                //actionBar.show();

                if (i >= images.length) {

                    //radioGroup.setEnabled(false);
                    ib1.setVisibility(View.GONE);
                    ib2.setVisibility(View.GONE);
                    ib3.setVisibility(View.GONE);
                    ib4.setVisibility(View.GONE);
                    ib5.setVisibility(View.GONE);
                    tvq1.setText("Test Completed");
                    android.support.v7.app.ActionBar actionBar = getSupportActionBar();
                    actionBar.setTitle("      Question " + i + " out of 5");
                    actionBar.show();
                    Toast.makeText(question3.this, " Test Completed", Toast.LENGTH_SHORT).show();

                    total = (count / 15) * 100;
                    int mode = question1.MODE_PRIVATE;
                    mySharedPreferences = getSharedPreferences(MYPREFScount, mode);
                    SharedPreferences.Editor edit = mySharedPreferences.edit();
                    // Commits the changes.
                    edit.remove("total");
                    edit.putFloat("total", total);
                    edit.commit();

                    Intent intent = new Intent(question3.this, question.class);
                    startActivity(intent);
                }

                else {

                    android.support.v7.app.ActionBar actionBar = getSupportActionBar();
                    actionBar.setTitle("      Question " +(i+1)+" out of 5");
                    actionBar.show();


                    //Random r1 = new Random();
                    //n = r1.nextInt(3);
                    tvq1.setText(images[i]);}

                break;
            case R.id.ib4:
                count++;

                i++;

                //j=0;
                // android.support.v7.app.ActionBar actionBar = getSupportActionBar();
                // actionBar.setTitle("      Question " +(i+1)+" out of 5");
                //actionBar.show();

                if (i >= images.length) {

                    //radioGroup.setEnabled(false);
                    ib1.setVisibility(View.GONE);
                    ib2.setVisibility(View.GONE);
                    ib3.setVisibility(View.GONE);
                    ib4.setVisibility(View.GONE);
                    ib5.setVisibility(View.GONE);
                    tvq1.setText("Test Completed");
                    android.support.v7.app.ActionBar actionBar = getSupportActionBar();
                    actionBar.setTitle("      Question " + i + " out of 5");
                    actionBar.show();
                    Toast.makeText(question3.this, " Test Completed", Toast.LENGTH_SHORT).show();

                    total = (count / 15) * 100;
                    int mode = question1.MODE_PRIVATE;
                    mySharedPreferences = getSharedPreferences(MYPREFScount, mode);
                    SharedPreferences.Editor edit = mySharedPreferences.edit();
                    // Commits the changes.
                    edit.remove("total");
                    edit.putFloat("total", total);
                    edit.commit();

                    Intent intent = new Intent(question3.this, question.class);
                    startActivity(intent);
                }

                else {

                    android.support.v7.app.ActionBar actionBar = getSupportActionBar();
                    actionBar.setTitle("      Question " +(i+1)+" out of 5");
                    actionBar.show();


                    //Random r1 = new Random();
                    //n = r1.nextInt(3);
                    tvq1.setText(images[i]);}
                break;
            case R.id.ib5:  i++;
                            count++;

                //j=0;
                // android.support.v7.app.ActionBar actionBar = getSupportActionBar();
                // actionBar.setTitle("      Question " +(i+1)+" out of 5");
                //actionBar.show();

                if (i >= images.length) {

                    //radioGroup.setEnabled(false);
                    ib1.setVisibility(View.GONE);
                    ib2.setVisibility(View.GONE);
                    ib3.setVisibility(View.GONE);
                    ib4.setVisibility(View.GONE);
                    ib5.setVisibility(View.GONE);
                    tvq1.setText("Test Completed");
                    android.support.v7.app.ActionBar actionBar = getSupportActionBar();
                    actionBar.setTitle("      Question " + i + " out of 5");
                    actionBar.show();
                    Toast.makeText(question3.this, " Test Completed", Toast.LENGTH_SHORT).show();

                    total = (count / 15) * 100;
                    int mode = question1.MODE_PRIVATE;
                    mySharedPreferences = getSharedPreferences(MYPREFScount, mode);
                    SharedPreferences.Editor edit = mySharedPreferences.edit();
                    // Commits the changes.
                    edit.remove("total");
                    edit.putFloat("total", total);
                    edit.commit();

                    Intent intent = new Intent(question3.this, question.class);
                    startActivity(intent);
                }

                else {

                    android.support.v7.app.ActionBar actionBar = getSupportActionBar();
                    actionBar.setTitle("      Question " +(i+1)+" out of 5");
                    actionBar.show();


                    //Random r1 = new Random();
                    //n = r1.nextInt(3);
                    tvq1.setText(images[i]);}





                i++;

                //j=0;
                // android.support.v7.app.ActionBar actionBar = getSupportActionBar();
                // actionBar.setTitle("      Question " +(i+1)+" out of 5");
                //actionBar.show();

                if (i >= images.length) {

                    //radioGroup.setEnabled(false);
                    ib1.setVisibility(View.GONE);
                    ib2.setVisibility(View.GONE);
                    ib3.setVisibility(View.GONE);
                    ib4.setVisibility(View.GONE);
                    ib5.setVisibility(View.GONE);
                    tvq1.setText("Test Completed");
                    android.support.v7.app.ActionBar actionBar = getSupportActionBar();
                    actionBar.setTitle("      Question " + i + " out of 5");
                    actionBar.show();
                    Toast.makeText(question3.this, " Test Completed", Toast.LENGTH_SHORT).show();

                    total = (count / 15) * 100;
                    int mode = question1.MODE_PRIVATE;
                    mySharedPreferences = getSharedPreferences(MYPREFScount, mode);
                    SharedPreferences.Editor edit = mySharedPreferences.edit();
                    // Commits the changes.
                    edit.remove("total");
                    edit.putFloat("total", total);
                    edit.commit();

                    Intent intent = new Intent(question3.this, question.class);
                    startActivity(intent);
                }

                else {

                    android.support.v7.app.ActionBar actionBar = getSupportActionBar();
                    actionBar.setTitle("      Question " +(i+1)+" out of 5");
                    actionBar.show();


                    //Random r1 = new Random();
                    //n = r1.nextInt(3);
                    tvq1.setText(images[i]);}
                break;














                }
    }
        }

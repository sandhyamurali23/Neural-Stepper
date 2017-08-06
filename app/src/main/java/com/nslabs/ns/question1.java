package com.nslabs.ns;

import android.app.AlertDialog;
import android.app.ProgressDialog;
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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseUser;

import java.util.Random;

/**
 * Created by sandhyamurali on 16/03/16.
 */
public class question1 extends AppCompatActivity {
    Toolbar toolbar;
   // RadioButton r1,r2,r3,r4;
    String[] images = new String[]{"During the past 2 weeks,how difficult was putting on/taking off upper body clothing"," During the past 2 weeks,how difficult was putting on/taking off lower body clothing","During the past 2 weeks,how difficult was putting on/wearing footwear","During the past 2 weeks,how difficult was eating/drinking or being fed", "During the past 2 weeks,how difficult was hair care"};
   // String[] options=new String[]{" Difficult"," Slightly Difficult","Easy","Very Easy"};
    int n,i=0,count2;
    float count=0,total,count1;
    TextView tvq1;
    RadioGroup radioGroup;
    RadioButton rb,r1,r2,r3,r4;
    final String MYPREFScount ="mySharedPreferences";
    final String MYPREFScount1 ="mySharedPreferences";
    //final String KEY_SAVED_RADIO_BUTTON_INDEX = "SAVED_RADIO_BUTTON_INDEX";

    //final String MYPREFSanswer ="mySharedPreferences";
    SharedPreferences mySharedPreferences ;
    int radiocount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question1);

        toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tvq1=(TextView)findViewById(R.id.tvq1);

        r1 = (RadioButton) findViewById(R.id.r1);
        r2 = (RadioButton) findViewById(R.id.r2);
        r3 = (RadioButton) findViewById(R.id.r3);
        r4 = (RadioButton) findViewById(R.id.r4);



        mySharedPreferences= PreferenceManager.getDefaultSharedPreferences(this);
        Log.i("shared", "shared pref value is " + mySharedPreferences);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);

        //SharedPreferences sharedPreferences = getSharedPreferences("MY_SHARED_PREF", MODE_PRIVATE);
        //int savedRadioIndex = sharedPreferences.getInt(KEY_SAVED_RADIO_BUTTON_INDEX, 0);
        //Log.i(" return"," index printed from get sp"+savedRadioIndex);
        //RadioButton savedCheckedRadioButton = (RadioButton)radioGroup.getChildAt(savedRadioIndex);
        //savedCheckedRadioButton.setChecked(true);

        //radioGroup.clearCheck();


        //for(int i=0;i<radioGroup.getChildCount();i++){
          //  Log.i(" if"," Inside if");
           // mySharedPreferences =getSharedPreferences(MYPREFSanswer, MODE_PRIVATE);
            //RadioButton rbtn=(RadioButton)radioGroup.getChildAt(i);
            //rbtn.setChecked(mySharedPreferences.getBoolean("answer"+rbtn.getId(), false));
        //}



        // mySharedPreferences =getSharedPreferences(MYPREFScount1, MODE_PRIVATE);
       // count1 = mySharedPreferences.getFloat("count", 0);
        //count2=Math.round(count1);
        //Log.i("count"," count is" +count2);




        android.support.v7.app.ActionBar ActionBar=getSupportActionBar();
        ActionBar.setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(question1.this);
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

                        Intent intent = new Intent(question1.this, question.class);
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


        Random r1 = new Random();
        n = r1.nextInt(3);
        tvq1.setText(images[i]);



        /* Attach CheckedChangeListener to radio group */
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rb = (RadioButton) group.findViewById(checkedId);
                if (null != rb && checkedId > -1) {

                    //if(count==0) {
                        //radiocount = radioGroup.indexOfChild(rb);
                        //Log.i("count", " radio index" + radiocount);
                        //SavePreferences0(KEY_SAVED_RADIO_BUTTON_INDEX, radiocount);
                   // }





                    //radiocount=radioGroup.getCheckedRadioButtonId();
                    //int mode = question1.MODE_PRIVATE;
                    //mySharedPreferences = getSharedPreferences(MYPREFSanswer, mode);
                    //SharedPreferences.Editor edit = mySharedPreferences.edit();
                    // Commits the changes.
                    //edit.remove("answer");
                    //edit.putInt("answer", radiocount);
                    //edit.commit();





                }
            }
        });








        //mImageView.setImageResource(images[n]);
        //mImageView.setImageResource(images[n]);

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
                if (radioGroup.getCheckedRadioButtonId() == -1)
                {
                    Toast.makeText(question1.this, " Select an option", Toast.LENGTH_SHORT).show();
                }

                    else {



                    count++;


                    i++;
                    android.support.v7.app.ActionBar actionBar = getSupportActionBar();
                    actionBar.setTitle("      Question " +(i+1)+" out of 5");
                    actionBar.show();

                    radioGroup.clearCheck();
                    if (i >= images.length) {

                        //count++;

                        //radioGroup.setEnabled(false);
                      //  r1.setVisibility(View.GONE);
                        //r2.setVisibility(View.GONE);
                        //r3.setVisibility(View.GONE);
                        //r4.setVisibility(View.GONE);
                       // tvq1.setText("Test Completed");
                        android.support.v7.app.ActionBar actionBar1 = getSupportActionBar();
                        actionBar1.setTitle("      Question " + i + " out of 5");
                        actionBar1.show();
                        //Toast.makeText(question1.this, " Test Completed", Toast.LENGTH_SHORT).show();

                        //total=(count/5)*100;
                        int mode1 = question1.MODE_PRIVATE;
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

                        Intent intent = new Intent(question1.this, question2.class);
                        startActivity(intent);




                        // Toast.makeText(question1.this, " Test Completed", Toast.LENGTH_SHORT).show();
                    } else {

                        //Random r1 = new Random();
                        //n = r1.nextInt(3);
                        tvq1.setText(images[i]);
                    }
                }


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

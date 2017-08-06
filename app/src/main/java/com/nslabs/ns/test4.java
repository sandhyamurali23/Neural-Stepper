package com.nslabs.ns;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by sandhyamurali on 27/03/16.
 */
public class test4 extends AppCompatActivity implements View.OnClickListener{

    Button bGetStarted;
    Toolbar toolbar;
    //TextView score;
    final String MYPREFSscore ="mySharedPreferences";
    //final String MYPREFS5="mysharedPreferences";
    SharedPreferences mySharedPreferences ;
int HighScores1;
    String Highscores;

    TextView tvScores,Name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.test4);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Tab 1"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab 2"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab 3"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        mySharedPreferences= PreferenceManager.getDefaultSharedPreferences(this);
        Log.i("shared", "shared pref value is " + mySharedPreferences);


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // putScores();
        //Log.i("Display Maximum Scores", "The maximum score from prev  is " + HighScores1);



        // putScores();
       // Log.i("Display Maximum Scores", "The maximum score from prev  is " + HighScores1);


        android.support.v7.app.ActionBar ActionBar=getSupportActionBar();
        ActionBar.setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(R.drawable.close);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(test4.this);
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

                        Intent intent = new Intent(test4.this, NavActivity.class);
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


        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final PagerAdapterCognitive adapter = new PagerAdapterCognitive
                (getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });



        // score=(TextView)findViewById(R.id.score);

        mySharedPreferences =getSharedPreferences(MYPREFSscore, MODE_PRIVATE);
        Highscores = mySharedPreferences.getString("total1", "0");

        tvScores=(TextView)findViewById(R.id.tvScores);
        tvScores.setText(Highscores);
        Name=(TextView)findViewById(R.id.Name);


        bGetStarted = (Button) findViewById(R.id.bGetStarted);
        bGetStarted.setOnClickListener(this);

       int  highscore=Integer.parseInt(Highscores);


        if(highscore<=29) {
            Name.setText("AMATEUR");
            //putScores();
        }

        else if(highscore>=30 && highscore<=39) {
            Name.setText("NOVICE");
            //putScores();
        }
        else if(highscore>=40 && highscore<=49) {
            Name.setText("GRADUATE");
            //putScores();
        }
        else if(highscore>=50 && highscore<=59) {
            Name.setText("EXPERT");
            //putScores();
        }
        else if(highscore>=60 && highscore<=69)
        {
            Name.setText("MASTER");
            // putScores();
        }
        else
        {
            Name.setText("LEGEND");
            // putScores();
        }






        //  ActionBar.setIcon(R.drawable.helpmenu);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_menu, menu);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("      Test");
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
                Intent myIntent = new Intent(test4.this, cognitive.class);
              myIntent.putExtra("HighScore1", tvScores.getText().toString());
                startActivity(myIntent);



                //startActivity(new Intent(this, TwoFinger.class));
                break;
        }

    }


}
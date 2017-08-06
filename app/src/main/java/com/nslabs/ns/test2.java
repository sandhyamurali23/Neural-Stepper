package com.nslabs.ns;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes;


/**
 * Created by chait on 28-01-2016.
 */


public class test2 extends AppCompatActivity implements View.OnClickListener {
    Button bGetStarted;
    TextView tvScores,Name;

Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.test2);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        android.support.v7.app.ActionBar ActionBar=getSupportActionBar();
        ActionBar.setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(R.drawable.close);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(test2.this);
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

                        Intent intent = new Intent(test2.this, NavActivity.class);
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



        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Benefits"));
        tabLayout.addTab(tabLayout.newTab().setText("Challenges"));
        tabLayout.addTab(tabLayout.newTab().setText("Scores"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final PageAdapterAudio adapter = new PageAdapterAudio
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



        //bBenefits = (Button) findViewById(R.id.bBenefits);
        //bChallenges = (Button) findViewById(R.id.bChallenges);
        //bScores = (Button) findViewById(R.id.bScores);
        bGetStarted = (Button) findViewById(R.id.bGetStarted);
       // tvScores = (TextView) findViewById(R.id.tvScores);
        Name=(TextView)findViewById(R.id.Name);
        //bBenefits.setOnClickListener(this);
        //bChallenges.setOnClickListener(this);
        //bScores.setOnClickListener(this);
        bGetStarted.setOnClickListener(this);

        //Intent intent = getIntent();
        // HighScores = intent.getStringExtra("score");
      //  tvScores.setText(HighScores);
        // putScores();
       // highscore=Integer.parseInt(HighScores);





    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.bGetStarted:
                Intent myIntent = new Intent(test2.this, audio.class);
               // myIntent.putExtra("HighScore", tvScores.getText().toString());
                startActivity(myIntent);



                //startActivity(new Intent(this, TwoFinger.class));
                break;
        }

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




    //protected  void putScores() {
    //  int mode = tests.MODE_PRIVATE;
    //mySharedPreferences = getSharedPreferences(MYPREFS5, mode);
    //SharedPreferences.Editor edit = mySharedPreferences.edit();
    // Commits the changes.
    //edit.remove("hscores");
    //edit.putString("hscores",HighScores);

    //edit.commit();
    //Log.d("mtag","scores");
    //}

}
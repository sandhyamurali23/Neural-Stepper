package com.nslabs.ns;

import android.app.Activity;
import android.app.Fragment;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class NavActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    NavigationView navigationView = null;
    Toolbar toolbar = null;
    TextView email,username;
    final String MYPREFSemail ="mySharedPreferences";
    final String MYPREFSfname ="mySharedPreferences";
    final String MYPREFSimage ="mySharedPreferences";

    SharedPreferences mySharedPreferences ;
    String Email,Fname,SelectedPath;
  // de.hdodenhof.circleimageview.CircleImageView profile_image;

    //String selectedImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav);

        //Set the fragment initially
        MainFragment fragment = new MainFragment();
        android.support.v4.app.FragmentTransaction fragmentTransaction =
                getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);

        //How to change elements in the header programatically
        View headerView = navigationView.getHeaderView(0);


        email = (TextView) headerView.findViewById(R.id.email);
        username = (TextView) headerView.findViewById(R.id.username);
        mySharedPreferences =getSharedPreferences(MYPREFSfname, MODE_PRIVATE);
        Fname = mySharedPreferences.getString("fname", "0");

        mySharedPreferences =getSharedPreferences(MYPREFSemail, MODE_PRIVATE);
        Email = mySharedPreferences.getString("email", "0");

        email.setText(Email);
        username.setText(Fname);

        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.nav, menu);
        android.support.v7.app.ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("DashBoard");
        actionBar.show();

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camara) {
            //Set the fragment initially
            MainFragment fragment = new MainFragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction =
                    getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, fragment);
            fragmentTransaction.commit();
            android.support.v7.app.ActionBar actionBar=getSupportActionBar();
            actionBar.setTitle("Dashboard");
            actionBar.show();

            // Handle the camera action
        } else if (id == R.id.nav_gallery) {
            //Set the fragment initially
            GalleryFragment fragment = new GalleryFragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction =
                    getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, fragment);
            fragmentTransaction.commit();

            android.support.v7.app.ActionBar actionBar=getSupportActionBar();
            actionBar.setTitle("Test");
            actionBar.show();


        } else if (id == R.id.nav_slideshow) {

            RewardsFragment fragment = new RewardsFragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction =
                    getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, fragment);
            fragmentTransaction.commit();

            android.support.v7.app.ActionBar actionBar=getSupportActionBar();
            actionBar.setTitle("Rewards");
            actionBar.show();

        } else if (id == R.id.nav_manage) {

            ActivityFragment fragment = new ActivityFragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction =
                    getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, fragment);
            fragmentTransaction.commit();
            android.support.v7.app.ActionBar actionBar=getSupportActionBar();
            actionBar.setTitle("Activity");
            actionBar.show();

        } else if (id == R.id.nav_share) {
            SettingsFragment fragment = new SettingsFragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction =
                    getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, fragment);
            fragmentTransaction.commit();

            android.support.v7.app.ActionBar actionBar=getSupportActionBar();
            actionBar.setTitle("Settings");
            actionBar.show();

        } else if (id == R.id.nav_send) {
            ProfileFragment fragment = new ProfileFragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction =
                    getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, fragment);
            fragmentTransaction.commit();

            mySharedPreferences =getSharedPreferences(MYPREFSimage, 0);
            SelectedPath = mySharedPreferences.getString("ImagePath", "");
           // Fragment fragment1 = new ImageFullScreen();
            Bundle bun = new Bundle();
            bun.putString("selected_image", SelectedPath);
            fragment.setArguments(bun);

            android.support.v7.app.ActionBar actionBar=getSupportActionBar();
            actionBar.setTitle("Profile");
            actionBar.show();
        }

        else if (id == R.id.nav_send1) {
            HelpFragment fragment = new HelpFragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction =
                    getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, fragment);
            fragmentTransaction.commit();

            android.support.v7.app.ActionBar actionBar=getSupportActionBar();
            actionBar.setTitle("Help and Feedback");
            actionBar.show();

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

package com.nslabs.ns;

import android.app.Activity;
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
import android.view.DragEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.DragShadowBuilder;
import android.view.View.OnDragListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class dragdrop1 extends AppCompatActivity implements OnTouchListener, OnDragListener{
        TextView tvscore,tvtime;
    CountDownTimer WaitTimer;
    int count=0,max,count1;
    String max1;
    Toolbar toolbar;
    final String MYPREFS1 ="mySharedPreferences";
    SharedPreferences mySharedPreferences ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dragdrop);


        mySharedPreferences= PreferenceManager.getDefaultSharedPreferences(this);
        Log.i("shared","shared pref value is " +mySharedPreferences);
        //shared=getSharedPreferences("MYPREFS ", Context.MODE_PRIVATE);
        //max1=mySharedPreferences.getString("scores", "0");
        Intent myIntent = getIntent();
        max1=myIntent.getStringExtra("HighScore");
        //Taps=(TextView)findViewById(R.id.Taps);
        Log.i("Display Scores", "The previous score is " + max1);

        //set ontouch listener for box views
        findViewById(R.id.box_view1).setOnTouchListener(this);

        //set ondrag listener for right and left parent views
        findViewById(R.id.left_view).setOnDragListener(this);
        findViewById(R.id.right_view).setOnDragListener(this);
        findViewById(R.id.top_view).setOnDragListener(this);
        tvscore=(TextView)findViewById(R.id.tvscore);
        tvtime=(TextView)findViewById(R.id.tvtime);
        toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        android.support.v7.app.ActionBar ActionBar=getSupportActionBar();
        ActionBar.setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(R.drawable.close);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(dragdrop1.this);
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

                        Intent intent = new Intent(dragdrop1.this, tests1.class);
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







        WaitTimer =new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {
                long millis = millisUntilFinished;
                String hms = String.format("%02d",
                        TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
                System.out.println(hms);
                tvtime.setText(hms);

            }

            public void onFinish() {
                tvtime.setText("done!");

                count1=Integer.parseInt(tvscore.getText().toString());
                putScores1();
                Log.i("Display Taps", "The count after commit is " + count1);
                Log.i("Display Taps", "The count is " + count1);
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(dragdrop1.this);
                alertDialog.setCancelable(false);
                alertDialog.setTitle("Confirm Delete...");

                // Setting Dialog Message
                alertDialog.setMessage("You have scored" + count1 + "points.Do you want to restart?");

                alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        // Write your code here to invoke YES event
                        dialog.cancel();
                        WaitTimer.start();
                        count = 0;
                        tvscore.setText(Integer.toString(count));

                        // Toast.makeText(getApplicationContext(), "You clicked on YES", Toast.LENGTH_SHORT).show();
                    }
                });

                alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        // Write your code here to invoke NO event
                        Log.i("Display Scores", "The prev score in String is " + max1);

                        max = Integer.parseInt(max1);
                        Log.i("Display Scores", "The prev score in Int is " + max);

                        if (count1 > max) {
                            max = count1;


                            //Score.setText(Integer.toString(max));
                            //OldScores=displayScores();
                            max1 = Integer.toString(max);
                            putScores();
                            // SharedPreferences.Editor edit = mySharedPreferences.edit();
                            // Commits the changes.
                            //edit.putString("scores",max1);

                            //edit.commit();

                            Log.i("Display Maximum Scores", "The maximum score is " + max1);

                            Intent intent = new Intent(dragdrop1.this, tests1.class);
                            //  intent.putExtra("score", max1);

                            startActivity(intent);
                        } else {
                            //Score.setText(Integer.toString(max));
                            //max1=displayScores();
                            // String max1=Integer.toString(OldScores);
                            //  max1=mySharedPreferences.getString("scores", "0");
                            Log.i("Display Maximum Scores", " Else The maximum score is " + max1);
                            Intent intent = new Intent(dragdrop1.this, tests1.class);
                            //intent.putExtra("score", max1);


                            startActivity(intent);
                        }


                    }


                });


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
    public boolean onDrag(View v, DragEvent event) {
        // TODO Auto-generated method stub
        if(event.getAction()==DragEvent.ACTION_DROP){
            //we want to make sure it is dropped only to left and right parent view
            View view = (View)event.getLocalState();

            if(v.getId() == R.id.left_view || v.getId() == R.id.right_view ){

                ViewGroup source = (ViewGroup) view.getParent();
                source.removeView(view);

                RelativeLayout target = (RelativeLayout) v;
                target.addView(view);
                count++;
                tvscore.setText(Integer.toString(count));
            }


            //make view visible as we set visibility to invisible while starting drag
            view.setVisibility(View.VISIBLE);
        }
        return true;
    }

    @Override
    public boolean onTouch(View view, MotionEvent event) {
        // TODO Auto-generated method stub
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
            view.startDrag(null, shadowBuilder, view, 0);
            view.setVisibility(View.INVISIBLE);
            return true;
        }
        return false;
    }



    protected String displayScores()
    {
        int mode = TwoFinger.MODE_PRIVATE;
        mySharedPreferences = getSharedPreferences("MYPREFS", mode);
        // To retrieve the saved values.
        String oldscores= mySharedPreferences.getString("scores1","0" );
        return  oldscores;

    }

    protected  void putScores() {
        int mode = TwoFinger.MODE_PRIVATE;
        mySharedPreferences = getSharedPreferences(MYPREFS1, mode);
        SharedPreferences.Editor edit = mySharedPreferences.edit();
        // Commits the changes.
        edit.remove("scores1");
        edit.putString("scores1",max1);

        edit.commit();
        //Log.d("mtag","scores");
    }


    protected  void putScores1() {
        int mode = TwoFinger.MODE_PRIVATE;
        mySharedPreferences = getSharedPreferences(MYPREFS1, mode);
        SharedPreferences.Editor edit = mySharedPreferences.edit();
        // Commits the changes.
        edit.remove("test1");
        edit.putString("test1", tvscore.getText().toString());

        edit.commit();
        //Log.d("mtag","scores");
    }


}
package com.nslabs.ns;

import java.io.IOException;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class audio extends AppCompatActivity {

    private MediaRecorder myRecorder;
    private MediaPlayer myPlayer;
    private String outputFile = null;
    private Button startBtn;
    private Button stopBtn;
    private Button playBtn;
    private Button stopPlayBtn;
    private TextView text;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.audio);

        text = (TextView) findViewById(R.id.text1);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        android.support.v7.app.ActionBar ActionBar=getSupportActionBar();
        ActionBar.setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(R.drawable.close);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(audio.this);
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

                        Intent intent = new Intent(audio.this, test2.class);
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
      //  ActionBar.setIcon(R.drawable.helpmenu);

        //amvmenu = (Toolbar) findViewById(R.id.amvmenu);
       //amvmenu.setTitle("Audio");
       // amvmenu.setNavigationIcon(R.drawable.helpmenu);
       // setSupportActionBar(amvmenu);



        // store it to sd card
        outputFile = Environment.getExternalStorageDirectory().
                getAbsolutePath() + "/javacodegeeksRecording.3gpp";

        myRecorder = new MediaRecorder();
        myRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        myRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        myRecorder.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);
        myRecorder.setOutputFile(outputFile);

        startBtn = (Button) findViewById(R.id.start);
        startBtn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                start(v);
            }
        });

        stopBtn = (Button) findViewById(R.id.stop);
        stopBtn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                stop(v);
            }
        });

        playBtn = (Button) findViewById(R.id.play);
        playBtn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                play(v);
            }
        });

        stopPlayBtn = (Button) findViewById(R.id.stopPlay);
        stopPlayBtn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                stopPlay(v);
            }
        });
    }

    public void start(View view) {
        try {
            myRecorder.prepare();
            myRecorder.start();
        } catch (IllegalStateException e) {
            // start:it is called before prepare()
            // prepare: it is called after start() or before setOutputFormat()
            e.printStackTrace();
        } catch (IOException e) {
            // prepare() fails
            e.printStackTrace();
        }

        text.setText("The five boxing wizards jump quickly");
        startBtn.setEnabled(false);
        stopBtn.setEnabled(true);

        Toast.makeText(getApplicationContext(), "Start recording...",
                Toast.LENGTH_SHORT).show();
    }

    public void stop(View view) {
        try {
            myRecorder.stop();
            myRecorder.release();
            myRecorder = null;

            stopBtn.setEnabled(false);
            playBtn.setEnabled(true);
            text.setText("The five boxing wizards jump quickly");

            Toast.makeText(getApplicationContext(), "Stop recording...",
                    Toast.LENGTH_SHORT).show();







} catch (IllegalStateException e) {
            //  it is called before start()
            e.printStackTrace();
        } catch (RuntimeException e) {
            // no valid audio/video data has been received
            e.printStackTrace();
        }

    }

    public void play(View view) {
        try {
            myPlayer = new MediaPlayer();
            myPlayer.setDataSource(outputFile);
            myPlayer.prepare();
            myPlayer.start();

            playBtn.setEnabled(false);
            stopPlayBtn.setEnabled(true);
            text.setText("The five boxing wizards jump quickly");

            Toast.makeText(getApplicationContext(), "Start play the recording...",
                    Toast.LENGTH_SHORT).show();




        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void stopPlay(View view) {
        try {
            if (myPlayer != null) {
                myPlayer.stop();
                myPlayer.release();
                myPlayer = null;
                playBtn.setEnabled(true);
                stopPlayBtn.setEnabled(false);
                text.setText("The five boxing wizards jump quickly");

                Toast.makeText(getApplicationContext(), "Stop playing the recording...",
                        Toast.LENGTH_SHORT).show();




                AlertDialog.Builder alertDialog = new AlertDialog.Builder(audio.this);
                alertDialog.setCancelable(false);

                // Setting Dialog Title
                alertDialog.setTitle("Confirm Delete...");

                // Setting Dialog Message
                alertDialog.setMessage("You have successfully recorded your audio.");

                // Setting Icon to Dialog
                //alertDialog.setIcon(R.drawable.delete);

                // Setting Positive "Yes" Button

                // Setting Negative "NO" Butt on
                alertDialog.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        // Write your code here to invoke NO event

                        Intent intent = new Intent(audio.this,test2.class);
                        //intent.putExtra("taps", count);

                        startActivity(intent);
                    }


                    //Score.setText(Integer.toString(max));
                    //max1=displayScores();
                    // String max1=Integer.toString(OldScores);
                    //  max1=mySharedPreferences.getString("scores", "0");
                    //Log.i("Display Maximum Scores"," Else The maximum score is " +max1);
                    // Intent intent = new Intent(audio.this,tests.class);
                    //intent.putExtra("score", max1);


                    // startActivity(intent);









                    // Toast.makeText(getApplicationContext(), "You clicked on NO", Toast.LENGTH_SHORT).show();
                    // dialog.cancel();

                });

                // Showing Alert Message
                alertDialog.show();
                // User chose the "Favorite" action, mark the current item
                // as a favorite...
                //bButton1.setEnabled(false);
                // bButton2.setEnabled(false);



                // max1=mySharedPreferences.getString("scores", "0");



            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void onBackPressed() {
        // do nothing.
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_menu, menu);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("      Audio");
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
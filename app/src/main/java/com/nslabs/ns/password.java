package com.nslabs.ns;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseUser;

/**
 * Created by sandhyamurali on 13/03/16.
 */
public class password extends AppCompatActivity{
    EditText etPassword,etPassword1;
   // Button bPassword;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.password);

        etPassword=(EditText) findViewById(R.id.etPassword);
        etPassword1=(EditText) findViewById(R.id.etPassword1);

       // bPassword = (Button) findViewById(R.id.bPassword);
        //bPassword.setOnClickListener(this);


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        android.support.v7.app.ActionBar ActionBar=getSupportActionBar();
        ActionBar.setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(R.drawable.close);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(password.this);
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
                        finish();

                        //  Intent intent = new Intent(child.this, getAct.class);
                        //startActivity(intent);
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


    }

    @Override
    public void onBackPressed() {
        // do nothing.
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menuchild, menu);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("      Update Password");
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


                if (isEmpty(etPassword)) {
                    Toast.makeText(password.this, "Password field cant be empty",
                            Toast.LENGTH_LONG).show();


                }

               else if (isEmpty(etPassword1)) {
                    Toast.makeText(password.this, " repeat password field cant be empty",
                            Toast.LENGTH_LONG).show();

                    // validationError = true;
                    //validationErrorMessage.append("Re-enter password field cannot be blank");
                }

                else if (!isMatching(etPassword, etPassword1)) {
                    Toast.makeText(password.this, "Passwords Dont Match",
                            Toast.LENGTH_LONG).show();
                    //validationError = true;
                    //validationErrorMessage.append("Passwords don't match");
                }

               else {
                    final ProgressDialog dlg = new ProgressDialog(password.this);
                    dlg.setTitle("Please wait.");
                    dlg.setMessage("Updating Password.  Please wait.");
                    dlg.show();

                    ParseUser user = ParseUser.getCurrentUser();
                    user.setPassword(etPassword.getText().toString());
                    user.saveInBackground();
                    Toast.makeText(password.this, "Password updated successfully",
                            Toast.LENGTH_LONG).show();

                    finish();
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



    private boolean isEmpty(EditText etText) {
        if (etText.getText().toString().trim().length() > 0) {
            return false;
        } else {
            return true;
        }
    }

    private boolean isMatching(EditText etText1, EditText etText2) {
        if (etText1.getText().toString().equals(etText2.getText().toString())) {
            return true;
        } else {
            return false;
        }

    }


    }

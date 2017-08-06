package com.nslabs.ns;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.app.ProgressDialog;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;



/**
 * Created by chait on 1/15/2016.
 */
public class register extends AppCompatActivity implements View.OnClickListener {
    Button bRegister;
    EditText etUsername,etPassword,etRPassword,etFirstName,etLastName;
    TextView tvSignIn;
    final String MYPREFSfname ="mySharedPreferences";
    SharedPreferences mySharedPreferences ;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        android.support.v7.app.ActionBar ActionBar=getSupportActionBar();
        ActionBar.setDisplayHomeAsUpEnabled(true);
        ActionBar.setTitle(null);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();


            }
        });




        etUsername=(EditText) findViewById(R.id.etUsername);
        etFirstName=(EditText) findViewById(R.id.etFirstName);
        etLastName=(EditText) findViewById(R.id.etLastName);
        etPassword=(EditText) findViewById(R.id.etPassword);
        etRPassword=(EditText) findViewById(R.id.etRPassword);
        tvSignIn=(TextView) findViewById(R.id.tvSignIn);

        bRegister = (Button) findViewById(R.id.bRegister);
        bRegister.setOnClickListener(this);
        tvSignIn.setOnClickListener(this);







    }
    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.bRegister:


                // Validate the sign up data
                boolean validationError = false;
                StringBuilder validationErrorMessage =
                        new StringBuilder("");
                if (isEmpty(etUsername)) {
                    validationError = true;
                    validationErrorMessage.append("Username field can't be left blank");
                }

                if (isEmpty(etFirstName)) {
                    validationError = true;
                    validationErrorMessage.append("First Name field can't be left blank");
                }

                if (isEmpty(etLastName)) {
                    validationError = true;
                    validationErrorMessage.append("Last Name field can't be left blank");
                }

                if (isEmpty(etPassword)) {
                    if (validationError) {
                        validationErrorMessage.append(", and");
                    }
                    validationError = true;
                    validationErrorMessage.append("Password field can't be left blank");
                }
                if (!isMatching(etPassword, etRPassword)) {
                    if (validationError) {
                        validationErrorMessage.append(", and");
                    }
                    validationError = true;
                    validationErrorMessage.append("Passwords don't match");
                }



                validationErrorMessage.append(".");

                // If there is a validation error, display the error
                if (validationError) {
                    Toast.makeText(register.this, validationErrorMessage.toString(), Toast.LENGTH_LONG)
                            .show();
                    return;
                }

                putfname();

                //Parse.initialize(this, "OGGJcPSGVQP7qKy5SWCy8sgOzxYTNF47vffbtkqq", "G8Q5TC4wCHIhQLhrr42cStco2kWOrql5nL0Tyhxu");

                // Set up a progress dialog
                final ProgressDialog dlg = new ProgressDialog(register.this);
                dlg.setTitle("Please wait.");
                dlg.setMessage("Signing up.  Please wait.");
                dlg.show();

                // Set up a new Parse user
                ParseUser user = new ParseUser();
                user.setUsername(etUsername.getText().toString());
                user.setPassword(etPassword.getText().toString());
                user.put("first_name", etFirstName.getText().toString());
                user.put("last_name", etLastName.getText().toString());

                // Call the Parse signup method
                user.signUpInBackground(new SignUpCallback() {

                    @Override
                    public void done(ParseException e) {
                        dlg.dismiss();
                        if (e != null) {
                            // Show the error message
                            Toast.makeText(register.this, e.getMessage(), Toast.LENGTH_LONG).show();
                        } else {
                            // Start an intent for the dispatch activity
                            Intent intent = new Intent(register.this, OnLoadActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                        }
                    }
                });



                break;

            case R.id.tvSignIn:
                Intent loginintent=new Intent(register.this,login.class);

                startActivity(loginintent);




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

    protected  void putfname() {
        int mode = TwoFinger.MODE_PRIVATE;
        mySharedPreferences = getSharedPreferences(MYPREFSfname, mode);
        SharedPreferences.Editor edit = mySharedPreferences.edit();
        // Commits the changes.
        edit.remove("fname");
        edit.putString("fname", etFirstName.getText().toString());

        edit.commit();
        //Log.d("mtag","scores");
    }


}



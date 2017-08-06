package com.nslabs.ns;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class login extends AppCompatActivity implements View.OnClickListener {
    Button bLogin;
    EditText etUsername;
    TextView tvMoreOptions;
    final String MYPREFSemail ="mySharedPreferences";
    SharedPreferences mySharedPreferences ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        mySharedPreferences= PreferenceManager.getDefaultSharedPreferences(this);
        Log.i("shared", "shared pref value is " + mySharedPreferences);
        etUsername=(EditText) findViewById(R.id.etUsername);
        tvMoreOptions=(TextView) findViewById(R.id.tvMoreOptions);
        bLogin = (Button) findViewById(R.id.bLogin);
        bLogin.setOnClickListener(this);
        tvMoreOptions.setOnClickListener(this);







    }
    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.bLogin:

                // Validate the sign up data
                boolean validationError = false;
                StringBuilder validationErrorMessage =
                        new StringBuilder("");
                if (isEmpty(etUsername)) {
                    validationError = true;
                    validationErrorMessage.append("Username field can't be left blank");
                }

                validationErrorMessage.append(".");

                // If there is a validation error, display the error
                if (validationError) {
                    Toast.makeText(login.this, validationErrorMessage.toString(), Toast.LENGTH_LONG)
                            .show();
                    return;
                }

                String Username = etUsername.getText().toString();
                putEmail();

                Intent intent=new Intent(login.this,forgot.class);
                intent.putExtra("Username", Username);
                startActivity(intent);
                //startActivity(new Intent(this, forgot.class));
                break;

            case R.id.tvMoreOptions:
                startActivity(new Intent(this, register.class)); //replace register to TwoFinger
        }


    }
    private boolean isEmpty(EditText etText) {
        if (etText.getText().toString().trim().length() > 0) {
            return false;
        } else {
            return true;
        }
    }

    protected  void putEmail() {
        int mode = TwoFinger.MODE_PRIVATE;
        mySharedPreferences = getSharedPreferences(MYPREFSemail, mode);
        SharedPreferences.Editor edit = mySharedPreferences.edit();
        // Commits the changes.
        edit.remove("email");
        edit.putString("email", etUsername.getText().toString());

        edit.commit();
        //Log.d("mtag","scores");
    }

}




package com.nslabs.ns;

        import android.content.Intent;
        import android.content.SharedPreferences;
        import android.os.Bundle;
        import android.support.design.widget.FloatingActionButton;
        import android.support.design.widget.Snackbar;
        import android.support.v7.app.AppCompatActivity;
        import android.support.v7.widget.Toolbar;
        import android.view.View;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;
        import android.widget.Toast;
        import android.preference.PreferenceManager;

        import android.app.ProgressDialog;

        import android.widget.Toast;

        import com.parse.LogInCallback;
        import com.parse.Parse;
        import com.parse.ParseException;
        import com.parse.ParseUser;


        import android.app.ProgressDialog;

        import com.parse.LogInCallback;
        import com.parse.Parse;
        import com.parse.ParseException;
        import com.parse.ParseUser;

public class forgot extends AppCompatActivity implements View.OnClickListener {
    Button bForgot;
    EditText etPassword;
    TextView tvUsername;
    final String MYPREFS ="mySharedPreferences";
    SharedPreferences mySharedPreferences ;
    String value;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgot);
        etPassword=(EditText) findViewById(R.id.etPassword);
       tvUsername=(TextView) findViewById(R.id.tvUsername);
        bForgot = (Button) findViewById(R.id.bForgot);
        bForgot.setOnClickListener(this);

        Bundle bundle=getIntent().getExtras();
         final String value = bundle.getString("Username");
        tvUsername.setText(value);


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

            }
    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.bForgot:

                Bundle bundle=getIntent().getExtras();
                 value = bundle.getString("Username");
                tvUsername.setText(value);
                boolean validationError = false;
                StringBuilder validationErrorMessage =
                        new StringBuilder("");
                if (isEmpty(etPassword)) {
                    validationError = true;
                    validationErrorMessage.append("Password field can't be left blank");
                }

                validationErrorMessage.append(".");

                // If there is a validation error, display the error
                if (validationError) {
                    Toast.makeText(forgot.this, validationErrorMessage.toString(), Toast.LENGTH_LONG)
                            .show();
                    return;
                }
                mySharedPreferences= PreferenceManager.getDefaultSharedPreferences(this);




                // Parse.initialize(this, "OGGJcPSGVQP7qKy5SWCy8sgOzxYTNF47vffbtkqq","G8Q5TC4wCHIhQLhrr42cStco2kWOrql5nL0Tyhxu");
                // Set up a progress dialog

                final ProgressDialog dlg = new ProgressDialog(forgot.this);
                dlg.setTitle("Please wait.");
                dlg.setMessage("Logging in.  Please wait.");
                dlg.show();
                // Call the Parse login method

                ParseUser.logInInBackground(value,etPassword.getText().toString(),new LogInCallback() {

                    @Override
                    public void done(ParseUser user, ParseException e) {
                        dlg.dismiss();
                        if (e != null) {
                            // Show the error message
                            Toast.makeText(forgot.this, e.getMessage(), Toast.LENGTH_LONG).show();
                        } else {
                            // Start an intent for the dispatch activity

                                putPassword();
                            putUsername();

                                //if(mSettings.contains(value)) {

                                    Intent intent = new Intent(forgot.this, Dispatch.class);
                                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                    startActivity(intent);
                                //}
                        }
                    }
                });


        }


    }
    private boolean isEmpty(EditText etText) {
        if (etText.getText().toString().trim().length() > 0) {
            return false;
        } else {
            return true;
        }
    }

    protected String displayPassword()
    {
        int mode = TwoFinger.MODE_PRIVATE;
        mySharedPreferences = getSharedPreferences("MYPREFS", mode);
        // To retrieve the saved values.
        String password= mySharedPreferences.getString("login","0" );

        return  password;

    }

    protected  void putPassword() {
        int mode = TwoFinger.MODE_PRIVATE;
        mySharedPreferences = getSharedPreferences(MYPREFS, mode);
        SharedPreferences.Editor edit = mySharedPreferences.edit();
        // Commits the changes.
        edit.remove("password");
        //edit.remove("login1");
        edit.putString("password",etPassword.getText().toString());
        //edit.putString("login1",value);


        edit.commit();
        //Log.d("mtag","scores");
    }

    protected String displayUsername()
    {
        int mode = TwoFinger.MODE_PRIVATE;
        mySharedPreferences = getSharedPreferences("MYPREFS", mode);
        // To retrieve the saved values.
        String username= mySharedPreferences.getString("username","0" );

        return  username;

    }

    protected  void putUsername() {
        int mode = TwoFinger.MODE_PRIVATE;
        mySharedPreferences = getSharedPreferences(MYPREFS, mode);
        SharedPreferences.Editor edit = mySharedPreferences.edit();
        // Commits the changes.
        edit.remove("username");
        //edit.remove("login1");
        edit.putString("username",value);
        //edit.putString("login1",value);


        edit.commit();
        //Log.d("mtag","scores");
    }
}


package com.nslabs.ns;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import java.io.File;

/**
 * Created by sandhyamurali on 13/03/16.
 */
public class child extends AppCompatActivity implements View.OnClickListener{

    Toolbar toolbar;
    EditText etFirstName,etLastName,etWeight,etBloodGroup,etSex,etUserName1,etAge,etHeight;
    Button profile;
    //private static int RESULT_LOAD_IMAGE = 1;
    SharedPreferences mySharedPreferences ;
    final String MYPREFSprofile ="mySharedPreferences";

    //String Image1;
    //private static Bitmap Image = null;
    //private static Bitmap rotateImage = null;
    ImageView imageView2;
    private static int RESULT_LOAD_IMAGE = 1;
    private String selectedImagePath,SelectedPath;
    Uri selectedImage;
    File imgFile;
    Bitmap myBitmap;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.child);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        android.support.v7.app.ActionBar ActionBar=getSupportActionBar();
        ActionBar.setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(R.drawable.close);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(child.this);
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


        mySharedPreferences= PreferenceManager.getDefaultSharedPreferences(this);

        imageView2=(ImageView)findViewById(R.id.imageView2);


        //onResume();
        mySharedPreferences = getSharedPreferences(MYPREFSprofile, 0);
        SelectedPath = mySharedPreferences.getString("ImagePath1", "");
        Log.i("path","Path is" +SelectedPath);
        imgFile = new File(SelectedPath);
        if(imgFile.exists()){

            myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
            Log.i("Inside","Inside if");
            //ImageView myImage = (ImageView) findViewById(R.id.imageviewTest);

            imageView2.setImageBitmap(myBitmap);

        }



        etFirstName=(EditText) findViewById(R.id.etFirstName);
        etLastName=(EditText) findViewById(R.id.etLastName);
        etAge=(EditText) findViewById(R.id.etAge);
        etSex=(EditText) findViewById(R.id.etSex);
        etBloodGroup=(EditText) findViewById(R.id.etBloodGroup);
        etWeight=(EditText) findViewById(R.id.etWeight);
        etHeight=(EditText) findViewById(R.id.etHeight);
        etUserName1=(EditText) findViewById(R.id.etUserName1);

        profile = (Button) findViewById(R.id.profile);
        profile.setOnClickListener(this);




    }





    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.profile:
                Intent i = new Intent(
                        Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                //onPause();
                startActivityForResult(i, RESULT_LOAD_IMAGE);

                break;
        }
    }



                @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menuchild, menu);
                    android.support.v7.app.ActionBar actionBar = getSupportActionBar();
                    actionBar.setTitle("      Child Profile");
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


                if (isEmpty(etFirstName)) {

                    Toast.makeText(child.this, "First Name cant be left blank)",
                            Toast.LENGTH_LONG).show();
                                    }

                else if (isEmpty(etLastName)) {
                    Toast.makeText(child.this, "Last Name cant be left blank)",
                            Toast.LENGTH_LONG).show();

                    //validationError = true;
                    //validationErrorMessage.append("Last Name field can't be left blank");
                }

               else if (isEmpty(etAge)) {
                   // validationError = true;
                   // validationErrorMessage.append("Age field can't be left blank");
                    Toast.makeText(child.this, "Age cant be left blank)",
                            Toast.LENGTH_LONG).show();

                }

              else  if (isEmpty(etSex)) {
                    Toast.makeText(child.this, "Gender cant be left blank)",
                            Toast.LENGTH_LONG).show();

                    // validationError = true;
                   // validationErrorMessage.append("Sex field can't be left blank");
                }

               else if (isEmpty(etBloodGroup)) {
                    Toast.makeText(child.this, "Bloodgroup cant be left blank)",
                            Toast.LENGTH_LONG).show();

                    //validationError = true;
                    //validationErrorMessage.append("Bloodgroup field can't be left blank");
                }

               else if (isEmpty(etHeight)) {
                    Toast.makeText(child.this, "Height cant be left blank)",
                            Toast.LENGTH_LONG).show();

                    // validationError = true;
                   // validationErrorMessage.append("Height field can't be left blank");
                }

              else  if (isEmpty(etWeight)) {
                    Toast.makeText(child.this, "Weight cant be left blank)",
                            Toast.LENGTH_LONG).show();

                    //  validationError = true;
                   // validationErrorMessage.append("Weight field can't be left blank");
                }

               else if (isEmpty(etUserName1)) {
                    Toast.makeText(child.this, "Username cant be left blank)",
                            Toast.LENGTH_LONG).show();

                    //validationError = true;
                   // validationErrorMessage.append("Username field can't be left blank");
                }


                //validationErrorMessage.append(".");
                else {
                    // If there is a validation error, display the error
                    final ProgressDialog dlg = new ProgressDialog(child.this);
                    dlg.setTitle("Please wait.");
                    dlg.setMessage("Updating Information.  Please wait.");
                    dlg.show();

                    // Set up a new Parse user
                    //ParseUser user = new ParseUser();
                    ParseUser user = ParseUser.getCurrentUser();
                    // user.increment("logins");

                    // user.put("child_sex", etSex.getText().toString());
                    user.put("child_gender", etSex.getText().toString());
                    user.put("child_height", etHeight.getText().toString());
                    user.put("child_fname", etFirstName.getText().toString());
                    user.put("child_lname", etLastName.getText().toString());
                    user.put("child_blood_group", etBloodGroup.getText().toString());
                    user.put("child_username", etUserName1.getText().toString());
                    user.put("child_weight", etWeight.getText().toString());
                    user.put("child_age", etAge.getText().toString());
                    user.saveInBackground();

                    user.saveInBackground(new SaveCallback() {
                        public void done(ParseException e) {
                            // dlg.dismiss();

                            if (e != null) {
                                Toast.makeText(child.this, e.getMessage(), Toast.LENGTH_LONG).show();

                                // Saved successfully
                            } else {
                                Toast.makeText(child.this, "Child details updated successfully",
                                        Toast.LENGTH_LONG).show();
                                finish();


                                // ParseException
                            }
                        }
                    });


                }










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

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            selectedImage = data.getData();
            selectedImagePath = getPath(selectedImage);
            mySharedPreferences = getSharedPreferences(MYPREFSprofile, 0); // Open SharedPreferences with name AppSharedPref
            SharedPreferences.Editor editor = mySharedPreferences.edit();
            editor.putString("ImagePath1", selectedImagePath); // Store selectedImagePath with key "ImagePath". This key will be then used to retrieve data.
            Log.i("Inside", "path is " + selectedImagePath);
            editor.commit();



            System.out.println("Image Path : " + selectedImagePath);
            imageView2.setImageURI(selectedImage);

        }
    }

    public String getPath(Uri uri){


        String[] projection = { MediaStore.Images.Media.DATA };
        Cursor cursor = getContentResolver().query(uri, projection, null, null, null);
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        return cursor.getString(column_index);

    }



}
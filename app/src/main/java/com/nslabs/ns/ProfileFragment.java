package com.nslabs.ns;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.parse.ParseUser;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {

EditText Edit,Edit1,Edit2,Edit4;
    SharedPreferences mySharedPreferences ;
    final String MYPREFSimage ="mySharedPreferences";

//String Image1;
    //private static Bitmap Image = null;
    //private static Bitmap rotateImage = null;
ImageView imageView2;
    private static int RESULT_LOAD_IMAGE = 1;
    private String selectedImagePath,SelectedPath;
    Uri selectedImage;
File imgFile;
    Bitmap myBitmap;
    //private static final int GALLERY = 1;
    //Bitmap imageb;
    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_profile, container, false);
        mySharedPreferences= PreferenceManager.getDefaultSharedPreferences(getActivity());

        imageView2=(ImageView)rootView.findViewById(R.id.imageView2);

        Bundle bundle = this.getArguments();
        String position = bundle.getString("selected_image");;

        //onResume();
        mySharedPreferences = this.getActivity().getSharedPreferences(MYPREFSimage, 0);
        //SelectedPath = mySharedPreferences.getString("ImagePath", "");
        Log.i("path","Path is" +position);
         imgFile = new File(position);
        if(imgFile.exists()){

            myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
        Log.i("Inside","Inside if");
            //ImageView myImage = (ImageView) findViewById(R.id.imageviewTest);

            imageView2.setImageBitmap(myBitmap);

        }



        //imageView2.setImageBitmap(BitmapFactory.decodeFile(SelectedPath));
        // mySharedPreferences =this.getActivity().getSharedPreferences(MYPREFSimage, Context.MODE_PRIVATE);

//        Image1 = mySharedPreferences.getString("imagePreferance", "0");
  //      imageb=decodeToBase64(Image1);
    //    imageView2.setImageBitmap(imageb);


        //imageView2.setImageBitmap(Image);
        Edit = (EditText) rootView.findViewById(R.id.Edit);
        imageView2=(ImageView) rootView.findViewById(R.id.imageView2);
        Edit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent i = new Intent(
                        Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                //onPause();
                startActivityForResult(i, RESULT_LOAD_IMAGE);
            }
        });

        Edit1 = (EditText) rootView.findViewById(R.id.Edit1);

        Edit1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(getActivity(), password.class);
                startActivity(intent);


            }
        });

        Edit2 = (EditText) rootView.findViewById(R.id.Edit2);

        Edit2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(getActivity(), child.class);
                startActivity(intent);



            }
        });



        Edit4 = (EditText) rootView.findViewById(R.id.Edit4);

        Edit4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                ParseUser.logOut();
                Intent intent = new Intent(getActivity(), OnLoadActivity.class);
                startActivity(intent);



            }
        });



        return rootView;

        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RESULT_LOAD_IMAGE && resultCode == Activity.RESULT_OK && null != data) {
            selectedImage = data.getData();
            selectedImagePath = getPath(selectedImage);
            mySharedPreferences = this.getActivity().getSharedPreferences(MYPREFSimage, 0); // Open SharedPreferences with name AppSharedPref
            SharedPreferences.Editor editor = mySharedPreferences.edit();
            editor.putString("ImagePath", selectedImagePath); // Store selectedImagePath with key "ImagePath". This key will be then used to retrieve data.
            Log.i("Inside", "path is " + selectedImagePath);
            editor.commit();



            System.out.println("Image Path : " + selectedImagePath);
            imageView2.setImageURI(selectedImage);

        }
    }

        public String getPath(Uri uri){


            String[] projection = { MediaStore.Images.Media.DATA };
            Cursor cursor = getActivity().getContentResolver().query(uri, projection, null, null, null);
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            cursor.moveToFirst();
            return cursor.getString(column_index);

        }




            //int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
           // String picturePath = cursor.getString(columnIndex);
            //cursor.close();

            //ImageView imageView = (ImageView) findViewById(R.id.imgView);
           // imageView2.setImageBitmap(BitmapFactory.decodeFile(picturePath));







    }

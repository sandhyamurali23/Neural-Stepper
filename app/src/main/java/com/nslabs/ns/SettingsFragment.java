package com.nslabs.ns;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.SwitchCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;


/**
 * A simple {@link Fragment} subclass.
 */
public class SettingsFragment extends Fragment {
SwitchCompat switch_compact,switch_compact1,switch_compact2,switch_compact3;
    //String HighScores1,HighScores2;
     String MYPREFS ="mySharedPreferences";
    String MYPREFS1="mysharedPreferences";
    SharedPreferences Preferences,Preferences1 ;

    public SettingsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_settings, container, false);
        Preferences =this.getActivity().getSharedPreferences(MYPREFS, Context.MODE_PRIVATE);
        Preferences1 =this.getActivity().getSharedPreferences(MYPREFS1, Context.MODE_PRIVATE);


        switch_compact = (SwitchCompat) rootView.findViewById(R.id.switch_compat);
        switch_compact.setChecked(false);

        switch_compact1 = (SwitchCompat) rootView.findViewById(R.id.switch_compat1);
        switch_compact1.setChecked(false);

        switch_compact2 = (SwitchCompat) rootView.findViewById(R.id.switch_compat2);
        switch_compact2.setChecked(false);

        switch_compact3 = (SwitchCompat) rootView.findViewById(R.id.switch_compat3);
        switch_compact3.setChecked(false);



        switch_compact.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {


            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {
                switch (buttonView.getId()) {
                    case R.id.switch_compat:
                        Log.i("switch_compat", isChecked + "");
                        break;

                }

            }
        });


        switch_compact1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {


            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {
                switch (buttonView.getId()) {
                    case R.id.switch_compat1:
                        Log.i("switch_compat", isChecked + "");
                        break;

                }

            }
        });


        switch_compact2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {


            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {
                switch (buttonView.getId()) {
                    case R.id.switch_compat2:
                        Log.i("switch_compat", isChecked + "");

                       // SharedPreferences preferences = getSharedPreferences("PREFERENCE", 0);
                        SharedPreferences.Editor editor = Preferences.edit();
                        editor.clear();
                        editor.commit();


                        SharedPreferences.Editor editor1 = Preferences1.edit();
                        editor1.clear();
                        editor1.commit();


                        //HighScores1.replace()


                        break;

                }

            }
        });


        switch_compact3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {


            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {
                switch (buttonView.getId()) {
                    case R.id.switch_compat3:
                        Log.i("switch_compat", isChecked + "");
                        break;

                }

            }
        });




        //check the current state before we display the screen


            return rootView;
        }

    }

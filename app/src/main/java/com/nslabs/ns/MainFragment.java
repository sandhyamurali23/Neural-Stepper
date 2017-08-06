package com.nslabs.ns;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {



    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

       // ((FragmentActivity) getActivity()).setTitle("NS");


        final Button main_button = (Button) rootView.findViewById(R.id.main_button);
        main_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.main_button:
                        Log.e("app", "onclick listener");
                        Intent intent = new Intent(getActivity(), tests.class);
                        startActivity(intent);

                        break;
                }

            }
        });

        final Button main_button1 = (Button) rootView.findViewById(R.id.main_button1);
        main_button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.main_button1:
                        Log.e("app", "onclick listener1");
                        Intent intent = new Intent(getActivity(), tests1.class);
                        startActivity(intent);

                        break;
                }

            }
        });


        final Button main_button2 = (Button) rootView.findViewById(R.id.main_button2);
        main_button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.main_button2:
                        Log.e("app", "onclick listener1");
                        Intent intent = new Intent(getActivity(), test2.class);
                        startActivity(intent);

                        break;
                }

            }
        });

        final Button main_button3 = (Button) rootView.findViewById(R.id.main_button3);
        main_button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.main_button3:
                        Log.e("app", "onclick listener1");
                        Intent intent = new Intent(getActivity(), test3.class);
                        startActivity(intent);

                        break;
                }

            }
        });

        final Button main_button4 = (Button) rootView.findViewById(R.id.main_button4);
        main_button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.main_button4:
                        Log.e("app", "onclick listener1");
                        Intent intent = new Intent(getActivity(), question.class);
                        startActivity(intent);

                        break;
                }

            }
        });



        final Button main_button5 = (Button) rootView.findViewById(R.id.main_button5);
        main_button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.main_button5:
                        Log.e("app", "onclick listener1");
                        Intent intent = new Intent(getActivity(), test4.class);
                        startActivity(intent);

                        break;
                }

            }
        });




        // Inflate the layout for this fragment
        return rootView;
    }





}

package com.nslabs.ns;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class TabFragment2 extends Fragment {
TextView textView;
    SharedPreferences mySharedPreferences ;
    final String MYPREFS ="mySharedPreferences";
    String HighScores;
            int HScores;


    public TabFragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_tab_fragment2, container, false);
        textView=(TextView)rootView.findViewById(R.id.textView);
        mySharedPreferences =this.getActivity().getSharedPreferences(MYPREFS, Context.MODE_PRIVATE);

        //mySharedPreferences =getSharedPreferences(MYPREFS, MODE_PRIVATE);
        HighScores = mySharedPreferences.getString("scores", "0");


        //HighScores = mySharedPreferences.getString("hscores", "0");
        HScores=Integer.parseInt(HighScores);
        Log.i("Display Maximum Scores", "The maximum score for printing  is " + HScores);

        if(HScores<=29)
            textView.setText("Score a 30 to rank upto Novice");

        else if(HScores>=30 && HScores<=39)
            textView.setText("Score a 40 to rank upto Graduate");
        else if(HScores>=40 && HScores<=49)
            textView.setText("Score a 50 to rank upto Expert");
        else if(HScores>=50 && HScores<=59)
            textView.setText("Score a 60 to rank upto a Master");
        else if(HScores>=60 && HScores<=69)
            textView.setText("Score a 70 to rank upto a Legend");
        else
            textView.setText("You are Awesome");



        return rootView;
    }

}

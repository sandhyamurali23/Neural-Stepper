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
public class TabFragment3 extends Fragment {
TextView textView3,textView1;
    final String MYPREFS ="mySharedPreferences";
    final  String MYPREFS1="mySharedPreferences";
    SharedPreferences mySharedPreferences ;
    String HighScores,Scores;
    //int HScores;


    public TabFragment3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_tab_fragment3, container, false);
        textView3=(TextView)rootView.findViewById(R.id.textView3);
        textView1=(TextView)rootView.findViewById(R.id.textView1);
        mySharedPreferences =this.getActivity().getSharedPreferences(MYPREFS, Context.MODE_PRIVATE);
        mySharedPreferences =this.getActivity().getSharedPreferences(MYPREFS1, Context.MODE_PRIVATE);

        //mySharedPreferences =getSharedPreferences(MYPREFS, MODE_PRIVATE);
        HighScores = mySharedPreferences.getString("scores", "0");
        Scores=mySharedPreferences.getString("test","0");
        Log.i("Taps is","Current Taps is" +Scores);


        //HighScores = mySharedPreferences.getString("hscores", "0");
       // HScores=Integer.parseInt(HighScores);
        Log.i("Display Maximum Scores", "The maximum score for printing  is " + HighScores);
        textView3.setText(HighScores);
        textView1.setText(Scores);
        return rootView;

    }

}

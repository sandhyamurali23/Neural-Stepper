package com.nslabs.ns;


import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarDataSet;
import com.github.mikephil.charting.interfaces.datasets.IRadarDataSet;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class GalleryFragment extends Fragment {

    SharedPreferences mySharedPreferences ;
    final String MYPREFS1 ="mySharedPreferences";
    final String MYPREFS2 ="mySharedPreferences";
    final String MYPREFS ="mySharedPreferences";
    String Results,Results1,HighScores;
    int Result,Result1,HighScore;

    public GalleryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_gallery, container, false);

        mySharedPreferences =this.getActivity().getSharedPreferences(MYPREFS1, Context.MODE_PRIVATE);
        mySharedPreferences =this.getActivity().getSharedPreferences(MYPREFS2, Context.MODE_PRIVATE);
        mySharedPreferences =this.getActivity().getSharedPreferences(MYPREFS, Context.MODE_PRIVATE);

        Results = mySharedPreferences.getString("test", "0");
        Results1 = mySharedPreferences.getString("test1", "0");
        HighScores = mySharedPreferences.getString("scores", "0");

        Result=Integer.parseInt(Results);
        Result1=Integer.parseInt(Results1);
        HighScore=Integer.parseInt(HighScores);

        Log.i("Display Maximum Scores", "The two finger tapping score from prev  is " + Results);

        RadarChart chart = (RadarChart) rootView.findViewById(R.id.chart);

        YAxis yAxis = chart.getYAxis();
        //yAxis.setTypeface(tf);
        yAxis.setLabelCount(5, false);
        yAxis.setTextSize(9f);
        yAxis.setAxisMinValue(0f);
        yAxis.setAxisMaxValue(100f);



        //RadarChart chart = new RadarChart(this);
        //setContentView(chart);

        ArrayList<Entry> entries = new ArrayList<>();
        entries.add(new Entry(Result, 0));
        entries.add(new Entry(Result1, 1));
        entries.add(new Entry(Result, 2));
        entries.add(new Entry(Result, 3));
        entries.add(new Entry(Result, 4));

        ArrayList<Entry> entries1 = new ArrayList<>();
        entries1.add(new Entry(HighScore, 0));
        entries1.add(new Entry(HighScore, 1));
        entries1.add(new Entry(HighScore, 2));
        entries1.add(new Entry(HighScore, 3));
        entries1.add(new Entry(20f, 4));
        entries1.add(new Entry(30f, 5));


        RadarDataSet dataset_comp1 = new RadarDataSet(entries, "Scores");
        RadarDataSet dataset_comp2 = new RadarDataSet(entries1, "HighScores");


        dataset_comp1.setColor(Color.CYAN);
        dataset_comp1.setDrawFilled(true);

        dataset_comp2.setColor(Color.RED);
        dataset_comp2.setDrawFilled(true);

       ArrayList<IRadarDataSet> dataSets = new ArrayList<IRadarDataSet>();
        dataSets.add(dataset_comp1);
        dataSets.add(dataset_comp2);


        ArrayList<String> labels = new ArrayList<String>();
        labels.add("Two Finger");
        labels.add("Hole Peg Test");
        labels.add("Short Walk");
        labels.add("Tone Audiomentry");
        labels.add("Reaction Time");
        labels.add("Spatial Span Memory");

        RadarData data = new RadarData(labels,dataSets);
        data.setDrawValues(true);


//        RadarData data1=new RadarData(labels,dataset_comp2);
        chart.setData(data);
  //      chart.setData(data1);

        chart.getYAxis().setDrawLabels(false);
        //chart.setDrawWeb(false);
        chart.getLegend().setEnabled(false);
          // Hide the legend


        //chart.saveToGallery("mychart.jpg", 85); // 85 is the quality of the image
        //chart.animate();

        //chart.saveToGallery("mychart.jpg", 85); // 85 is the quality of the image

        return rootView;
        //inflater.inflate(R.layout.fragment_gallery, container, false);
    }

}

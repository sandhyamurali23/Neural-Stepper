package com.nslabs.ns;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class PageFragment extends Fragment {
    ImageView imageview;
    TextView textview,detail;
    public static final int[] img = {R.drawable.a1,R.drawable.a2,R.drawable.a3,R.drawable.a4,R.drawable.a5,R.drawable.a6,R.drawable.a7,R.drawable.a8};
    public static final String[] title={"Gross Motor Skills"," Fine Motor Skills"," Audio Skills"," Cognitive Skills"," Emotional Quotient",
    " Mental Chronomentry"," Behavioural Insight"," Dietary Information"};
    public static final String[] details={" Gross Motor Skills are the Skills we use to move our arms,legs and torso in a functional manner",
    "It is the co-ordination of small muscle movements involving synchronization of hands and fingers with eyes",
    " Audio Skills check the users ability to speak and pronounce specific phenomes of the English Language",
    " Cognitive Skills are the core skills your brain uses to think,read,learn,remember,reason and pay attention",
    " Emotional Intelligence or Emotional Quotient is the capacity of the individuals to recognise their own and other people' emotions",
    " Mental Chronomentry or Reaction Time is the elapsed time between presentation of sensory stimulus and the behavioural",
    " Change in the routine may sometimes trigger a meltdown.This meltdown can be recorded for further reference",
    " Track your meals and dietary changes.Change in diet may trigger a burst of emotion,an upset stomach etc"};



    public PageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_page, container, false);
        imageview=(ImageView)rootView.findViewById(R.id.imageview);
        textview=(TextView)rootView.findViewById(R.id.textview);
        detail=(TextView)rootView.findViewById(R.id.details);
        //textview1=(TextView)rootView.findViewById(R.id.textview1);


        Bundle bundle=getArguments();
        int message=bundle.getInt("count");






        int position=img[message];
        String index=title[message];
        String index1=details[message];
        imageview.setImageResource(position);
        textview.setText(index);
        detail.setText(index1);

        //textView5.setText(" This is a "+message+ " Swipe View Page");
        //viewPager=(ViewPager)rootView.findViewById(R.id.viewPager);
        return rootView;
        // Inflate the layout for this fragment

    }

}

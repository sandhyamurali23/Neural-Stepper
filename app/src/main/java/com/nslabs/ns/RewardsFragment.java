package com.nslabs.ns;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class RewardsFragment extends Fragment {

    ViewPager viewPager;


    public RewardsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_rewards, container, false);
        viewPager=(ViewPager)rootView.findViewById(R.id.viewPager);
        SwipeAdapter swipeAdapter=new SwipeAdapter(getActivity().getSupportFragmentManager());
        viewPager.setAdapter(swipeAdapter);
        return rootView;

    }

}

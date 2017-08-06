package com.nslabs.ns;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PagerAdapterCognitive extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerAdapterCognitive(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                CognitiveTabFragment1 tab1 = new CognitiveTabFragment1();
                return tab1;
            case 1:
                CognitiveTabFragment2 tab2 = new CognitiveTabFragment2();
                return tab2;
            case 2:
                CognitiveTabFragment3 tab3 = new CognitiveTabFragment3();
                return tab3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}

/**
 * Created by sandhyamurali on 04/03/16.
 */

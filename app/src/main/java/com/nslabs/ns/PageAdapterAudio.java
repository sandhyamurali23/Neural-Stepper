package com.nslabs.ns;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PageAdapterAudio extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PageAdapterAudio(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                AudioTabFragment1 tab1 = new AudioTabFragment1();
                return tab1;
            case 1:
                AudioTabFragment2 tab2 = new AudioTabFragment2();
                return tab2;
            case 2:
                AudioTabFragment3 tab3 = new AudioTabFragment3();
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

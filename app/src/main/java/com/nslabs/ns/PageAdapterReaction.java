package com.nslabs.ns;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PageAdapterReaction extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PageAdapterReaction(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                ReactionTabFragment1 tab1 = new ReactionTabFragment1();
                return tab1;
            case 1:
                ReactionTabFragment2 tab2 = new ReactionTabFragment2();
                return tab2;
            case 2:
                ReactionTabFragment3 tab3 = new ReactionTabFragment3();
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

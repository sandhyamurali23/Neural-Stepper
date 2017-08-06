package com.nslabs.ns;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by sandhyamurali on 25/03/16.
 */
public class SwipeAdapter extends FragmentStatePagerAdapter {
    public SwipeAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        Fragment fragment=new PageFragment();
        Bundle bundle=new Bundle();
        bundle.putInt("count",position);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getCount() {
        return 8;
    }
}

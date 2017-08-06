package com.nslabs.ns;


        import android.support.v4.app.Fragment;
        import android.support.v4.app.FragmentManager;
        import android.support.v4.app.FragmentStatePagerAdapter;

public class PagerAdapterDrag extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerAdapterDrag(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                DragDropTabFragment1 tab1 = new DragDropTabFragment1();
                return tab1;
            case 1:
                DragDropTabFragment2 tab2 = new DragDropTabFragment2();
                return tab2;
            case 2:
                DragDropTabFragment3 tab3 = new DragDropTabFragment3();
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

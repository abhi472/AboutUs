package com.example.abhishek.aboutus;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by abhishek on 12/4/16.
 */
public class FragmentAdapter extends FragmentStatePagerAdapter {
    Fragment fragment = null;

    public FragmentAdapter(FragmentManager fm) {
        super(fm);

    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                fragment = new AnimFrag_1();


                break;
            case 1:
                fragment = new AnimFrag_2();
                break;
            case 2:
                fragment = new AnimFrag_3();
            default:
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }
    public Fragment getFrag()
    {
        return fragment;
    }
}

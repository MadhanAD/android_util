package com.codeconsole.androidutil;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.codeconsole.androidutil.fragment.PublicFragment;
import com.codeconsole.androidutil.fragment.SettingsFragment;

/**
 * Created by madhan on 11/7/17.
 */

public class TabAdapter extends FragmentStatePagerAdapter {


    public TabAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new SettingsFragment();
            case 1:
                return new PublicFragment();
            default:
                return null;
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {

        switch (position) {
            case 0:
                return "Settings";
            case 1:
                return "Public";
            default:
                return super.getPageTitle(position);
        }

    }

    @Override
    public int getCount() {
        return 2;
    }
}

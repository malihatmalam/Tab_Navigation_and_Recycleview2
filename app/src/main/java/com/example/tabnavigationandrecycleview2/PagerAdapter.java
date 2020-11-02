package com.example.tabnavigationandrecycleview2;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {

    int numOfTabs; // variable jumlah tab yang ada
    public PagerAdapter(FragmentManager fm, int numOfTabs) {
        super(fm);
        this.numOfTabs = numOfTabs;
    }

    @Override // mengambil posisi daru tab
    public Fragment getItem(int position) {
        switch (position){
            case 0: //posisi pertama
                return new FragmentFirst(); //mengarah ke fragment first java
            case 1: //posisi kedua
                return new FragmentSeccond(); //mengarah ke fragment seccond java
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}
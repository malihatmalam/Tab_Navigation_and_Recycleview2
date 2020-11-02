package com.example.tabnavigationandrecycleview2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        // Menambahkan jumlah tab
        // Tab 1
        tabLayout.addTab(tabLayout.newTab().setText("Tab ke 1"));
        // Tab 2
        tabLayout.addTab(tabLayout.newTab().setText("Tab ke 2"));
        // Isi dari Tab memenuhi wadah tab
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);


        final ViewPager viewPager = findViewById(R.id.pager);

        // Membuat adapter, dengan getTabCountnya sejumlah tabLayout
        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(),
                tabLayout.getTabCount());
        // memasukan adapter viewpager dengan variable adapter
        viewPager.setAdapter(adapter);
        //Mengubungkan tab dengan viewpager-nya, Bila tabnya berubah maka viewpagernya berubah
        viewPager.addOnPageChangeListener(new TabLayout
                .TabLayoutOnPageChangeListener(tabLayout));


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                // mengambil item dari yang diselect
                viewPager.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}

package com.codeconsole.androidutil.Activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.codeconsole.androidutil.R;
import com.codeconsole.androidutil.TabAdapter;

public class TabActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);


        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        viewPager = (ViewPager) findViewById(R.id.view_pager);


        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());

        TabAdapter adapter = new TabAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);


        TabLayout.Tab tab = tabLayout.getTabAt(0);
        if (tab != null) {
            tab.setIcon(R.drawable.ic_settings);
        }
        TabLayout.Tab tab1 = tabLayout.getTabAt(1);
        if (tab1 != null) {
            tab1.setIcon(R.drawable.ic_public);
        }

    }
}

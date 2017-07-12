package com.codeconsole.androidutil.Activity;

import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.codeconsole.androidutil.R;
import com.codeconsole.androidutil.TabAdapter;

public class TabActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    NestedScrollView nestedScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);


        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        nestedScrollView = (NestedScrollView) findViewById(R.id.nested_scroll_view);

        nestedScrollView.setFillViewport(true);


        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());

        TabAdapter adapter = new TabAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);


        TabLayout.Tab tab = tabLayout.getTabAt(0);
        if (tab != null) {
            View view1 = View.inflate(TabActivity.this,R.layout.custom_tab_layout,null);
            TextView textView1 = (TextView) view1.findViewById(R.id.tab_text);
            ImageView imageView1= (ImageView) view1.findViewById(R.id.tab_image);

            textView1.setText("Settings");
            imageView1.setImageResource(R.drawable.ic_settings);

            tab.setCustomView(view1);
//            tab.setIcon(R.drawable.ic_settings);
        }
        TabLayout.Tab tab1 = tabLayout.getTabAt(1);
        if (tab1 != null) {
            View view1 = View.inflate(TabActivity.this,R.layout.custom_tab_layout,null);
            TextView textView1 = (TextView) view1.findViewById(R.id.tab_text);
            ImageView imageView1= (ImageView) view1.findViewById(R.id.tab_image);

            textView1.setText("public");
            imageView1.setImageResource(R.drawable.ic_public);

            tab1.setCustomView(view1);
//            tab1.setIcon(R.drawable.ic_public);
        }

    }
}

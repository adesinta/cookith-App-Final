package com.ades.tes1;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;

public class Buburayam extends AppCompatActivity {

        private TabLayout tabLayout;
        private AppBarLayout appBarLayout;
        private ViewPager viewPager;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_buburayam);
            tabLayout = (TabLayout) findViewById(R.id.tablayout_id);
            appBarLayout = (AppBarLayout) findViewById(R.id.appBar_id);
            viewPager = (ViewPager) findViewById(R.id.viewpager_id);
            ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

            adapter.AddFragment(new Bahanbubur(),"Bahan");
            adapter.AddFragment(new buatbubur(),"Cara Buat");

            viewPager.setAdapter(adapter);
            tabLayout.setupWithViewPager(viewPager);
        }
}

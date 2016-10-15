package com.example.imef.myapplication.activity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.example.imef.myapplication.R;
import com.example.imef.myapplication.fragmet.MyHomeViewPagerFragment;

import java.util.List;

/**
 * Created by imef on 2016/8/13.
 */
public class MyHomeViewPagerActivity extends BasicActivity {

    private ViewPager mViewPager;
    private List<ResolveInfo> mData;
    private Fragment[] mFragments;
    private int length;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitiy_my_home_viewpager);

        fillApps();
        length = (int) Math.ceil(mData.size() / 16.0);
        mFragments = new Fragment[length];
        for (int i = 0; i < length; i++) {
            MyHomeViewPagerFragment fragment = new MyHomeViewPagerFragment();
            fragment.setArg(i , 20);
            fragment.setData(mData);
            mFragments[i] = fragment;
        }


        mViewPager = (ViewPager) findViewById(R.id.activity_my_home_viewpager);
        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mFragments[position];
            }

            @Override
            public int getCount() {
                return mFragments.length;
            }
        });
    }

    private void fillApps() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        mData = getPackageManager().queryIntentActivities(intent, PackageManager.MATCH_ALL);
    }
}

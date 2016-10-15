package com.example.imef.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.imef.myapplication.R;

/**
 * Created by imef on 2016/8/11.
 */
public class MyDemoActivity extends BasicActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_demos);
    }

    public void homeByGridview(View view) {
        Intent intent = new Intent(this , MyHomeGridviewActivity.class);
        startActivity(intent);
    }

    public void homeByViewPager(View view) {
        Intent intent = new Intent(this , MyHomeViewPagerActivity.class);
        startActivity(intent);
    }
}

package com.example.imef.myapplication.activity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.widget.GridView;

import com.example.imef.myapplication.R;
import com.example.imef.myapplication.adapter.MyHomeGridviewAdapter;

import java.util.List;

/**
 * Created by imef on 2016/8/11.
 */
public class MyHomeGridviewActivity extends BasicActivity implements MyHomeGridviewAdapter.EventListener {

    private GridView mAppGrid;
    private MyHomeGridviewAdapter mAdapter;
    private List<ResolveInfo> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_home_gridview);
        initView();

        fillApps();
        mAdapter = new MyHomeGridviewAdapter(this ,mData, this);
        mAppGrid.setAdapter(mAdapter);
    }

    private void fillApps() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        mData = getPackageManager().queryIntentActivities(intent , PackageManager.MATCH_ALL);
    }

    private void initView() {
        mAppGrid = (GridView) findViewById(R.id.activity_my_home_app_grid);
    }

    @Override
    public void onItemClick(ResolveInfo info) {
        Intent intent = new Intent();
        ComponentName name = new ComponentName(info.activityInfo.packageName , info.activityInfo.name);
        intent.setComponent(name);
        startActivity(intent);
    }
}

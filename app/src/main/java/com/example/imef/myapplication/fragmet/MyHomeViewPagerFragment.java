package com.example.imef.myapplication.fragmet;

import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.imef.myapplication.R;

import java.util.List;

/**
 * Created by imef on 2016/8/13.
 */
public class MyHomeViewPagerFragment extends BasicFragment {

    private int index;
    private int pageCount;
    private List<ResolveInfo> mData;

    public MyHomeViewPagerFragment(){}

    public void setArg(int index , int pageCount){
        this.index = index;
        this.pageCount = pageCount;
    }

    public void setData(List<ResolveInfo> data){
        this.mData = data;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_home_viewpager , container, false);
        GridLayout layout = (GridLayout) view.findViewById(R.id.fragment_my_home_viewpager_gridlayout);
        int start = pageCount * index;
        for (int i = start; i< mData.size() && i < start + 20; i++){
            View item = inflater.inflate(R.layout.item_viewpager_home, layout ,false);
            ViewHolder holder = new ViewHolder(item);
            ResolveInfo info = mData.get(i);
            holder.mIcon.setImageDrawable(info.loadIcon(getActivity().getPackageManager()));
            holder.mLabel.setText(info.loadLabel(getActivity().getPackageManager()));
            GridLayout.LayoutParams layoutParams = (GridLayout.LayoutParams) item.getLayoutParams();
            layoutParams.width = getActivity().getWindowManager().getDefaultDisplay().getWidth() / 4 ;
            layout.addView(item);
        }
        return view;
    }

    private class ViewHolder {

        public ImageView mIcon;
        public TextView mLabel;

        public ViewHolder(View view){
            mIcon = (ImageView) view.findViewById(R.id.item_grid_home_icon);
            mLabel = (TextView) view.findViewById(R.id.item_grid_home_name);

        }
    }
}

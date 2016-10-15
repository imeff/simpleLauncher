package com.example.imef.myapplication.adapter;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.imef.myapplication.R;

import java.util.List;

/**
 * Created by imef on 2016/8/12.
 */
public class MyHomeGridviewAdapter extends BaseAdapter {

    private Context mContext;
    private List<ResolveInfo> mData;
    private EventListener mListener;

    public MyHomeGridviewAdapter(Context context , List<ResolveInfo> mData, EventListener listener){
        mContext = context;
        this.mData = mData;
        mListener = listener;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int i) {
        return mData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null){
            view = LayoutInflater.from(mContext).inflate(R.layout.item_gridview_home , viewGroup , false);
        }
        ResolveInfo info = (ResolveInfo) getItem(i);
        ((ImageView)view.findViewById(R.id.item_grid_home_icon)).setImageDrawable(info.loadIcon(mContext.getPackageManager()));
        ((TextView)view.findViewById(R.id.item_grid_home_name)).setText(info.loadLabel(mContext.getPackageManager()));
        view.setTag(info);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener!=null){
                    mListener.onItemClick((ResolveInfo) v.getTag());
                }
            }
        });
        return view;
    }

    public interface EventListener {
        void onItemClick(ResolveInfo info);
    }
}

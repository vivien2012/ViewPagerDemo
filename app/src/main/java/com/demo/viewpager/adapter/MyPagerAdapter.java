package com.demo.viewpager.adapter;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * viewPager--适配器
 */
public class MyPagerAdapter extends PagerAdapter {

    private List<View> mViewList;

    public MyPagerAdapter(List<View> viewList) {
        mViewList = viewList;
    }

    public void updataViews(List<View> viewList){
        mViewList = viewList;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mViewList == null ? 0 : mViewList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }


    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView(mViewList.get(position));
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        container.addView(mViewList.get(position));
        return mViewList.get(position);
    }
}

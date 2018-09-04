package com.demo.viewpager.ui;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.demo.viewpager.R;
import com.demo.viewpager.adapter.MyPagerAdapter;
import com.demo.viewpager.view.AutoHeightViewPager;
import com.demo.viewpager.view.ItemCardView;
import com.demo.viewpager.view.MyPagerIndicatorView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private AutoHeightViewPager viewPager;
    private MyPagerIndicatorView indicatorView;
    private MyPagerAdapter mAdapter;

    private AutoHeightViewPager viewPager2;
    private MyPagerIndicatorView indicatorView2;
    private MyPagerAdapter mAdapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        viewPager = findViewById(R.id.viewPager);
        indicatorView = findViewById(R.id.indicatorView);
        mAdapter = new MyPagerAdapter(getViews(1));
        viewPager.setAdapter(mAdapter);
        updataIndicatorView(mAdapter.getCount(), indicatorView);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                indicatorView.setSelectedPosition(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

        viewPager2 = findViewById(R.id.viewPager2);
        indicatorView2 = findViewById(R.id.indicatorView2);
        mAdapter2 = new MyPagerAdapter(getViews(5));
        viewPager2.setAdapter(mAdapter2);
        updataIndicatorView(mAdapter2.getCount(), indicatorView2);
        viewPager2.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                indicatorView2.setSelectedPosition(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    private void updataIndicatorView(int size, MyPagerIndicatorView indicatorView) {
        if (size > 1) {
            indicatorView.setVisibility(View.VISIBLE);
            indicatorView.setData(size, 0);
        } else {
            indicatorView.setVisibility(View.GONE);
        }
    }

    private List<View> getViews(int size) {
        List<View> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            ItemCardView item = new ItemCardView(MainActivity.this);
            item.setPosition(i);
            result.add(item);
        }
        return result;
    }
}

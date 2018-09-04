package com.demo.viewpager.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.demo.viewpager.R;
import com.demo.viewpager.utils.ScreenUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * ViewPager圆点指示器
 */
public class MyPagerIndicatorView extends LinearLayout {

    private Context context;

    public MyPagerIndicatorView(Context context) {
        this(context, null);
    }

    public MyPagerIndicatorView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        setLayoutParams(params);
        setGravity(Gravity.CENTER);
        setOrientation(LinearLayout.HORIZONTAL);
        textViews = new ArrayList<>();
    }

    private List<TextView> textViews;

    /**
     * 设置数量
     *
     * @param nums
     */
    public void setData(int nums, int defaultIndex) {
        textViews.clear();
        removeAllViews();
        for (int i = 0; i < nums; i++) {
            addTextView(i, defaultIndex);
        }
    }


    public void setSelectedPosition(int position) {
        int size = textViews.size();
        if (position < size) {
            for (int i = 0; i < size; i++) {
                if (i == position) {
                    textViews.get(i).setEnabled(true);
                } else {
                    textViews.get(i).setEnabled(false);
                }
            }
        }
    }

    /**
     * @param position     位置
     * @param defaultIndex 默认选中的位置
     */
    private void addTextView(int position, int defaultIndex) {
        TextView textView = new TextView(context);
        LayoutParams params
                = new LayoutParams(ScreenUtils.dip2px(6f, context), ScreenUtils.dip2px(6f, context));
        params.setMargins(0, 0, ScreenUtils.dip2px(6f, context), 0);
        textView.setLayoutParams(params);
        textView.setBackgroundResource(R.drawable.bg_my_pager_indicator);
        if (position == defaultIndex) {
            textView.setEnabled(true);
        } else {
            textView.setEnabled(false);
        }
        addView(textView);
        textViews.add(textView);
    }

}

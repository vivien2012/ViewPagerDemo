package com.demo.viewpager.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.demo.viewpager.R;

public class ItemCardView extends LinearLayout {

    private TextView mTitle;
    private TextView mContent;
    private TextView mBtn;

    public ItemCardView(Context context) {
        this(context, null);
    }

    public ItemCardView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        View view = View.inflate(context, R.layout.item_card, this);
        mTitle = view.findViewById(R.id.item_title);
        mContent = view.findViewById(R.id.item_content);
        mBtn = view.findViewById(R.id.item_btn);
    }

    public void setPosition(int position) {
        mTitle.setText("CardTitle" + position);
        mContent.setText("CardContent" + position);
        mBtn.setText("CardBtn" + position);
    }
}

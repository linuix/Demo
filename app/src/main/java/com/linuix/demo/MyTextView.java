package com.linuix.demo;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

class MyTextView extends android.support.v7.widget.AppCompatTextView implements View.OnClickListener {
    private static final String TAG = "MyTextView";

    public MyTextView(Context context) {
        super(context);
        Log.d(TAG, "MyTextView: 1");
    }

    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Log.d(TAG, "MyTextView: 2");
        setOnClickListener(this);
    }


    public MyTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Log.d(TAG, "MyTextView: 3");
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d(TAG, "onTouchEvent: event = "+event.getAction());
        return super.onTouchEvent(event);

    }

    @Override
    public void onClick(View v) {
        Log.d(TAG, "onClick: ");
    }
}

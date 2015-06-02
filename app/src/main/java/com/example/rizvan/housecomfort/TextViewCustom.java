package com.example.rizvan.housecomfort;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Rizvan on 30.05.2015.
 */
public class TextViewCustom extends TextView{

    public TextViewCustom(Context context) {
        super(context);
        setTypeface(OpenSans.getInstance(context).getTypeFace());
    }

    public TextViewCustom(Context context, AttributeSet attrs) {
        super(context, attrs);
        setTypeface(OpenSans.getInstance(context).getTypeFace());
    }

    public TextViewCustom(Context context, AttributeSet attrs,
                                  int defStyle) {
        super(context, attrs, defStyle);
        setTypeface(OpenSans.getInstance(context).getTypeFace());
    }


}

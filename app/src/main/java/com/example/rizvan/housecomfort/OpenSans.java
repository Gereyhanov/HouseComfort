package com.example.rizvan.housecomfort;

import android.content.Context;
import android.graphics.Typeface;

/**
 * Created by Rizvan on 30.05.2015.
 */
public class OpenSans {

    private static OpenSans instance;
    private static Typeface typeface;

    public static OpenSans getInstance(Context context) {
        synchronized (OpenSans.class) {
            if (instance == null) {
                instance = new OpenSans();
                typeface = Typeface.createFromAsset(context.getResources().getAssets(), "fonts/BebasNeueBook.otf");
            }
            return instance;
        }
    }

    public Typeface getTypeFace() {
        return typeface;
    }
}

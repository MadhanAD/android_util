package com.codeconsole.androidutil.Util;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/**
 * Created by madhan on 9/4/17.
 */

public class ScreenSize {

    private ScreenSize() {
    }

    private static ScreenSize instance;
    private static DisplayMetrics metrics;
    private static float scale;

    public static ScreenSize getInstance(Context context) {
        WindowManager window = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        metrics = new DisplayMetrics();
        window.getDefaultDisplay().getMetrics(metrics);

        scale = context.getResources().getDisplayMetrics().density;

        if (instance == null) instance = new ScreenSize();
        return instance;
    }

    public int getWidth() {
        return metrics.widthPixels;
    }

    public int getHeight() {
        return metrics.heightPixels;
    }

    public int getWidth(int inPercentage) {
        float width = (float) ((inPercentage / 100.0) * getWidth());
        return Math.round(width);
    }

    public int getHeight(int inPercentage) {
        float height = (float) ((inPercentage / 100.0) * getHeight());
        return Math.round(height);
    }

    public int getPixelFromDips(float pixels) {
        // Convert the dps to pixels, based on density scale
        return (int) (pixels * scale + 0.5f);
    }

}

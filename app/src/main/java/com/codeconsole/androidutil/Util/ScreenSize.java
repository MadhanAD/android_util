package com.codeconsole.androidutil.Util;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;
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

    private static Context context;

    public static ScreenSize getInstance(Context context) {
        WindowManager window = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        metrics = new DisplayMetrics();
        window.getDefaultDisplay().getMetrics(metrics);
        ScreenSize.context = context;
        scale = context.getResources().getDisplayMetrics().density;

        if (instance == null) instance = new ScreenSize();
        return instance;
    }

    public static int getWidth() {
        return metrics.widthPixels;
    }

    public static int getHeight() {
        return metrics.heightPixels;
    }

    public static int getWidth(int inPercentage) {
        float width = (float) ((inPercentage / 100.0) * getWidth());
        return Math.round(width);
    }

    public static int getHeight(int inPercentage) {
        float height = (float) ((inPercentage / 100.0) * getHeight());
        return Math.round(height);
    }

    public static int getPixelFromDips(float pixels) {
        // Convert the dps to pixels, based on density scale
        return (int) (pixels * scale + 0.5f);
    }

    public static int getWidth(int inPercentage, int extrasInDp) {
        float width = (float) ((inPercentage / 100.0) * getWidth());
        int extraPixels = convertDpToPixels(extrasInDp);
        return Math.round(width - extraPixels);
    }

    public static int getHeight(int inPercentage, int extrasInDp) {
        float width = (float) ((inPercentage / 100.0) * getHeight());
        int extraPixels = convertDpToPixels(extrasInDp);
        return Math.round(width - extraPixels);
    }

    private static int convertDpToPixels(float dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
                context.getResources().getDisplayMetrics());
    }

}
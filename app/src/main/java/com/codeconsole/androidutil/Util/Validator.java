package com.codeconsole.androidutil.Util;

import android.text.TextUtils;
import android.util.Patterns;

import java.util.Random;

/**
 * Created by madhan on 9/4/17.
 */

public class Validator {
    private Validator() {
    }

    private static Validator instance = null;

    public static Validator getInstance() {
        if (instance == null) instance = new Validator();
        return instance;
    }

    //this checks the email value is valid email
    public static boolean isValidEmail(String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }


    public static int getRandomNumber(int max, int min) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

}

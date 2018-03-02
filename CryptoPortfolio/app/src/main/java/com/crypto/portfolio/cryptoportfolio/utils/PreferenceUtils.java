package com.crypto.portfolio.cryptoportfolio.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class PreferenceUtils {

    private static SharedPreferences sharedpreferences;

    public static Boolean getBoolean(String key, Context context) {
        sharedpreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedpreferences.getBoolean(key, false);
    }

    public static String getString(String key, Context context) {
        sharedpreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedpreferences.getString(key, null);
    }


}

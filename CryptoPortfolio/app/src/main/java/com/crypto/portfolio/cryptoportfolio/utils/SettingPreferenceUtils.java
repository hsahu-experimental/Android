package com.crypto.portfolio.cryptoportfolio.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SettingPreferenceUtils {

    public static String GENERAL_SETTING = "pref_general_storage_settings";

    private static SharedPreferences sharedpreferences;

    public static Boolean getBoolean(String key, Context context) {
        sharedpreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedpreferences.getBoolean(key, false);
    }
}

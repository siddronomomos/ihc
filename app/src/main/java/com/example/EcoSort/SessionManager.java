package com.example.EcoSort;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManager {
    private static final String PREF_NAME = "EcoSortPrefs";
    private static final String KEY_TOKEN = "token";
    private static final String KEY_USER_ID = "userId";

    private static final String KEY_USERNAME = "username";

    private static SharedPreferences getPreferences(Context context) {
        return context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public static void saveToken(Context context, String token) {
        SharedPreferences.Editor editor = getPreferences(context).edit();
        editor.putString(KEY_TOKEN, token);
        editor.apply();
    }

    public static void saveUsername(Context context, String username) {
        SharedPreferences.Editor editor = getPreferences(context).edit();
        editor.putString(KEY_USERNAME, username);
        editor.apply();
    }

    public static String getUsername(Context context) {
        return getPreferences(context).getString(KEY_USERNAME, null);
    }

    public static String getToken(Context context) {
        return getPreferences(context).getString(KEY_TOKEN, null);
    }

    public static void saveUserId(Context context, int userId) {
        SharedPreferences.Editor editor = getPreferences(context).edit();
        editor.putInt(KEY_USER_ID, userId);
        editor.apply();
    }

    public static int getUserId(Context context) {
        return getPreferences(context).getInt(KEY_USER_ID, -1);
    }

    public static void clearSession(Context context) {
        SharedPreferences.Editor editor = getPreferences(context).edit();
        editor.clear();
        editor.apply();
    }

    public static boolean isLoggedIn(Context context) {
        return getToken(context) != null;
    }
}
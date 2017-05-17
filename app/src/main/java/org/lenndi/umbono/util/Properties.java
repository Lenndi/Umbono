package org.lenndi.umbono.util;

import android.content.Context;
import android.content.SharedPreferences;

public class Properties {

    private static final String PREF_FILE = "preferences";
    private static final String APP_USERNAME = "admin";
    private static final String APP_PASSWORD = "admin";
    private static final String JWT_TOKEN_KEY = "jwt_token";
    private static final String API_URL_KEY = "api_url";
    private static final String API_URL = "http://10.3.8.145:8080";
    private static final String USER_UID_KEY = "user_uid";

    private SharedPreferences sharedPreferences;

    public Properties(Context context) {
        this.sharedPreferences = context.getSharedPreferences(PREF_FILE, Context.MODE_PRIVATE);
    }

    public String getToken() {
        return this.sharedPreferences.getString(JWT_TOKEN_KEY, null);
    }

    public void setToken(String token) {
        SharedPreferences.Editor editor = this.sharedPreferences.edit();
        editor.putString(JWT_TOKEN_KEY, token);
        editor.apply();
    }

    public String getAppUsername() {
        return APP_USERNAME;
    }

    public String getAppPassword() {
        return APP_PASSWORD;
    }

    public String getApiUrl() {
        return this.sharedPreferences.getString(API_URL_KEY, API_URL);
    }

    public void setApiUrl(String apiUrl) {
        SharedPreferences.Editor editor = this.sharedPreferences.edit();
        editor.putString(API_URL_KEY, apiUrl);
        editor.apply();
    }

    public String getUserUid() {
        return this.sharedPreferences.getString(USER_UID_KEY, null);
    }

    public void setUserUid(String userUid) {
        SharedPreferences.Editor editor = this.sharedPreferences.edit();
        editor.putString(USER_UID_KEY, userUid);
        editor.apply();
    }
}

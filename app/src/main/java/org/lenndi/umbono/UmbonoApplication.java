package org.lenndi.umbono;

import android.app.Application;
import android.content.Context;

import org.lenndi.umbono.util.JwtManager;

/**
 * Based application.
 */

public class UmbonoApplication extends Application {

    private Context context;

    public void onCreate() {
        super.onCreate();
        this.context = getApplicationContext();

        JwtManager jwtManager = new JwtManager(this);
        jwtManager.jwtRequest();
    }

    public Context getAppContext() {
        return this.context;
    }
}

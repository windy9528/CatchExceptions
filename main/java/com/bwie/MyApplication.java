package com.bwie;

import android.app.Application;

/**
 * Author: 杨高峰(windy)
 * Date: 2019/4/24 21:03
 * Description:
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Thread.setDefaultUncaughtExceptionHandler(new MainActivity());
    }
}

package com.wys.jmeet;

import android.app.Application;

import cn.jpush.im.android.api.JMessageClient;

public class JMeetApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        JMessageClient.init(this);
    }
}

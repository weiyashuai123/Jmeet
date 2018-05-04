package com.wys.jmeet.ui;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import com.wys.jmeet.BaseActivity;
import com.wys.jmeet.R;

import cn.jpush.im.android.api.JMessageClient;
import cn.jpush.im.api.BasicCallback;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        SharedPreferences sp = getSharedPreferences("user", MODE_PRIVATE);
        final String username = sp.getString("username", "");
        final String password = sp.getString("password", "");
        Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (username.isEmpty()) {
                    startActivity(LoginActivity.class);
                    finish();
                } else {
                    JMessageClient.login(username, password, new BasicCallback() {
                        @Override
                        public void gotResult(int code, String info) {
                            if (code == 0) {
                                startActivity(MainActivity.class);
                                finish();
                            } else {
                                startActivity(LoginActivity.class);
                                toast(info);
                                finish();
                            }
                        }
                    });

                }
            }
        }, 1000);
    }

}

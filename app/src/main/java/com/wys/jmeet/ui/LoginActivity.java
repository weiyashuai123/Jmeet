package com.wys.jmeet.ui;

import android.media.MediaRecorder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.wys.jmeet.BaseActivity;
import com.wys.jmeet.R;

import cn.jpush.im.android.api.JMessageClient;
import cn.jpush.im.api.BasicCallback;

public class LoginActivity extends BaseActivity {

    private EditText et_username,et_password;
    private TextView tv_to_register;
    private Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        bindView();
        initAction();
    }

    private void initAction() {
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
        tv_to_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(RegisterActivity.class);
            }
        });
    }

    private void login() {
        final String username = et_username.getText().toString();
        final String password = et_password.getText().toString();
        JMessageClient.login(username, password, new BasicCallback() {
            @Override
            public void gotResult(int code, String message) {
                if (code == 0){
                    startActivity(MainActivity.class);
                    finish();
                }else{
                    toast(message);
                }
            }
        });
    }

    private void bindView() {
        et_username = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);
        tv_to_register = findViewById(R.id.tv_toRegister);
        btn_login = findViewById(R.id.btn_login);
    }

}

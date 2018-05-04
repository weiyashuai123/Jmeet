package com.wys.jmeet.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.wys.jmeet.BaseActivity;
import com.wys.jmeet.R;

import cn.jpush.im.android.api.JMessageClient;
import cn.jpush.im.api.BasicCallback;

public class RegisterActivity extends BaseActivity {

    private EditText et_username, et_password, et_passagain;
    private Button btn_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        bindView();
        initAction();
    }

    private void initAction() {
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerUser();
            }
        });
    }

    protected void bindView() {
        btn_register = findViewById(R.id.btn_register);
        et_username = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);
        et_passagain = findViewById(R.id.et_passagain);
    }

    private void registerUser() {
        String username = et_username.getText().toString();
        String password = et_password.getText().toString();
        String passagain = et_passagain.getText().toString();
        if (passagain.equals(password)) {
            JMessageClient.register(username, password, new BasicCallback() {
                @Override
                public void gotResult(int code, String message) {
                    if (code == 0) {
                        toast("注册成功，请登录");
                        finish();
                    } else {
                        toast(message);
                    }
                }
            });
        } else {
            toast("两次输入的密码不一致，请重新输入");
            et_password.setText("");
            et_passagain.setText("");
            et_password.requestFocus();
        }
    }

}

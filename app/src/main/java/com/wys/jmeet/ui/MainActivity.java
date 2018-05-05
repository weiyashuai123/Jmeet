package com.wys.jmeet.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.wys.jmeet.BaseActivity;
import com.wys.jmeet.R;

import java.util.List;

import cn.jpush.im.android.api.JMessageClient;
import cn.jpush.im.android.api.content.TextContent;
import cn.jpush.im.android.api.event.MessageEvent;
import cn.jpush.im.android.api.event.NotificationClickEvent;
import cn.jpush.im.android.api.event.OfflineMessageEvent;
import cn.jpush.im.android.api.model.Conversation;
import cn.jpush.im.android.api.model.Message;
import cn.jpush.im.api.BasicCallback;

public class MainActivity extends BaseActivity {

    private EditText et_username_receive, et_message;
    private Button btn_send;
    private TextView tv_message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindView();
        initAction();
        JMessageClient.registerEventReceiver(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        JMessageClient.unRegisterEventReceiver(this);
    }

    protected void bindView() {
//        et_username_receive = findViewById(R.id.et_username_receive);
//        et_message = findViewById(R.id.et_message);
//        btn_send = findViewById(R.id.btn_send);
//        tv_message = findViewById(R.id.tv_message);
    }

    //收到离线消息
    public void onEvent(OfflineMessageEvent event) {
        List<Message> messages = event.getOfflineMessageList();
        for (Message msg : messages) {
            switch (msg.getContentType()) {
                case text:
                    TextContent textContent = (TextContent) msg.getContent();
                    tv_message.setText(msg.getFromUser().getUserName() + ":" + textContent.getText());
                    break;
                default:
                    break;
            }
        }

    }

    //通知栏点击事件
    public void onEvent(NotificationClickEvent event) {
        Message msg = event.getMessage();
        switch (msg.getContentType()) {
            case text:
                break;
            case eventNotification:
                break;
            default:
                break;
        }
    }

    protected void initAction() {
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = et_username_receive.getText().toString();
                String message = et_message.getText().toString();
                Conversation mConversation = Conversation.createSingleConversation(username, JMESSAGE_APP_KEY);
                Message msg = mConversation.createSendTextMessage(message);
                msg.setOnSendCompleteCallback(new BasicCallback() {
                    @Override
                    public void gotResult(int code, String s) {
                        if (code == 0) {
                            toast("发送成功");
                        } else {
                            toast(s);
                        }
                    }
                });
                JMessageClient.sendMessage(msg);
            }
        });
    }

}

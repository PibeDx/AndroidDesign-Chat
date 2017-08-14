package com.josecuentas.androiddesign_chat.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import com.josecuentas.androiddesign_chat.R;
import com.josecuentas.androiddesign_chat.model.RowChat;
import com.josecuentas.androiddesign_chat.ui.adapter.ChatAdapter;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rviChat;
    private EditText eteInput;
    private ChatAdapter chatAdapter;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rviChat = (RecyclerView) findViewById(R.id.rviChat);
        eteInput = (EditText) findViewById(R.id.eteInput);
        events();
        setup();
    }

    private void events() {
        eteInput.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int DRAWABLE_LEFT = 0;
                final int DRAWABLE_TOP = 1;
                final int DRAWABLE_RIGHT = 2;
                final int DRAWABLE_BOTTOM = 3;

                if(event.getAction() == MotionEvent.ACTION_UP) {
                    if(event.getRawX() >= (eteInput.getRight() - eteInput.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                        sendChat(eteInput);
                        return true;
                    }
                }
                return false;
            }
        });
        eteInput.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEND) {
                    sendChat(eteInput);
                    return true;
                }
                return false;
            }
        });
    }

    private void sendChat(TextView v) {
        String text = v.getText().toString();
        if (text.isEmpty()) return;
        chatAdapter.addRowChatList(new RowChat(v.getText().toString(), new Date()));
        v.setText("");
        rviChat.scrollToPosition(rviChat.getAdapter().getItemCount() - 1);
    }

    private void setup() {
        setupAdapter();
        setupRecycler();
    }

    private void setupAdapter() {
        chatAdapter = new ChatAdapter();
    }

    private void setupRecycler() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        //linearLayoutManager.setStackFromEnd(true);
        rviChat.setLayoutManager(linearLayoutManager);
        rviChat.setHasFixedSize(true);
        rviChat.setAdapter(chatAdapter);
    }
}

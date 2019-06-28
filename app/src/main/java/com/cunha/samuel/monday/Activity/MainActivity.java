package com.cunha.samuel.monday.Activity;

import android.content.Context;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.cunha.samuel.monday.Class.Message;
import com.cunha.samuel.monday.Functions.FunctionAPI;
import com.cunha.samuel.monday.Persistence.MessagePersist;
import com.cunha.samuel.monday.R;
import com.cunha.samuel.monday.RecyclerView.MessageListAdapter;

import java.util.LinkedList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @version 0.1
 * Created by Samuel Cunha on 15/12/17.
 */
public class MainActivity extends AppCompatActivity {

    @BindView(R.id.reyclerview_message_list)
    RecyclerView mMessageRecycler;

    @BindView(R.id.msg_send)
    EditText msgSend;

    private MessageListAdapter mMessageAdapter;
    private List<Message> messages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setIcon(R.drawable.monday_title);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        ButterKnife.bind(this);

        getMessagesDB();
        initChat();
    }

    private void initChat() {
        FunctionAPI.getInit(mMessageAdapter);
    }

    private void getMessagesDB(){
        messages = new LinkedList<>(MessagePersist.getAllMessages());
        _initRecyclerView();
    }

    private void _initRecyclerView(){
        mMessageAdapter = new MessageListAdapter(this, messages);

        //Remove os itens do Recycler, para add os novos valores.
        mMessageRecycler.removeAllViewsInLayout();

        LinearLayoutManager layout = new LinearLayoutManager(this);
        layout.setStackFromEnd(true);
        layout.setSmoothScrollbarEnabled(true);
        mMessageRecycler.setLayoutManager(layout);

        mMessageRecycler.setAdapter(mMessageAdapter);
        mMessageRecycler.scrollToPosition(mMessageAdapter.getItemCount()-1);
    }

    @OnClick(R.id.button_chatbox_send)
    public void send(View view){
        String msg = msgSend.getText().toString();
        if(msg != null && !msg.equals("")) FunctionAPI.send(mMessageRecycler,msg);
        msgSend.setText("");
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

}

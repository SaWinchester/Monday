package com.cunha.samuel.monday.RecyclerView;

import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.cunha.samuel.monday.Class.Message;
import com.cunha.samuel.monday.R;

/**
 * @version 0.1
 * Created by Samuel Cunha on 15/12/17.
 */
public class SentMessageHolder extends RecyclerView.ViewHolder {

    TextView messageText, timeText;

    SentMessageHolder(View itemView) {
        super(itemView);

        messageText = itemView.findViewById(R.id.text_message_body);
        timeText = itemView.findViewById(R.id.text_message_time);
    }

    void bind(Message message) {
        messageText.setText(message.getMessage());
        timeText.setText(message.getTime());
    }
}

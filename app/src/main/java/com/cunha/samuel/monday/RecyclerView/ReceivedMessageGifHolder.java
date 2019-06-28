package com.cunha.samuel.monday.RecyclerView;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.cunha.samuel.monday.Class.Message;
import com.cunha.samuel.monday.R;

/**
 * @version 0.1
 * Created by Samuel Cunha on 15/12/17.
 */
public class ReceivedMessageGifHolder extends RecyclerView.ViewHolder {

    TextView messageText, timeText;
    ImageView gif;

    ReceivedMessageGifHolder(View itemView) {
        super(itemView);

        messageText = itemView.findViewById(R.id.text_message_body);
        timeText = itemView.findViewById(R.id.text_message_time);
        gif = itemView.findViewById(R.id.gif);
    }

    void bind(Message message) {
        messageText.setText(message.getMessage());
        timeText.setText(message.getTime());
    }
}

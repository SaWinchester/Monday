package com.cunha.samuel.monday.RecyclerView;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.cunha.samuel.monday.Class.Message;
import com.cunha.samuel.monday.R;

import java.util.List;

/**
 * @version 0.1
 * Created by Samuel Cunha on 15/12/17.
 */
public class MessageListAdapter extends RecyclerView.Adapter {

    private static final int VIEW_TYPE_MESSAGE_SENT = 1;
    private static final int VIEW_TYPE_MESSAGE_RECEIVED = 2;
    private static final int VIEW_TYPE_MESSAGE_RECEIVED_GIF = 3;

    private Context mContext;
    private List<Message> mMessageList;

    public MessageListAdapter(Context context, List<Message> messageList) {
        this.mContext = context;
        this.mMessageList = messageList;
        Glide.init(mContext, new GlideBuilder());
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if (viewType == VIEW_TYPE_MESSAGE_SENT) {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_message_sent, parent, false);
            return new SentMessageHolder(view);
        } else if (viewType == VIEW_TYPE_MESSAGE_RECEIVED) {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_message_received, parent, false);
            return new ReceivedMessageHolder(view);
        }if (viewType == VIEW_TYPE_MESSAGE_RECEIVED_GIF) {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_message_received_gif, parent, false);
            return new ReceivedMessageGifHolder(view);
        }

        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        Message message = mMessageList.get(position);

        switch (holder.getItemViewType()) {
            case VIEW_TYPE_MESSAGE_SENT:
                ((SentMessageHolder) holder).bind(message);
                break;
            case VIEW_TYPE_MESSAGE_RECEIVED:
                ((ReceivedMessageHolder) holder).bind(message);
                break;
            case VIEW_TYPE_MESSAGE_RECEIVED_GIF:
                gifHolder(((ReceivedMessageGifHolder) holder),mMessageList.get(position));
                break;
        }
    }

    private void gifHolder(ReceivedMessageGifHolder receivedMessageGifHolder,Message message){
        receivedMessageGifHolder.bind(message);
        Glide.with(mContext)
                .load(message.getGif())
                .into(receivedMessageGifHolder.gif);
    }

    public void setMessege(Message messege){
        mMessageList.add(messege);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mMessageList.size();
    }

    @Override
    public int getItemViewType(int position) {

        if(mMessageList.get(position).isResponse())
            return mMessageList.get(position).isGif() ? VIEW_TYPE_MESSAGE_RECEIVED_GIF : VIEW_TYPE_MESSAGE_RECEIVED;

        return VIEW_TYPE_MESSAGE_SENT;
    }



}

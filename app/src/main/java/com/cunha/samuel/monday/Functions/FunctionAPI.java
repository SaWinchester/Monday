package com.cunha.samuel.monday.Functions;

import android.support.v7.widget.RecyclerView;

import com.cunha.samuel.monday.Class.Message;
import com.cunha.samuel.monday.Class.MessageSend;
import com.cunha.samuel.monday.RecyclerView.MessageListAdapter;
import com.cunha.samuel.monday.RequestApi.MondayAPI;
import com.cunha.samuel.monday.RequestApi.MondayApi;

import org.joda.time.DateTime;
import org.joda.time.JodaTimePermission;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Samuel Cunha on 16/12/17.
 */
public class FunctionAPI {


    public static void getInit(final MessageListAdapter mMessageAdapter) {

        Call<Message> messageCall = MondayApi.getInit();
        if(messageCall == null){
            Message message = new Message(0l,"Não estou Passando bem, não irei conversa hoje.",null,"",false,true,true);
            mMessageAdapter.setMessege(message);
        }else
            messageCall.enqueue(new Callback<Message>() {
                @Override
                public void onResponse(Call<Message> call, Response<Message> response) {
                    if (response.isSuccessful()) {
                        Message message = response.body();
                        mMessageAdapter.setMessege(message);
                    }
                }

                @Override
                public void onFailure(Call<Message> call, Throwable t) {
                    Message message = new Message(0l,"Não estou Passando bem, não irei conversa hoje.",null,"",false,true,true);
                    mMessageAdapter.setMessege(message);
                }
            });
    }

    public static void send(final RecyclerView mRecyclerView,String msg) {

        final MessageListAdapter mMessageAdapter = (MessageListAdapter) mRecyclerView.getAdapter();

        mMessageAdapter.setMessege(new Message(0l,msg,null,time(),false,false,false));
        mRecyclerView.scrollToPosition(mMessageAdapter.getItemCount()-1);

        Call<Message> messageCall = MondayApi.sendMessage(population(msg));
        if(messageCall == null){
            Message message = new Message(0l,"Não estou Passando bem, não irei conversa hoje.",null,"",false,true,true);
            mMessageAdapter.setMessege(message);
        }else
            messageCall.enqueue(new Callback<Message>() {
                @Override
                public void onResponse(Call<Message> call, Response<Message> response) {
                    if (response.isSuccessful()) {
                        Message message = response.body();
                        mMessageAdapter.setMessege(message);
                        mRecyclerView.scrollToPosition(mMessageAdapter.getItemCount()-1);
                    }
                }

                @Override
                public void onFailure(Call<Message> call, Throwable t) {
                    Message message = new Message(0l,"Não estou Passando bem, não irei conversa hoje.",null,"",false,true,true);
                    mMessageAdapter.setMessege(message);
                    mRecyclerView.scrollToPosition(mMessageAdapter.getItemCount()-1);
                }
            });
    }

    private static String time(){
        DateTime dateTime = new DateTime();
        return dateTime.toString("H:m:");
    }

    private static MessageSend population(String msg){
        int typeMessage = sorteia();
        if(typeMessage % 2 == 0) return new MessageSend(msg,null,false,false);
        if(isPrimo(typeMessage)) return new MessageSend(msg,null,false,true);
        return new MessageSend(msg,null,false,false);
    }

    private static boolean isPrimo(int num){
        boolean ehPrimo = true;
        for (int i = 2; i < 100; i++) {
            if (((i % num) == 0) && (num != i)) {
                ehPrimo = false;
                break;
            }
        }
        return ehPrimo;
    }

    private static int sorteia() {
        Set<Integer> sorteados = new TreeSet<Integer>() ;
        Random r = new Random();
        final int H = 100;
        final int L = 1;
        int result;
        do {
            result = r.nextInt(H + 1) + L;
        } while (!sorteados.add(Integer.valueOf(result)));
        return result;
    }
}

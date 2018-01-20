package com.cunha.samuel.monday.RequestApi;

import com.cunha.samuel.monday.Class.Message;
import com.cunha.samuel.monday.Class.MessageSend;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by Samuel Cunha on 16/12/17.
 */
public interface MondayAPI {

    @GET("/init")
    Call<Message> getInit();

    @Headers({"Content-Type: application/json", "Cache-Control: max-age=640000"})
    @POST("/mensagem")
    Call<Message> sendMessage(@Body MessageSend messageSend);
}

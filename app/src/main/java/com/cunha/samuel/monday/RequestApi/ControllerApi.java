package com.cunha.samuel.monday.RequestApi;

import com.cunha.samuel.monday.Class.Message;
import com.cunha.samuel.monday.Class.MessageSend;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ControllerApi {

    private final static String API_URL = "http://samuelcunha.pythonanywhere.com";

    public static Call<Message> getInit(){
        //Cria o Gson para fazer a conversao de Objeto em JSON e JSON em Objeto
        Gson gson = new GsonBuilder().setLenient().create();
        //Inicializa o objeto que irar tratar o sistema
        //de requisicao na API e conversão do Objeto.
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        //Inicializa a Interface com os metodos da API.
        MondayAPI mondayAPI = retrofit.create(MondayAPI.class);
        return mondayAPI.getInit();
    }

    public static Call<Message> sendMessage(MessageSend messageSend){
        //Cria o Gson para fazer a conversao de Objeto em JSON e JSON em Objeto
        Gson gson = new GsonBuilder().setLenient().create();
        //Inicializa o objeto que irar tratar o sistema
        //de requisicao na API e conversão do Objeto.
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        //Inicializa a Interface com os metodos da API.
        MondayAPI mondayAPI = retrofit.create(MondayAPI.class);
        return mondayAPI.sendMessage(messageSend);
    }
}

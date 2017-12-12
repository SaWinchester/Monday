package com.cunha.samuel.monday.Persistence;

import com.cunha.samuel.monday.App;
import com.cunha.samuel.monday.Class.Message;

import java.util.List;

import io.objectbox.Box;
import io.objectbox.BoxStore;

/**
 * Classe responsável por fazer o controle
 * da base de dados.
 * @version 0.1
 * Created by Samuel Cunha on 12/12/17.
 */
public class MessagePersist {

    private static Box<Message> messageBox;

    /**
     * Cria uma conexão unica com o Banco de Dados
     * @return a conexão unica do banco.
     */
    private static Box<Message> getUserBox() {
        if (messageBox == null) {
            BoxStore boxStore = App.getBoxStore();
            messageBox = boxStore.boxFor(Message.class);
        }
        return messageBox;
    }

    /**
     * Salva a mensagem no Banco.
     * @param message Mensagem a ser salva.
     */
    public static void saveMessage(Message message) {
        getUserBox().put(message);
    }

    /**
     * Retorna o número de Mensagem no banco de dado.
     * @return número de mensagens.
     */
    public static Integer getSize() {
        return getUserBox().getAll().size();
    }

    /**
     * Retorna todas as Mensagens do Banco de Dados.
     * @return Lista das mensagens.
     */
    public static List<Message> getAllMessages() {
        return getUserBox().getAll();
    }

    /**
     * Apaga uma mensagem específica do banco de dados.
     * @param message que será apaga.
     */
    public static void deleteMessage(Message message) {
        getUserBox().remove(message);
    }

    /**
     * Apaga todas as mensagens do banco de dados.
     */
    public static void deleleMessageAll() {
        getUserBox().removeAll();
    }

}

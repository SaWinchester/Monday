package com.cunha.samuel.monday.Class;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

/**
 * Classe que contém atributos relacionados as
 * Mensagens.
 * @version 0.1
 * Created by Samuel Cunha on 12/12/17.
 */
@Entity
public class Message {

    @Id(assignable = true)
    private Long cod_message;
    private String message;
    private String gif;
    private String time;
    private boolean isGif;
    private boolean isErro;
    private boolean isResponse;

    public Message() {}

    public Message(Long cod_message, String message, String gif, String time, boolean isGif, boolean isErro, boolean isResponse) {
        this.cod_message = cod_message;
        this.message = message;
        this.gif = gif;
        this.time = time;
        this.isGif = isGif;
        this.isErro = isErro;
        this.isResponse = isResponse;
    }

    public Long getCod_message() {
        return cod_message;
    }

    public void setCod_message(Long cod_message) {
        this.cod_message = cod_message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getGif() {
        return gif;
    }

    public void setGif(String gif) {
        this.gif = gif;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean isGif() {
        return isGif;
    }

    public void setGif(boolean gif) {
        isGif = gif;
    }

    public boolean isErro() {
        return isErro;
    }

    public void setErro(boolean erro) {
        isErro = erro;
    }

    public boolean isResponse() {
        return isResponse;
    }

    public void setResponse(boolean response) {
        isResponse = response;
    }
}

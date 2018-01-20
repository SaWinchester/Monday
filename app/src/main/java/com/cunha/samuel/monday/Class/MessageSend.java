package com.cunha.samuel.monday.Class;

/**
 * Created by Samuel Cunha on 16/12/17.
 */
public class MessageSend {

    private String message;
    private String cidade;
    private boolean isWeather;
    private boolean isGif;

    public MessageSend(){}

    public MessageSend(String message, String cidade, boolean isWeather, boolean isGif) {
        this.message = message;
        this.cidade = cidade;
        this.isWeather = isWeather;
        this.isGif = isGif;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public boolean isWeather() {
        return isWeather;
    }

    public void setWeather(boolean weather) {
        isWeather = weather;
    }

    public boolean isGif() {
        return isGif;
    }

    public void setGif(boolean gif) {
        isGif = gif;
    }
}

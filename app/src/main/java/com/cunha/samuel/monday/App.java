package com.cunha.samuel.monday;

import android.app.Application;
import android.util.Log;

import com.cunha.samuel.monday.Class.MyObjectBox;

import io.objectbox.BoxStore;
import io.objectbox.android.AndroidObjectBrowser;

/**
 * @version 0.1
 * Created by Samuel Cunha on 12/12/17.
 */
public class App extends Application {

    public static final String TAG = "ObjectBoxBase";
    public static final boolean EXTERNAL_DIR = false;

    private static BoxStore boxStore;

    public static BoxStore getBoxStore() {
        return boxStore;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        //Inicializa o Banco de Dados.
        boxStore = MyObjectBox.builder().androidContext(App.this).build();
        Log.d(TAG,"Init ObjectBox");
        if (BuildConfig.DEBUG) {
            new AndroidObjectBrowser(boxStore).start(this);
        }
    }

}

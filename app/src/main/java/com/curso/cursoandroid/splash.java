package com.curso.cursoandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by soporte.cta on 18/02/2017.
 * un splah es una clase que sirve para realizar una pantalla de inicio
 */

public class splash extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread thread = new Thread(){
            @Override
            public void run(){
                try {
                    sleep(3500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    Intent intent = new Intent(splash.this,MainActivity.class);//el Intent sirve para pasar informacion entre activitys
                            startActivity(intent);
                    finish();// sirve para terminar el splash y no volver averlo al terminar la app
                }
            }
        };
          thread.start();
    }
}


package com.example.konstantin.sliderenlarge;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.stfalcon.frescoimageviewer.ImageViewer;

public class MainActivity extends AppCompatActivity {
    private String[] list;
    private static final String POSTERS_PATH = "https://raw.githubusercontent.com/stfalcon-studio/FrescoImageViewer/v.0.5.0/images/posters";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fresco.initialize(this);
        list=getPosters();

        new ImageViewer.Builder(this, list)
                .setStartPosition(1)
                .show();
    }

    public static String[] getPosters() {
        return new String[]{
                POSTERS_PATH + "/Vincent.jpg",
                POSTERS_PATH + "/Jules.jpg",
                POSTERS_PATH + "/Korben.jpg",
                POSTERS_PATH + "/Toretto.jpg",
                POSTERS_PATH + "/Marty.jpg",
                POSTERS_PATH + "/Driver.jpg",
                POSTERS_PATH + "/Frank.jpg",
                POSTERS_PATH + "/Max.jpg",
                POSTERS_PATH + "/Daniel.jpg"
        };
    }
}

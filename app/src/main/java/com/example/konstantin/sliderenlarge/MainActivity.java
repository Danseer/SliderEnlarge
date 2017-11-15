package com.example.konstantin.sliderenlarge;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.stfalcon.frescoimageviewer.ImageViewer;


public class MainActivity extends AppCompatActivity {
    private String[] list;
    private static final String POSTERS_PATH = "https://raw.githubusercontent.com/stfalcon-studio/FrescoImageViewer/v.0.5.0/images/posters";
    private ImageOverlayView overlayView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Fresco.initialize(this);
        list = getPosters();

        showPict();



    }


private void showPict (){
    overlayView = new ImageOverlayView(this);
    new ImageViewer.Builder(this, list)
            .setStartPosition(1)
            .setOverlayView(overlayView)
            .setImageChangeListener(getImageChangeListener())

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

    private ImageViewer.OnImageChangeListener getImageChangeListener() {
        return new ImageViewer.OnImageChangeListener() {
            @Override
            public void onImageChange(int position) {
               // CustomImage image = images.get(position);
               overlayView.setShareText("text share "+list[position]);
               overlayView.setDescription("text description "+ position);
            }
        };
    }
}

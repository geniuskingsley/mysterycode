package com.example.simplemusicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    /**
     *
     */
    Button startsong;
    Button stopsong;
    Button pause;

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startsong = findViewById(R.id.startsong);
        stopsong = findViewById(R.id.stopsong);
        pause = findViewById(R.id.palse);

        /**
         * Starting service..
         */
        Intent start_service_intent = new Intent(MainActivity.this, ServiceClass.class);

        startsong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(start_service_intent);
            }
        });

//        stopsong.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ServiceClass serviceClass = new ServiceClass();
//                serviceClass.pause_music();
//            }
//        });

    }
}
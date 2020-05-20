package com.example.denemex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void next3Activity(View view){
        Intent intent = new Intent(this, seviye3katman.class);

        startActivity(intent);
    }


    public void next2Activity(View view){
        Intent intent = new Intent(this, seviye2katman.class);

        startActivity(intent);
    }

    public void nextActivity(View view){
        Intent intent = new Intent(this, seviye1katman.class);

        startActivity(intent);
    }

    public void puanActivity(View view){
        Intent intent = new Intent(this, puanlar.class);

        startActivity(intent);
    }
}



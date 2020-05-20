package com.example.denemex;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class puanlar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puanlar);

        getPuanlar();
    }

    public void getPuanlar(){
        FileInputStream fis = null;

        try {
            fis = openFileInput("maksPuan.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            //StringBuilder sb = new StringBuilder();
            String text;

            LinearLayout myLinearLayout = findViewById(R.id.myLinearLayout);


            while((text = br.readLine())!= null){

                TextView rowTextView = new TextView(this);
                rowTextView.setText(text);
                rowTextView.setTextColor(Color.parseColor("#FF5722"));
                rowTextView.setTextSize(20);

                myLinearLayout.addView(rowTextView);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

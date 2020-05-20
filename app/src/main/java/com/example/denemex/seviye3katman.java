package com.example.denemex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class seviye3katman extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seviye3katman);


        Button seviye1 = (Button) findViewById(R.id.seviye11);
        Button seviye2 = (Button) findViewById(R.id.seviye12);
        Button seviye3 = (Button) findViewById(R.id.seviye13);
        Button seviye4 = (Button) findViewById(R.id.seviye14);
        Button seviye5 = (Button) findViewById(R.id.seviye15);
        Button seviye6 = (Button) findViewById(R.id.seviye16);


        seviye1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                char[] harfler = {'b' , 'e' , 't', 'o', 'n'};
                nextActivity(v, harfler , 3, "Seviye 3.1");
            }
        });

        seviye2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                char[] harfler = {'d' , 'o' , 'l' , 'g' , 'u'};
                nextActivity(v, harfler , 4, "Seviye 3.2");
            }
        });


        final char[] randHarfler = new char[6];
        Random rastgele=new Random();
        int rast;

        for(int i=0;i<6;i++) {
            rast = rastgele.nextInt(26) + 96; //97den  122 ye kadar sayı üretiyor.
            if (rast == 96) //96 değeri asci'de harfe denk gelmiyor.O yüzden başka bir harf atıyoruz yerine.
            {
                rast += 3;
            }
            randHarfler[i] = (char)rast;
        }

        seviye3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                nextActivity(v, randHarfler , 5, "Seviye 3.3");
            }
        });

        seviye4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                nextActivity(v, randHarfler , 6, "Seviye 3.4");
            }
        });

        seviye5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                char[] harfler = {'h' , 'e' , 'l' , 'v', 'a'};
                nextActivity(v, harfler , 7, "Seviye 3.5");
            }
        });

        seviye6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                char[] harfler = {'h' , 'a' , 'y', 'n', 'i'};
                nextActivity(v, harfler , 8, "Seviye 3.6");
            }
        });


    }

        public void nextActivity(View view, char[] harfler, int hedef, String seviye){
        Intent intent = new Intent(this, seviye3.class);

        intent.putExtra("harfler",harfler);
        intent.putExtra("hedef",hedef);
        intent.putExtra("seviye",seviye);

        startActivity(intent);
    }
}

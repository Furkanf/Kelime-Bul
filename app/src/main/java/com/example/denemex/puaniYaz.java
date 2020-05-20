package com.example.denemex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class puaniYaz extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puani_yaz);

        Intent i = getIntent();
        final int puan= i.getIntExtra("puan", 0);
        final String seviye = i.getStringExtra("seviye");
        final Button kaydetButon = (Button) findViewById(R.id.kaydetButon);
        final EditText et = (EditText) findViewById(R.id.kullaniciAd);



        kaydetButon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                yuksekPuanlar(seviye , puan, et.getText().toString());
            }
        });

    }



    public void yuksekPuanlar(String seviye, int puan, String kullanici){
        FileOutputStream fos = null;
        String str = " "+seviye + ": " + puan + " puan  | " + kullanici + "\n";

        try {
            fos = openFileOutput("maksPuan.txt",  MODE_APPEND | MODE_PRIVATE);
            fos.write(str.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fos != null){
                try{
                    fos.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
        mainActivity(str);

    }


    public void mainActivity(String str){
        Intent intent = new Intent(this, MainActivity.class);

        Toast toast = Toast.makeText(getApplicationContext(),"Tebrikler. "+str + ". Kaydedildi.",Toast.LENGTH_SHORT);
        toast.show();

        startActivity(intent);
    }
}


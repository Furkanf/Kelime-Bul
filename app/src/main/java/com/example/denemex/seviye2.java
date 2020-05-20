package com.example.denemex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Vector;

public class seviye2 extends AppCompatActivity {
    Vector<String> bulunanKelimeler= new Vector<>();
    String kelime = "";
    int puan = 100;
    long start = System.currentTimeMillis();
    String seviye;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seviye2);

        Intent i = getIntent();
        char[] c= i.getCharArrayExtra("harfler");
        final int hedef = i.getIntExtra("hedef",3);
        seviye = i.getStringExtra("seviye");

        final Button harf1 = (Button) findViewById(R.id.harf1); harf1.setText(String.valueOf(c[0]));
        final Button harf2 = (Button) findViewById(R.id.harf2); harf2.setText(String.valueOf(c[1]));
        final Button harf3 = (Button) findViewById(R.id.harf3); harf3.setText(String.valueOf(c[2]));
        final Button harf4 = (Button) findViewById(R.id.harf4); harf4.setText(String.valueOf(c[3]));
        final Button kelimeGonder = (Button) findViewById(R.id.kelimeGonder);
        final Button delButton = (Button) findViewById(R.id.deleteButton);
        final Button mix = (Button) findViewById(R.id.mix);
        LinearLayout myLinearLayout = findViewById(R.id.myLinearLayout);


        harf1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                clickButon((String) harf1.getText(), harf1);
            }
        });

        harf2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                clickButon((String) harf2.getText(), harf2);
            }
        });

        harf3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                clickButon((String) harf3.getText(), harf3);
            }
        });

        harf4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                clickButon((String) harf4.getText(), harf4);
            }
        });



        delButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                delete(harf1, harf2, harf3, harf4);
            }
        });

        mix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mix(harf1,harf2,harf3,harf4);
            }
        });

        kelimeGonder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(kelime.length()>2){
                    sendWord(hedef);
                }
            }
        });

    }


    public void sendWord(int hedef){
        Toast.makeText(getApplicationContext(),"Tebrikler puaniniz: " + puan,Toast.LENGTH_LONG);
        if(!bulunanKelimeler.contains(kelime) && kelimeAra(kelime)) {
            bulunanKelimeler.add(kelime);
            addTextView(kelime);

            puan+=4;
            if(bulunanKelimeler.size()==hedef){
                puanhesapla();

                Intent intent = new Intent(this, puaniYaz.class);

                intent.putExtra("puan",puan);
                intent.putExtra("seviye",seviye);
                startActivity(intent);

            }
        }else if(bulunanKelimeler.contains(kelime)){
            puan += 0;
        }else{
            puan -= 4;
        }

        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        double seconds = (double)timeElapsed/1000;

        Toast toast = Toast.makeText(getApplicationContext(),"Anlık puanınız: " + (puan - (int)seconds),Toast.LENGTH_SHORT);
        toast.show();

        final Button harf1 = findViewById(R.id.harf1);
        final Button harf2 = findViewById(R.id.harf2);
        final Button harf3 = findViewById(R.id.harf3);
        final Button harf4 = findViewById(R.id.harf4);
        delete(harf1, harf2, harf3, harf4);
        kelime="";

    }



    public void puanhesapla(){

        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        double seconds = (double)timeElapsed/1000;

        puan -= (int) (seconds);


    }



    public void clickButon(String str, Button buton){
        TextView metin = (TextView)findViewById(R.id.metin);
        kelime = kelime.concat(str);
        buton.setVisibility(View.INVISIBLE);
        metin.setText(kelime);

    }




    public boolean kelimeAra(String kelime){
        try {
            BufferedReader br=new BufferedReader(new InputStreamReader(getAssets().open("kelimeler.txt")));
            String s;
            while((s=br.readLine())!=null)
            {
                if(kelime.equals(s)){
                    return true;
                }
            }
            return false;
        }catch(Exception e){
            Log.w(kelime, "kelimeAra: dosya bulunamadi",e );
        }
        return false;
    }


    public void mix(Button harf1,Button harf2, Button harf3, Button harf4){
        if(kelime.equals("")) {
            CharSequence c = harf2.getText();

            harf2.setText(harf1.getText());
            harf1.setText(harf4.getText());
            harf4.setText(harf3.getText());
            harf3.setText(c);
        }else{
            Log.w(kelime, "once delete yap. ");
        }
    }


    public void delete(Button harf1, Button harf2, Button harf3, Button harf4){
        harf1.setVisibility(View.VISIBLE);
        harf2.setVisibility(View.VISIBLE);
        harf3.setVisibility(View.VISIBLE);
        harf4.setVisibility(View.VISIBLE);

        kelime="";
        TextView metin = (TextView)findViewById(R.id.metin);
        metin.setText(kelime);
    }



    public void addTextView(String str){
        LinearLayout myLinearLayout = findViewById(R.id.myLinearLayout);

        final TextView rowTextView = new TextView(this);

        rowTextView.setText(str);
        rowTextView.setTextColor(Color.parseColor("#FF5722"));
        rowTextView.setTextSize(26);

        myLinearLayout.addView(rowTextView);
    }


}

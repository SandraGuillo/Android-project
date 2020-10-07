package com.example.pelemele;

import android.widget.ImageButton;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class ChronometreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chronometre);

        ImageButton demarrer = (ImageButton) findViewById(R.id.start);
        demarrer.setOnClickListener((v) -> {
            Toast.makeText(ChronometreActivity.this,"il est : "+ new GregorianCalendar().get(Calendar.HOUR_OF_DAY)+ " h " + new GregorianCalendar().get((Calendar.MINUTE))  +" min "+ new GregorianCalendar().get(Calendar.SECOND)+ " s ",Toast.LENGTH_SHORT).show();
        });

        ImageButton stop = (ImageButton) findViewById(R.id.stop);
        stop.setOnClickListener((v) -> {
            Toast.makeText(ChronometreActivity.this," il est : "+new GregorianCalendar().get(Calendar.HOUR_OF_DAY)+ " h " + new GregorianCalendar().get((Calendar.MINUTE))  +" min "+ new GregorianCalendar().get(Calendar.SECOND)+ " s ",Toast.LENGTH_SHORT).show();
        });
    }


    public int calculChrono(int heureStart, int heureStop, int minStart, int minStop, int secStart, int secStop){
        int result = 0 ;
        if (heureStart != heureStop){
            result+=(heureStop - heureStart)*60*60 ;
        }
        if (minStart != minStop){
            result += (minStop - minStart) * 60 ;
        }
        if (secStart != secStop){
            if (secStop < secStart){
                result += secStop + 60 - secStart ;
            }else{
                result += secStop - secStart ;
            }
        }
        return result ;
    }




}
package com.example.pelemele;

import android.widget.Button;
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
        Calendar calendar = new GregorianCalendar();

        ImageButton demarrer = (ImageButton) findViewById(R.id.start);
        demarrer.setOnClickListener((v) -> {
            Toast.makeText(ChronometreActivity.this,"il est : "+calendar.get(Calendar.HOUR_OF_DAY)+ " h " + calendar.get((Calendar.MINUTE))  +" min "+ calendar.get(Calendar.SECOND)+ " s ",Toast.LENGTH_SHORT).show();
        });

        ImageButton stop = (ImageButton) findViewById(R.id.stop);
        stop.setOnClickListener((v) -> {
            Toast.makeText(ChronometreActivity.this," il est : "+calendar.get(Calendar.HOUR_OF_DAY)+ " h " + calendar.get((Calendar.MINUTE))  +" min "+ calendar.get(Calendar.SECOND)+ " s ",Toast.LENGTH_SHORT).show();
        });
    }

    
}
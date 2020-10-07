package com.example.pelemele;

import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MeteoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meteo);

        ImageButton meteo = (ImageButton) findViewById(R.id.meteo);
        meteo.setOnClickListener((v) -> {

        });
    }
}
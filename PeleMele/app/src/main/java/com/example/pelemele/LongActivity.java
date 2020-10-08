package com.example.pelemele;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class LongActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_long);
        EditText saisie = (EditText)findViewById(R.id.saisie);
        Button ok = (Button) findViewById(R.id.valider);
        ok.setOnClickListener((v) -> {
            int recup = saisie.getAccessibilityLiveRegion();
            for (int i = 0 ; i < 1000 ; i++){
                recup *=recup ;//a voir
                i++;
            }
        });
        ProgressBar prog = (ProgressBar)findViewById(R.id.progressBar);

    }
}
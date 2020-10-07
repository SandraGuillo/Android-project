package com.example.pelemele;

import android.content.Intent;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button pikachu = (Button) findViewById(R.id.Pika);
        pikachu.setOnClickListener((v) -> {
            Toast.makeText(MainActivity.this,"électrik", Toast.LENGTH_SHORT).show();
        });

        Button bulbizarre = (Button) findViewById(R.id.bulbi);
        bulbizarre.setOnClickListener((v) -> {
            Toast.makeText(MainActivity.this,"plante", Toast.LENGTH_SHORT).show();
        });
        Button carapuce = (Button) findViewById(R.id.button4);
        carapuce.setOnClickListener((v) -> {
            Toast.makeText(MainActivity.this,"eau", Toast.LENGTH_SHORT).show();
        });
        Button salameche = (Button) findViewById(R.id.button3);
        salameche.setOnClickListener((v) -> {
            Toast.makeText(MainActivity.this,"feu", Toast.LENGTH_SHORT).show();
            //setContentView(R.layout.activity_chronometre);
            /*Intent ic = new Intent(MainActivity.this, ChronometreActivity.class);
            startActivity(ic);*/
        });
        ImageButton chrono = (ImageButton) findViewById(R.id.chrono) ;
        chrono.setOnClickListener((v) -> {

            Intent ic = new Intent(MainActivity.this, ChronometreActivity.class);
            startActivity(ic);
            Toast.makeText(MainActivity.this, "chronometre",Toast.LENGTH_SHORT).show();
        });
        Log.i("MainActivity","une info");

        //ImageButton chrono = (ImageButton) findViewById(R.id.imageButton);
        //Button chrono = (Button) findViewById(R.id.imageButton);
        /*chrono.setOnClickListener((v) -> {

            Intent ic = new Intent(MainActivity.this, ChronometreActivity.class);
            startActivity(ic);
        });*/

    }
    }

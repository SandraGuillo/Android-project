package com.example.pelemele;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.io.*;

public class MainActivity extends AppCompatActivity {
    static int PHOTO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button pikachu = (Button) findViewById(R.id.Pika);
        pikachu.setOnClickListener((v) -> {
            Toast.makeText(MainActivity.this, "électrik", Toast.LENGTH_SHORT).show();
        });

        Button bulbizarre = (Button) findViewById(R.id.bulbi);
        bulbizarre.setOnClickListener((v) -> {
            Toast.makeText(MainActivity.this, "plante", Toast.LENGTH_SHORT).show();
        });
        Button carapuce = (Button) findViewById(R.id.button4);
        carapuce.setOnClickListener((v) -> {
            Toast.makeText(MainActivity.this, "eau", Toast.LENGTH_SHORT).show();
        });
        Button salameche = (Button) findViewById(R.id.button3);
        salameche.setOnClickListener((v) -> {
            Toast.makeText(MainActivity.this, "feu", Toast.LENGTH_SHORT).show();
            //setContentView(R.layout.activity_chronometre);
            /*Intent ic = new Intent(MainActivity.this, ChronometreActivity.class);
            startActivity(ic);*/
        });
        ImageButton chrono = (ImageButton) findViewById(R.id.chrono);
        chrono.setOnClickListener((v) -> {

            Intent ic = new Intent(MainActivity.this, ChronometreActivity.class);
            startActivity(ic);
            Toast.makeText(MainActivity.this, "chronometre", Toast.LENGTH_SHORT).show();
        });
        Log.i("MainActivity", "une info");
        ImageButton photo = (ImageButton) findViewById(R.id.photo);
        photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (i.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(i, PHOTO);
                }
            }
        });

        ImageButton galerie = (ImageButton) findViewById(R.id.galerie);
        galerie.setOnClickListener((v) -> {
            //a faire

        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent date) {
        if (requestCode == PHOTO && resultCode == RESULT_OK) {
            Bundle extras = date.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            //Toast.makeText(PHOTO,"la photo a été prise",Toast.LENGTH_SHORT).show();//ne fonctionne pas
            FileOutputStream fos = null;
            try {
                fos = openFileOutput("image.data", MODE_PRIVATE);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            imageBitmap.compress(Bitmap.CompressFormat.PNG,100, fos);
            try {
                fos.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.quitter) {
            finish();
            return true;
        }
        return  false;
    }
}

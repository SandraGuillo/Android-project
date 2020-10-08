package com.example.pelemele;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import org.json.JSONObject;

public class MeteoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meteo);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this , new String[] {Manifest.permission.ACCESS_FINE_LOCATION},48);
        }
        final LocationManager locationManager = (LocationManager) this.getSystemService(LOCATION_SERVICE);
        ImageButton meteo = (ImageButton) findViewById(R.id.meteo);
        meteo.setOnClickListener((v) -> {
            Location loc = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            double latitude = loc.getLatitude();
            double longitude = loc.getLongitude();
            Toast.makeText(MeteoActivity.this, "latitude : " + latitude + " \nlongitude : "+longitude,Toast.LENGTH_SHORT).show();
            //AsyncTask<String,Void, JSONObject> tache meteo = ;
        });
    }
}
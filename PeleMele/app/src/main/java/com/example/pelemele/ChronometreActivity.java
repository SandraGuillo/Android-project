package com.example.pelemele;

import android.widget.ImageButton;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

public class ChronometreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chronometre);

        //bouton qu'on va utiliser pour demarrer le chrono
        ImageButton demarrer = (ImageButton) findViewById(R.id.start);
        demarrer.setOnClickListener((v) -> {
            GregorianCalendar calendarStart = new GregorianCalendar();
            Toast.makeText(ChronometreActivity.this,"il est : "+ calendarStart.get(Calendar.HOUR_OF_DAY)+ " h " + calendarStart.get((Calendar.MINUTE))  +" min "+ calendarStart.get(Calendar.SECOND)+ " s ",Toast.LENGTH_SHORT).show();
        });

        //bouton qu'on utilise pour stopper le chrono
        ImageButton stop = (ImageButton) findViewById(R.id.stop);
        stop.setOnClickListener((v) -> {
            GregorianCalendar calendarStop = new GregorianCalendar();
            Toast.makeText(ChronometreActivity.this," il est : "+calendarStop.get(Calendar.HOUR_OF_DAY)+ " h " + calendarStop.get((Calendar.MINUTE))  +" min "+ calendarStop.get(Calendar.SECOND)+ " s ",Toast.LENGTH_SHORT).show();
        });
    }

    /**
     * Fonction qui permet de gerer le chrono . elle effectue le calcule du temps a partir du lancement du jeu et au moment de l'arret
     * @param heureStart l'heure ou l'utilisateur a démarré le chrono
     * @param heureStop l'heure ou l'utilisateur a stoppé le chrono
     * @param minStart les minutes correspondant au départ du chrono
     * @param minStop les minutes correspondant au stop du chrono
     * @param secStart les secondes correspondant au départ du chrono
     * @param secStop les secondes correspondant au stop du chrono
     * @return le temps qui s'est écoulé (en seconde) entre le top départ et l'arret du chrono
     */
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

    /**
     * Petit jeu de l'application qui donne des points suivant le nombre qu'on obtient
     * @param temps le temps du chrono qui va servir a calculer le resultat du jeu
     * @return un string qui indique quel pokemon a gagné les points
     */
    public String jeuPika(int temps){
        Random alea = new Random();
        int nombreAlea = alea.nextInt(101) ;
        int result = temps + nombreAlea ;
        String reponse ;
        if((result) > 100){
            result -= 100 ;
        }
        if (result > 0 && result < 30){
            reponse = "Bravo vous avez remportez 5 points pikachu";
        }
        if (result >= 30 && result <=50){
            reponse = "Bravo vous remportez 5 points carapuce";
        }
        if (result > 50 && result <= 70){
            reponse = "Bravo vous gagnez 5 points bulbizarre";
        }else{
            reponse = "Bravo vous avez gagné 5 points salameche";
        }
        return reponse;
    }


}
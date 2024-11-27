

package com.SmartGreenhouse;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Liez ce fichier au XML

        // Initialisation des vues
        ImageView logoImage = findViewById(R.id.logoImage);
        TextView loadingText = findViewById(R.id.loadingText);

        // Exemple : modifier dynamiquement le texte (optionnel)
        loadingText.setText("Loading, please wait...");

        // Redirigez vers une autre activité après un délai
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(MainActivity.this, Activity2_premierPas.class);
            startActivity(intent);
            finish(); // Ferme l'activité Splash pour ne pas revenir en arrière
        }, 3000); // Délai de 3 secondes
    }
}

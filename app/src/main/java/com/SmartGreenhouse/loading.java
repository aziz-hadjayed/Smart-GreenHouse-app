

package com.SmartGreenhouse;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class loading extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading); // Liez ce fichier au XML
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.bleu));
        // Initialisation des vues
        ImageView logoImage = findViewById(R.id.logoImage);
        TextView loadingText = findViewById(R.id.loadingText);

        // Exemple : modifier dynamiquement le texte (optionnel)
        loadingText.setText("Loading...");

        // Redirigez vers une autre activité après un délai
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(loading.this, goto_service.class);
            startActivity(intent);
            finish(); // Ferme l'activité Splash pour ne pas revenir en arrière
        }, 3000); // Délai de 3 secondes
    }
}

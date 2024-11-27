package com.SmartGreenhouse;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Activity2_premierPas extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_activity2_premier_pas);



        // Initialisation des vues
        ImageView logoImage = findViewById(R.id.logoImage);
        TextView AppName = findViewById(R.id.app_name);
        TextView appName1 = findViewById(R.id.app_name1);
        Button continueButton = findViewById(R.id.continueButton);
        Button closeButton = findViewById(R.id.closeButton);




        // Gestion de l'événement du bouton "CONTINUE TO SERVICE"
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Démarrer une nouvelle activité (par exemple, la page principale)
                Intent intent1 = new Intent(Activity2_premierPas.this, activity_consult_data.class);
                startActivity(intent1);
            }
        });




        // Gestion de l'événement du bouton "CLOSE"
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Fermer l'application
                finish();
            }
        });





    }
}

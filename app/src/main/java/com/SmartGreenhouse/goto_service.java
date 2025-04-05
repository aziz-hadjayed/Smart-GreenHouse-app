package com.SmartGreenhouse;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class goto_service extends AppCompatActivity
{


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_goto_service);
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.bleu));



        // Initialisation des vues
        ImageView logoImage = findViewById(R.id.logoImage);
        TextView AppName = findViewById(R.id.app_name);
        TextView appName1 = findViewById(R.id.app_name1);
        Button continueButton = findViewById(R.id.continueButton);
        Button closeButton = findViewById(R.id.closeButton);




        // Gestion de l'événement du bouton "CONTINUE TO SERVICE"
        continueButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View c)
            {
                // Démarrer une nouvelle activité (par exemple, la page principale)
                Intent intent1 = new Intent(goto_service.this, consult_data.class);
                startActivity(intent1);

            }
        });




        // Gestion de l'événement du bouton "CLOSE"
        closeButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // Fermer l'application
                finish();
            }
        });

    }
}

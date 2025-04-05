package com.SmartGreenhouse;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class documentation extends AppCompatActivity
{



    private TableLayout tableLayout;

    private Button btnConsultDatajava;
    private Button btnControljava;
    private Button btnDocumentationjava;




    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_documentation);
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.green2));


// Initialisation des widgets
        btnConsultDatajava = findViewById(R.id.btnConsultData);
        btnControljava = findViewById(R.id.btnControl);
        btnDocumentationjava = findViewById(R.id.btnDocumentation);


        // Ajouter des actions pour les boutons
        btnConsultDatajava.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(documentation.this, "Consult Data clicked!", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(documentation.this, consult_data.class);
                startActivity(intent1);
            }
        });

        btnControljava.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(documentation.this, "Control clicked!", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(documentation.this, control.class);
                startActivity(intent1);
            }
        });

//        btnDocumentationjava.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(documentation.this, "Documentation clicked!", Toast.LENGTH_SHORT).show();
//                Intent intent1 = new Intent(documentation.this, documentation.class);
//                startActivity(intent1);
//            }
//        });




        tableLayout = findViewById(R.id.tableLayout);






    }

    private void addDataToTable() {
        // Données des cultures
        String[][] data =
                {
                        {"Tomate", "Lumière : 60%, T : 25°C, Humidité de l'air : 60%"},
                        {"Pomme de Terre", "Lumière : 50%, Température : 21°C, Humidité de l'air : 70%"},
                        {"Laitue", "Lumière : 50%, Température : 15°C, Humidité de l'air : 70%"},
                        {"Fraise", "Lumière : 60%, Température : 20°C, Humidité de l'air : 65%"},
                        {"Poivron", "Lumière : 70%, Température : 27.5°C, Humidité de l'air : 60%"},
                        {"Concombre", "Lumière : 60%, Température : 26°C, Humidité de l'air : 70%"},
                        {"Carotte", "Lumière : 50%, Température : 20°C, Humidité de l'air : 60%"},
                        {"Épinard", "Lumière : 50%, Température : 16°C, Humidité de l'air : 70%"},
                        {"Oignon", "Lumière : 50%, Température : 20°C, Humidité de l'air : 60%"},
                        {"Aubergine", "Lumière : 70%, Température : 27.5°C, Humidité de l'air : 60%"},
                        {"Melon", "Lumière : 70%, Température : 30°C, Humidité de l'air : 50%"},
                        {"Blé", "Lumière : 60%, Température : 20°C, Humidité de l'air : 60%"}
                };

        // Ajouter chaque ligne au tableau
        for (String[] row : data) {
            TableRow tableRow = new TableRow(this);
            tableRow.setLayoutParams(
                    new TableRow.LayoutParams(
                            TableRow.LayoutParams.MATCH_PARENT , TableRow.LayoutParams.WRAP_CONTENT)  );

            // Colonne 1 : Nom de la culture
            TextView cultureTextView = new TextView(this);
            cultureTextView.setText(row[0]);
            cultureTextView.setPadding(8, 8, 8, 8);
            cultureTextView.setLayoutParams(new TableRow.LayoutParams(
                    TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT)  );

            // Colonne 2 : Conditions
            TextView conditionTextView = new TextView(this);
            conditionTextView.setText(row[1]);
            conditionTextView.setPadding(8, 8, 8, 8);
            conditionTextView.setLayoutParams(new TableRow.LayoutParams(
                    TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT)  );

            // Ajouter les colonnes à la ligne
            tableRow.addView(cultureTextView);
            tableRow.addView(conditionTextView);

            // Ajouter la ligne au tableau
            tableLayout.addView(tableRow);

            // Affichage des logs pour débogage
            Log.d("DocumentationActivity", "Ligne ajoutée : " + row[0] + " - " + row[1]);
        }
    }
}


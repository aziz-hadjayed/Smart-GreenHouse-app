package com.SmartGreenhouse;

import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;

public class documentation extends AppCompatActivity {

    private TableLayout tableLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_documentation);

        tableLayout = findViewById(R.id.tableLayout);

        // Ajouter les données au tableau
        addDataToTable();
    }

    private void addDataToTable() {
        // Données des cultures
        String[][] data = {
                {"Tomate", "Lumière : 50-70%, Température : 20-30°C, Humidité de l'air : 50-70%"},
                {"Pomme de Terre", "Lumière : 40-60%, Température : 18-25°C, Humidité de l'air : 60-80%"},
                {"Laitue", "Lumière : 40-60%, Température : 10-20°C, Humidité de l'air : 60-80%"},
                {"Fraise", "Lumière : 50-70%, Température : 15-25°C, Humidité de l'air : 60-70%"},
                {"Poivron", "Lumière : 60-80%, Température : 20-35°C, Humidité de l'air : 50-70%"},
                {"Concombre", "Lumière : 50-70%, Température : 22-30°C, Humidité de l'air : 60-80%"},
                {"Carotte", "Lumière : 40-60%, Température : 15-25°C, Humidité de l'air : 50-70%"},
                {"Épinard", "Lumière : 40-60%, Température : 10-22°C, Humidité de l'air : 60-80%"},
                {"Oignon", "Lumière : 40-60%, Température : 15-25°C, Humidité de l'air : 50-70%"},
                {"Aubergine", "Lumière : 60-80%, Température : 20-35°C, Humidité de l'air : 50-70%"},
                {"Melon", "Lumière : 60-80%, Température : 25-35°C, Humidité de l'air : 40-60%"},
                {"Blé", "Lumière : 50-70%, Température : 15-25°C, Humidité de l'air : 50-70%"}
        };

        // Ajouter chaque ligne au tableau
        for (String[] row : data) {
            TableRow tableRow = new TableRow(this);
            tableRow.setLayoutParams(new TableRow.LayoutParams(
                    TableRow.LayoutParams.MATCH_PARENT,
                    TableRow.LayoutParams.WRAP_CONTENT));

            // Colonne 1 : Nom de la culture
            TextView cultureTextView = new TextView(this);
            cultureTextView.setText(row[0]);
            cultureTextView.setPadding(8, 8, 8, 8);
            cultureTextView.setLayoutParams(new TableRow.LayoutParams(
                    TableRow.LayoutParams.WRAP_CONTENT,
                    TableRow.LayoutParams.WRAP_CONTENT));

            // Colonne 2 : Conditions
            TextView conditionTextView = new TextView(this);
            conditionTextView.setText(row[1]);
            conditionTextView.setPadding(8, 8, 8, 8);
            conditionTextView.setLayoutParams(new TableRow.LayoutParams(
                    TableRow.LayoutParams.WRAP_CONTENT,
                    TableRow.LayoutParams.WRAP_CONTENT));

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


package com.SmartGreenhouse;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class activity_consult_data extends AppCompatActivity {

    private Button btnConsultDatajava;
    private Button btnControljava;
    private Button btnDocumentationjava;
    private ListView dataListViewjava;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consult_data);

        // Initialisation des widgets
        btnConsultDatajava = findViewById(R.id.btnConsultData);
        btnControljava = findViewById(R.id.btnControl);
        btnDocumentationjava = findViewById(R.id.btnDocumentation);
        dataListViewjava = findViewById(R.id.dataListView);

        // Ajouter des actions pour les boutons
        btnConsultDatajava.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity_consult_data.this, "Consult Data clicked!", Toast.LENGTH_SHORT).show();
            }
        });

        btnControljava.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity_consult_data.this, "Control clicked!", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(activity_consult_data.this, control.class);
                startActivity(intent1);
            }
        });

        btnDocumentationjava.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity_consult_data.this, "Documentation clicked!", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(activity_consult_data.this, documentation.class);
                startActivity(intent1);
            }
        });

        // Préparer les données pour la ListView
        List<ListItem> data = new ArrayList<>();
        data.add(new ListItem("Lighting", R.drawable.lumineuse_icon));  // Assurez-vous que l'icône est nommée correctement
        data.add(new ListItem("Temperature", R.drawable.temperature_icon));  // Vérifiez le nom de l'icône
        data.add(new ListItem("Humidity Air", R.drawable.humidite_icon));  // Idem pour l'humidité
        data.add(new ListItem("Humidity Soil", R.drawable.humidite_icon));  // Humidité sol, la même icône peut être utilisée
        data.add(new ListItem("CO2", R.drawable.co2_icon));  // Vérifiez que le fichier co2_Icon existe


        // Configurer l'adaptateur personnalisé
        CustomAdapter adapter = new CustomAdapter(this, R.layout.list_item, data);
        dataListViewjava.setAdapter(adapter);
    }
}

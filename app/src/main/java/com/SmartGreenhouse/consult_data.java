package com.SmartGreenhouse;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class consult_data extends AppCompatActivity
{

    private Button btnConsultDatajava;
    private Button btnControljava;
    private Button btnDocumentationjava;
    private ListView dataListViewjava;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consult_data);
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.green2));

        // Initialisation des widgets
        btnConsultDatajava = findViewById(R.id.btnConsultData);
        btnControljava = findViewById(R.id.btnControl);
        btnDocumentationjava = findViewById(R.id.btnDocumentation);
        dataListViewjava = findViewById(R.id.dataListView);

        // Ajouter des actions pour les boutons
        btnConsultDatajava.setOnClickListener(v -> {
            Toast.makeText(consult_data.this, "Consult Data clicked!", Toast.LENGTH_SHORT).show();
            Intent intent1 = new Intent(consult_data.this, consult_data.class);
            startActivity(intent1);
       });

        btnControljava.setOnClickListener(v -> {
            Toast.makeText(consult_data.this, "Control clicked!", Toast.LENGTH_SHORT).show();
            Intent intent1 = new Intent(consult_data.this, control.class);
            startActivity(intent1);
        });

        btnDocumentationjava.setOnClickListener(v -> {
            Toast.makeText(consult_data.this, "Documentation clicked!", Toast.LENGTH_SHORT).show();
            Intent intent1 = new Intent(consult_data.this, documentation.class);
            startActivity(intent1);
        });






        // Préparer la connexion à Firebase
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("SensorData");

        // Liste pour stocker les données récupérées
        List<Item> data = new ArrayList<>();


        // Récupérer les données depuis Firebase
        databaseReference.addValueEventListener(new ValueEventListener()
        {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {
                data.clear(); // Effacer les données précédentes

                for (DataSnapshot snapshot : dataSnapshot.getChildren())
                {
                    // Vérifier que le snapshot n'est pas nul
                    if (snapshot.getValue() != null)
                    {
                        // Parcourir les enfants de chaque nœud
                        for (DataSnapshot childSnapshot : snapshot.getChildren())
                        {
                            String name = childSnapshot.getKey(); // Nom du capteur (Co2, HumiditySol, etc.)
                            Long value = childSnapshot.getValue(Long.class); // Valeur du capteur

                            // Ajouter les données dans la liste
                            int iconRes = getIconResourceByName(name); // Récupérer l'icône en fonction du capteur
                            data.add(new Item(name, value != null ? value.toString() : "N/A", iconRes));
                        }
                    }
                }

                // Mettre à jour l'adaptateur pour la ListView
                CustomAdapter adapter = new CustomAdapter(consult_data.this, R.layout.list_item, data);
                dataListViewjava.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError)
            {
                Toast.makeText(consult_data.this, "Failed to load data from Firebase.", Toast.LENGTH_SHORT).show();
            }
        });
    }



    // Fonction pour associer les noms des capteurs aux icônes correspondantes
    private int getIconResourceByName(String name) {
        switch (name)
        {
            case "Co2":
                return R.drawable.co2_icon;
            case "HumiditySol":
                return R.drawable.humidite_icon;
            case "HumidityAir":
                return R.drawable.humidite_icon;
            case "Temperature":
                return R.drawable.temperature_icon;
            case "Lighting":
                return R.drawable.lumineuse_icon;
            default:
                return R.drawable.smart_greenhouse1; // Icône par défaut si aucun match
        }
    }
}

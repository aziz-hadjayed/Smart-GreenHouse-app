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

import com.SmartGreenhouse.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.ArrayList;
import java.util.List;

public class control extends AppCompatActivity {
    private ListView listView;
    private ItemAdapter1 adapter;
    private List<Item1> itemList;
    private DatabaseReference databaseReference;

    private Button btnConsultDatajava1;
    private Button btnControljava1;
    private Button btnDocumentationjava1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control);
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.green2));

        // Initialisation des widgets
        btnConsultDatajava1 = findViewById(R.id.btnConsultData1);
        btnControljava1 = findViewById(R.id.btnControl1);
        btnDocumentationjava1 = findViewById(R.id.btnDocumentation1);


        // Ajouter des actions pour les boutons
        btnConsultDatajava1.setOnClickListener(v -> {
            Toast.makeText(control.this, "Consult Data clicked!", Toast.LENGTH_SHORT).show();
            Intent intent1 = new Intent(control.this, consult_data.class);
            startActivity(intent1);
        });

        btnControljava1.setOnClickListener(v -> {
            Toast.makeText(control.this, "Control clicked!", Toast.LENGTH_SHORT).show();
            Intent intent1 = new Intent(control.this, control.class);
            startActivity(intent1);
        });

        btnDocumentationjava1.setOnClickListener(v -> {
            Toast.makeText(control.this, "Documentation clicked!", Toast.LENGTH_SHORT).show();
            Intent intent1 = new Intent(control.this, documentation.class);
            startActivity(intent1);
        });

        listView = findViewById(R.id.list_view);
        databaseReference = FirebaseDatabase.getInstance().getReference("items");

        // Initialiser la liste avec des titres et icônes spécifiques
        itemList = new ArrayList<>();
        itemList.add(new Item1("Co2Moy", "", R.drawable.co2_icon));
        itemList.add(new Item1("HumiditySolMoy", "", R.drawable.humidite_icon));
        itemList.add(new Item1("HumidityAirMoy", "", R.drawable.humidite_icon));
        itemList.add(new Item1("TemperatureMoy", "", R.drawable.temperature_icon));
        itemList.add(new Item1("LightingMoy", "", R.drawable.lumineuse_icon));

        // Configurer l'adaptateur
        adapter = new ItemAdapter1(this, itemList);
        listView.setAdapter(adapter);

        // Bouton global pour sauvegarder les données
        findViewById(R.id.btnControl1).setOnClickListener(v -> saveDataToFirebase());
    }

    private void saveDataToFirebase() {
        for (Item1 item : itemList) {
            databaseReference.child(item.getTitle()).setValue(item.getValue());
        }
    }
}
